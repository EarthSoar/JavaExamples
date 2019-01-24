package hibernateAPI;

import org.hibernate.Session;

import util.HibernateUtil;

//标准处理事务的模板方法
public class TransactionTest {

	public void test() {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();// 事务处于活动状态
			// 具体操作事务
			session.getTransaction().commit();
		} catch (Exception e) {
			// 回滚事务 1.session不能为空 2,事务必须处于活动状态
			if (session != null && session.getTransaction().isActive()) {
				session.getTransaction().rollback();
			}
		} finally {
			// 1.保证session不为空 2.保证session前面没有被关闭过
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
}
