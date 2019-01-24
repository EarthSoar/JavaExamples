package hello.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hello.dao.IUserDAO;
import hello.domain.User;

@SuppressWarnings("all")
public class UserDAOImpl implements IUserDAO {

	@Override
	@SuppressWarnings("all")
	public void save(User user) {
		// 1.创建配置对象,读取配置文件
		Configuration config = new Configuration().configure();
		// 2.获取SessionFactory对象
		SessionFactory sf = config.buildSessionFactory();
		// 3.获取Session对象
		Session session = sf.openSession();
		// 4.激活事务
		Transaction tx = session.beginTransaction();
		// 5.具体操作(DML语句)
		session.save(user);// INSERT INTO 表名
		// 6.提交事务
		session.getTransaction().commit();
		// 7.关闭session
		session.close();
		// 8.关闭SessionFactory
		sf.close();
	}

	@Override
	public void delete(User user) {
		Configuration config = new Configuration().configure();
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	@Override
	public void update(User user) {
		Configuration config = new Configuration().configure();
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	@Override
	public User get(Long id) {
		// 1.创建配置对象
		Configuration config = new Configuration();
		// 2.读取配置文件
		config.configure("/hibernate.cfg.xml");
		// 3.创建SessionFactory.
		@SuppressWarnings("deprecation")
		SessionFactory sf = config.buildSessionFactory();
		// 4.获取Session
		Session session = sf.openSession();
		// 5.具体的查询操作 SELECT * FROM 表名 WHERE id = ?
		User user = (User) session.get(User.class, id);
		// 6.关闭session
		session.close();
		// 7.关闭SessionFactory
		sf.close();

		return user;
	}

	@Override
	@SuppressWarnings("all")
	public List<User> list() {
		// 1.创建配置对象读取配置文件
		Configuration config = new Configuration().configure();
		// 2.创建SessionFactory对象
		SessionFactory sf = config.buildSessionFactory();
		// 获取Session对象
		Session session = sf.openSession();
		// 查询操作
		String hql = "SELECT u FROM User u";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		// 关闭session
		session.close();
		sf.close();
		return list;
	}
}
