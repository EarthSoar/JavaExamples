package getprimarykey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import util.JdbcUtil;

/**
 * ��ȡ�Զ����ɵ�����
 *1.Statement�� ��ִ�����st.execuUpdate(String sql,Statement.����ֵ);
 * 				��st.getGeneratedKey()��ȡ;����һ�������
 *1.PreparedStatement: �ڻ�ȡ�������ʱ��  conn.PreparedStatement(String sql,Statement.����ֵ)��
 *				��ps.getGeneratedKey()��ȡ;����һ�������
 */
public class GetPkTest {
	@Test
	public void testStatement() throws Exception {
		String sql = "INSERT INTO login(name) VALUES('����')";
		Connection conn = JdbcUtil.getConn();
		Statement st = conn.createStatement();
		st.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = st.getGeneratedKeys();
		if(rs.next()){
			long id = rs.getLong(1);
			System.out.println("��ǰ����ֵ��"+id);
		}
		JdbcUtil.close(conn, st, rs);
	}
	@Test
	public void testPreparedStatement() throws Exception {
		String sql = "INSERT INTO login(name) VALUES(?)";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, "С��");
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if(rs.next()){
			long id = rs.getLong(1);
			System.out.println("��ǰ����ֵ��"+id);
		}
		JdbcUtil.close(conn, ps, rs);
	}
}
