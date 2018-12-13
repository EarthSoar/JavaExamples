package dao;

import java.util.List;

import damain.Product;
import page.PageResult;
import query.ProductQueryObject;

public interface IProductDAO {
	void save(Product pro);
	void delete(Long id);
	void update(Product pro);
	Product get(Long id);
	List<Product> list(ProductQueryObject qo);
	
	/**
	 * 查询分页数据
	 * @param currentPage 当前页
	 * @param pageSize   当前页显示数据的多少
	 * @return	页面结果对象
	 */
	PageResult queryPage(Integer currentPage,Integer pageSize);
}
