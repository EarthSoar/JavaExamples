package ddl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * @author 15626 ��ȷ�����쳣
 */
public class CatchException {
	@Test
	public void testCatchException() {
		// ������Դ�Ĵ���
		String sql = "CREATE TABLE s_student(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(10) NOT NULL UNIQUE,age INT)";
		Connection conn = null;
		Statement st = null;
		try {// ���ܳ����쳣�Ĵ���
				// 1.����ע������
			Class.forName("com.mysql.jdbc.Driver");
			// 2.��ȡ���Ӷ���
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin");
			// 3.��ȡ������
			st = conn.createStatement();
			// 4.ִ��sql���
			st.executeUpdate(sql);
		} catch (Exception e) {// �����쳣
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
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
		//1.����ע������/
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
