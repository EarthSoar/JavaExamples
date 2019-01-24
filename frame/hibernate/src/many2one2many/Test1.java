package many2one2many;

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
		
		e1.setDept(d);
		e2.setDept(d);
		d.getEmps().add(e1);
		d.getEmps().add(e2);
		/**
		 * 保存操作会发送两条更新sql，是由One方发出为了维护关系去给many表中设置外键的值
		 * 在配置文件中设置集合元素的属性为inverse="true"  让one方放弃对many的管理从而减少额外的sql发送
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
		Set<Employee> set = d.getEmps();
		System.out.println(set);
		System.out.println(d);
		session.close();		
	}
	
	@Test
	public void testDelete() {
		Session session = HibernateUtil.getSession();
		Department d = (Department) session.get(Department.class, 1L);	
		session.delete(d);
		session.close();		
	}
}
