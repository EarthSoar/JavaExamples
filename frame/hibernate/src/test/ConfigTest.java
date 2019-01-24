package test;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import hello.dao.IUserDAO;
import hello.dao.impl.UserDAOImpl;
import hello.domain.User;
import util.HibernateUtil;

public class ConfigTest {
	private IUserDAO dao = new UserDAOImpl();

	@Before
	public void testSave() {
		User user = new User();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();//设置事务活动状态
		/**
		 * 在没有事务的环境下save还会发送sql,persist不会发送sql  保存对象一定要在事务的环境下才可以成功
		 * persist是为了时下JPA规范 
		 */
		session.save(user);
		//session.persist(user);
		session.getTransaction().commit();//提交事务
		session.close();
	}
	
	@Test
	public void testGet() {
		Session session = HibernateUtil.getSession();
		System.out.println("----");
		/**
		 * get方法：数据库存在返回的user不为null,反之返回 null。并且会立刻发出sql
		 */
		//User user = (User) session.get(User.class, 2L);
		
		/**
		 * load方法: 返回的user对象始终不为null,并且 在使用费OID属性的时候才会发出sql语句 
		 *	创建了代理对象 User_$$_jvst42_0 .所以始终返回的不是null
		 */
		User user = (User) session.load(User.class, 1L);
		System.out.println("----");
		if(user == null) {
			System.out.println("user为null");
		}else {
			System.out.println("user不为null");
		}
		System.out.println(user.getClass());//class hello.domain.User_$$_jvst42_0  --load
		user.getName();
		session.close();
	}
	@Test
	public void test() {
		User user = new User();//刚被 new出来 处于临时状态
		user.setName("giao");//设置的是非OID属性,属性并没有OID,依然处于临时状态
		user.setId(1L);//属性有了OID,此时 处于 游离状态
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();//设置事务活动状态
		/**
		 *情况1.session.delete(user);//删除处于游离状态的属性,属性进入删除状态
		 * 
		 *情况2.先  session.get(user)使得对象处于持久化状态 
		 *	后调用session.delete(user);对象进入了删除状态 
		 */
		System.out.println(user.getId());//还存在OID,在事务提交后才会真正的从数据库删除
		
		session.getTransaction().commit();//提交事务
		session.close();
	}
	@Test
	public void testDelete() {
		User user = new User();
		user.setId(1L);
		dao.delete(user);
	}
}
