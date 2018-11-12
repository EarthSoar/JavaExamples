package datasouce.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import util.DruidUtil;

/**
 * @author 15626
 *	测试Druid连接池
 */
public class DruidTest {
	@Test
	public void test1() throws Exception {
		String sql = "SELECT * FROM accounts WHERE id = ?";
		//获取连接对象
		Connection conn = DruidUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, 2);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			System.out.println(rs.getString("name"));
		}
		//关闭资源
		DruidUtil.close(conn, ps, rs);
	}
}
