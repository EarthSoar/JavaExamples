package dml;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

/**
 * @author 15626
 *	
 */
public class DMLTest {
	@Test   //向表中添加行数据
	public void testInsert() throws Exception {
		String sql = "INSERT INTO s_student(name,age) VALUES('西门吹雪',18),('王熙凤',19)";
		//1.加载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin");
		//3.获取语句对象
		Statement st = conn.createStatement();
		//4.执行sql语句
		int ret = st.executeUpdate(sql);
		System.out.println("受影响的行数"+ret);
		//5.关闭资源
		st.close();
		conn.close();
	}
	@Test
	public void testDelete() throws Exception {
		String sql = "DELETE FROM s_student WHERE name = '西门吹雪'";
		//1.记载注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin");
		//3获取语句对象
		Statement st = conn.createStatement();
		//4.执行sql语句
		st.executeUpdate(sql);
		//5.释放资源
		st.close();
		conn.close();
	}
	@Test
	public void testUpdate() throws Exception {
		String sql = "UPDATE s_student SET age = 99 WHERE id = 3";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin");
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
		st.close();
		conn.close();
	}
}
