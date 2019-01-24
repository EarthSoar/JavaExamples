package hibernateAPI;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import hello.domain.User;
import util.HibernateUtil;

@SuppressWarnings("all")
public class QueryTest {
	// 查询名字中包含test,且id在1~10之间的

	@Test
	public void testQuery() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT u FROM User u WHERE u.name LIKE ? AND u.id BETWEEN ? AND ? ";
		Query query = session.createQuery(hql);
		List<User> list = query.setString(0, "%test%").setLong(1, 1L).setLong(2, 10L).list();
		session.close();
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testCriteria() throws Exception {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.like("name", "test", MatchMode.ANYWHERE));
		criteria.add(Restrictions.between("id", 1L, 10L));
		List<User> list = criteria.list();
		session.close();
		for (User user : list) {
			System.out.println(user);
		}
	}
}
