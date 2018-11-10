package dql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class DQLTest {
	/*
	  	+----+------+-----+
		| id | name | age |
		+----+------+-----+
		|  1 | 价廉    |  18 |
		+----+------+-----+
		1 row in set
	 */
	@Test
	public void testQuerySigle() throws Exception {
		String sql = "SELECT * FROM s_student WHERE id = 1";
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin");
		//获取语句对象
		Statement st = conn.createStatement();
		//执行sql语句
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			long id = rs.getLong("id");
			long age = rs.getLong("age");
			String name = rs.getString("name");
			System.out.println(id + "," + age +"," + name);
		}
		rs.close();
		st.close();
		conn.close();
	}
	
	@Test
	public void testAll() throws Exception {
		String sql = "SELECT * FROM s_student";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","admin");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			String name = rs.getString("name");
			long id = rs.getLong("id");
			long age = rs.getLong("age");
			System.out.println(name + "," + id +"," + age);
		}
		rs.close();
		st.close();
		conn.close();
	}
}
