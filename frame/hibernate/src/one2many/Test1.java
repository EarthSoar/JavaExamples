package one2many;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import util.HibernateUtil;

public class Test1 {
	@Before
	public void testSave() {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Department d = new Department();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		e1.setName("李四");
		e2.setName("张三");
		d.setName("部门");
		
		d.getEmps().add(e1);
		d.getEmps().add(e2);
		/**
		 * 保存操作会发送两条更新sql，是由One方发出为了维护关系去给many表中设置外键的值
		 */
		
		session.save(d);
		session.save(e1);
		session.save(e2);

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testGet() {
		Session session = HibernateUtil.getSession();
		Department d = (Department) session.get(Department.class, 1L);	
		/**
		 * 从one中得到many对象 也是延迟加载,得到的集合实现的是Set接口,所以使用集合必须用接口
		 */
		Set<Employee> set = d.getEmps();
		System.out.println(set.getClass());
		System.out.println();
		System.out.println(d);
		session.close();		
	}
}
