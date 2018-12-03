package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import damain.Product;
import dao.IProductDAO;
import dao.impl.ProductDAOImpl;

class ProductDAOTest {
	private IProductDAO dao = new ProductDAOImpl();
	@Test
	void testSave() {
	}

	@Test
	void testDelete() {
	}

	@Test
	void testUpdate() {
		
	}

	@Test
	void testGet() {
		Product pro = dao.get(3L);
		System.out.println(pro);
	}

	@Test
	void testList() {
		List<Product> list = new ArrayList<>();
		list = dao.list();
		for (Product product : list) {
			System.out.println(product);
		}
	}
}
