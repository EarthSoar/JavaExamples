package prepared_statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import util.JdbcUtil;

/**
 * @author 15626
 *	ģ���û���¼���� ����PreparedStatement��Statement������
 *	PreparedStatement�ŵ�
 *	1.��ȫ�����Է���ʹ��PreparedStatement���Է�ֹsqlע��
 *	2.����������ܣ�Ԥ���룬����Mysql��֧��PreparedStatementҲ���ǲ���Ԥ����
 *	3.����ɶ��Ըߣ�����ƴ��sql��
 */
public class PrepareStatementTest {
	@Test // SQLע��    �磺         ' OR 1=1 OR '  Ҳ���Գɹ�
	public void testLoginByStatement() throws Exception {
		String sql = "SELECT * FROM login WHERE name = '�ֻ�' AND password = '123'";
		Connection conn = JdbcUtil.getConn();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			System.out.println("��¼�ɹ�");
		}else{
			System.out.println("��¼ʧ��");
		}
		JdbcUtil.close(conn, st, rs);
	}
	
	@Test
	public void testLoginByPreparedStatement() throws Exception {
		String sql = "SELECT * FROM login WHERE name = ? AND password = ?";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "����");
		ps.setString(2, "789");
		ResultSet rs= ps.executeQuery();
		if(rs.next()){
			System.out.println(rs.getString("password"));
			System.out.println("��¼�ɹ�");
		}else{
			System.out.println("��¼ʧ��");
		}
		JdbcUtil.close(conn,ps,rs);
	}
}
