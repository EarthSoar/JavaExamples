package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import damain.Product;
import dao.IProductDAO;
import dao.impl.ProductDAOImpl;
import query.ProductQueryObject;

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
		Product pro = new Product(35L, "HHH", "HHH","HHH" , new BigDecimal(200), new BigDecimal(200), 0.1,1L);
		dao.update(pro);
	}

	@Test
	void testGet() {
		Product pro = dao.get(3L);
		System.out.println(pro);
	}

	@Test
	void testList() {
		List<Product> list = new ArrayList<>();
		ProductQueryObject qo = new ProductQueryObject();
		qo.setProductName("M");
		qo.setMaxSalePrice(new BigDecimal(200));
		qo.setMinSalePrice(new BigDecimal(100));
		list = dao.list(qo);
		System.out.println(list.size());
		for (Product product : list) {
			System.out.println(product);
		}
	}
}
