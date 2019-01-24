package hibernateAPI;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import hello.domain.User;

public class ConfigurationTest {
	/**
	 *	Hibernate3.x
	 *	1.把 所有的连接数据库的配置放在  hibernate.cfg.xml文件中 
	 *	2.创建SessionFactory对象用buildSessionFactory方法
	 */
	@Test
	public void test() throws Exception {
		Configuration config = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sf = config.buildSessionFactory();
		System.out.println(sf.openSession().get(User.class, 1L));
	}
	
	/**
	 *	Hibdernate4.x
	 *	1.把所有连接数据库的配置放在hibernate.properties文件中,在hibernate.cfg.xml文件中 只存在关联映射的配置
	 *	2.创建SessionFactory对象使用 
	 * config.buildSessionFactory(new StandardServiceRegistryBuilder().build());
	 */
	
	@Test
	public void test2() throws Exception {
		Configuration config = new Configuration().configure();
		SessionFactory sf = config.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		System.out.println(sf.openSession().get(User.class, 1L));
	}
	
	/**
	 * 	无需配置文件，直接在程序中硬编码
	 */
	
	@Test
	public void test3() throws Exception {
		Configuration config = new Configuration();
		//设置数据库连接的要素
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		config.setProperty("hibernate.connection.url", "jdbc:mysql:///demo");
		config.setProperty("hibernate.connection.username", "root");
		config.setProperty("hibernate.connection.password", "admin");
		//指定关联实体domain
		config.addClass(User.class);
		
		@SuppressWarnings("deprecation")
		SessionFactory sf = config.buildSessionFactory();
		System.out.println(sf.openSession().get(User.class, 1L));
	}
}
