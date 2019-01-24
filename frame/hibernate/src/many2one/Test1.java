package many2one;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;

public class Test1 {
	@Test
	public void testSave() {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Department d = new Department();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		e1.setDept(d);
		e1.setName("张三");
		e2.setDept(d);
		e2.setName("张三");
		d.setName("部门");

		/**
		 * 先保存one方是3条sql，先保存many方式5条sql多了2条更新语句
		 * 因为如果先保存的是many方的话，外键属性的值是为null的，然后在保存one方,one方对象由临时状态变成了持久化状态
		 * 导致了many方变成了脏数据，因此在提交事务时候需要同步,发送两条更新语句
		 */
		session.save(d);
		session.save(e1);
		session.save(e2);

		System.out.println("----");
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testGet() {
		Session session = HibernateUtil.getSession();

		Employee e = (Employee) session.get(Employee.class, 1L);
		Department d = e.getDept();
		System.out.println("------");
		/**
		 * 从many方得到one使用的是延时加载，对象是代理对象
		 */
		// d.getName();
		// d.getName();
		System.out.println(e);
		Hibernate.initialize(d);// 初始化延时加载对象
		session.close();
		// System.out.println(d);因为这是延迟加载，所有还必须发一条sql，必须在session前面得到d
	}
}
