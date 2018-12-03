package test;

import java.util.List;

import org.junit.jupiter.api.Test;

import damain.ProductDir;
import dao.IProductDirDAO;
import dao.impl.ProductDirDAOImpl;

class ProductDirDAOTest {

	IProductDirDAO dirDAO = new ProductDirDAOImpl();
	@Test
	void testList() {
		List<ProductDir> list = dirDAO.list();
		for (ProductDir dir : list) {
			System.out.println(dir);
		}
	}

}
