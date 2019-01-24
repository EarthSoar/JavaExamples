package hello;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import hello.dao.IUserDAO;
import hello.dao.impl.UserDAOImpl;
import hello.domain.User;

class UserDAOTest {
	private IUserDAO dao = new UserDAOImpl();

	@Test
	void testSave() {
		User user = dao.get(1L);
		for (int i = 1; i < 10; i++) {
			user.setName("test" + i);
			user.setId(null);
			dao.save(user);
		}
	}

	@Test
	void testDelete() {
		User user = new User();
		user.setId(11L);
		dao.delete(user);
	}

	@Test
	void testUpdate() {
		User user = dao.get(10L);
		user.setSalary(new BigDecimal(20000));
		dao.update(user);
	}

	@Test
	void testGet() {
		User user = dao.get(1L);
		System.out.println(user);
	}

	@Test
	void testList() {
		List<User> list = dao.list();
		for (User user : list) {
			System.out.println(user);
		}
	}

}
