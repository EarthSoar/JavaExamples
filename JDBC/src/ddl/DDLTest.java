package ddl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class DDLTest {
	@Test
	public void testCreateTab() throws Exception {
		String sql = "CREATE TABLE s_student(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(10) NOT NULL UNIQUE,age INT)";
		//1.����ע������/
		Class.forName("com.mysql.jdbc.Driver");
		//2.��ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", 
				"root", "admin");
		//3.����������
		Statement st = conn.createStatement();
		//4.ִ��SQL���
		st.executeUpdate(sql);
		//5.�ͷ���Դ
		st.close();
		conn.close();
	}
}
