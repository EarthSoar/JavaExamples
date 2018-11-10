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
	@Test   //��������������
	public void testInsert() throws Exception {
		String sql = "INSERT INTO s_student(name,age) VALUES('���Ŵ�ѩ',18),('������',19)";
		//1.����ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2.��ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin");
		//3.��ȡ������
		Statement st = conn.createStatement();
		//4.ִ��sql���
		int ret = st.executeUpdate(sql);
		System.out.println("��Ӱ�������"+ret);
		//5.�ر���Դ
		st.close();
		conn.close();
	}
	@Test
	public void testDelete() throws Exception {
		String sql = "DELETE FROM s_student WHERE name = '���Ŵ�ѩ'";
		//1.����ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2��ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin");
		//3��ȡ������
		Statement st = conn.createStatement();
		//4.ִ��sql���
		st.executeUpdate(sql);
		//5.�ͷ���Դ
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
