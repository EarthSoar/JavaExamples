package ddl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * @author 15626 正确处理异常
 */
public class CatchException {
	@Test
	public void testCatchException() {
		// 声明资源的代码
		String sql = "CREATE TABLE s_student(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(10) NOT NULL UNIQUE,age INT)";
		Connection conn = null;
		Statement st = null;
		try {// 可能出现异常的代码
				// 1.记载注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获取连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin");
			// 3.获取语句对象
			st = conn.createStatement();
			// 4.执行sql语句
			st.executeUpdate(sql);
		} catch (Exception e) {// 处理异常
			e.printStackTrace();
		} finally {
			// 5.释放资源
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Test
	public void testCatchExceptionByjava7() {
		String sql = "CREATE TABLE s_student(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(10) NOT NULL UNIQUE,age INT)";
		//1.记载注册驱动/
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try(
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","admin");	
			Statement st = conn.createStatement();
		){
			st.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
