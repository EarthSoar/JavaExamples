package service;

import damain.Product;
import page.PageResult;
import query.ProductQueryObject;

public interface IProductService {
	void save(Product pro);
	void delete(Long id);
	void update(Product pro);
	Product get(Long id);
	//高级查询+分页
	PageResult query(ProductQueryObject qo);
}
