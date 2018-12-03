package dao;

import java.util.List;

import damain.ProductDir;

public interface IProductDirDAO {
	void save(ProductDir dir);
	
	void delete(Long id);
	
	void update(ProductDir dir);
	
	ProductDir get(Long id);
	
	List<ProductDir> list();
}
