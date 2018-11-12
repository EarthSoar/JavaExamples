package datasouce.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import util.DruidUtil;

/**
 * @author 15626
 *	����Druid���ӳ�
 */
public class DruidTest {
	@Test
	public void test1() throws Exception {
		String sql = "SELECT * FROM accounts WHERE id = ?";
		//��ȡ���Ӷ���
		Connection conn = DruidUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, 2);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			System.out.println(rs.getString("name"));
		}
		//�ر���Դ
		DruidUtil.close(conn, ps, rs);
	}
}
