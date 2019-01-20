package service.impl;

import damain.Product;
import dao.IProductDAO;
import exception.LogicException;
import factoy.BeanFactoy;
import page.PageResult;
import query.ProductQueryObject;
import service.IProductService;

public class ProductServiceImpl implements IProductService {
	private IProductDAO dao = BeanFactoy.INSTANCE.getBean("productDAO", IProductDAO.class);

	@Override
	// 业务方法,限制商品名称不能 重复
	public void save(Product pro) {
		Product current = dao.getProductByName(pro.getProductName());
		if (current != null) {
			// 数据库中存在相同名称,给调用者抛出一个异常
			throw new LogicException("对不起," + current.getProductName() + "已经存在,换一个试试");
		}
		dao.save(pro);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public void update(Product pro) {
		dao.update(pro);
	}

	@Override
	public Product get(Long id) {
		return dao.get(id);
	}

	@Override
	public PageResult query(ProductQueryObject qo) {
		return dao.query(qo);
	}
}
