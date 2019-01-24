package hibernateAPI;

import org.hibernate.Session;
import org.junit.Test;

import hello.domain.User;
import util.HibernateUtil;

public class SessionTest {
	@Test
	public void testSession() throws Exception {
		Session session = HibernateUtil.getSession();
		User u1 = (User) session.get(User.class, 1L);//配置展示 sql后可以在控制台看到拼的sql语句
		System.out.println("====");
		session.clear();//消除一级缓存
		User u2 = (User) session.get(User.class, 1L);
		System.out.println(u1 + "," + u2);
	}
}
