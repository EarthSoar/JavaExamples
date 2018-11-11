package tx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import util.JdbcUtil;

/**
 * @author 15626
 *	ģ������ת��  ��������
 */
public class TransferAccountsTest {
	@Test
	public void testTrans() throws Exception {
		//�Ȳ�ѯ�ֻ����˻�����û��1000
		String sql = "SELECT * FROM accounts WHERE name = ? AND blance >= ?";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "�ֻ�");
		ps.setInt(2, 1000);
		ResultSet rs = ps.executeQuery();
		if(!rs.next()){
			System.out.println("�������");
			return;
		}
		//���ֻ����˻��м���1000
		sql = "UPDATE accounts SET blance = blance - ? WHERE name = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, 1000);
		ps.setString(2, "�ֻ�");
		ps.executeUpdate();
		
		//ģ��ͣ��,   --���������  �ֻ���Ǯ����1000���Ǿ����Ǯ��û������
		//˵�����ֻ�Ǯ�ļ��ٺ;���Ǯ�����������һ��ԭ�Ӳ���������ͬʱ����
		//int a = 1/0;
		
		
		//������˻�����100
		sql = "UPDATE accounts SET blance = blance + ? WHERE name = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, 1000);
		ps.setString(2, "����");
		ps.executeUpdate();
		
		JdbcUtil.close(conn, ps, rs);
	}
	@Test   //������������
 	public void testTrans2() {
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			String sql = "SELECT * FROM accounts WHERE name = ? AND blance >= ?";
			//�Ȳ�ѯ�ֻ����˻�����û��1000
			ps = conn.prepareStatement(sql);
			ps.setString(1, "�ֻ�");
			ps.setInt(2, 1000);
			rs = ps.executeQuery();
			if(!rs.next()){
				throw new RuntimeException("ûǮ��");
			}
			//ȡ��������Զ��ύ
			conn.setAutoCommit(false);
			//���ֻ����˻��м���1000
			sql = "UPDATE accounts SET blance = blance - ? WHERE name = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "�ֻ�");
			ps.executeUpdate();
			//ģ��ͣ��
			//int a = 1/0;
			
			//������˻�����100
			sql = "UPDATE accounts SET blance = blance + ? WHERE name = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "����");
			ps.executeUpdate();
			//�ύ����
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			try {
				//�ع�����
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			//JdbcUtil.close(conn, ps, rs);
		}
	}
}
