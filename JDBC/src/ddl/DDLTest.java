package ddl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class DDLTest {
	@Test
	public void testCreateTab() throws Exception {
		String sql = "CREATE TABLE s_student(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(10) NOT NULL UNIQUE,age INT)";
		//1.记载注册驱动/
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", 
				"root", "admin");
		//3.创建语句对象
		Statement st = conn.createStatement();
		//4.执行SQL语句
		st.executeUpdate(sql);
		//5.释放资源
		st.close();
		conn.close();
	}
}
