package tx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import util.JdbcUtil;

/**
 * @author 15626
 *	模拟银行转账  操作事务
 */
public class TransferAccountsTest {
	@Test
	public void testTrans() throws Exception {
		//先查询胖虎的账户中有没有1000
		String sql = "SELECT * FROM accounts WHERE name = ? AND blance >= ?";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "胖虎");
		ps.setInt(2, 1000);
		ResultSet rs = ps.executeQuery();
		if(!rs.next()){
			System.out.println("你的余额不足");
			return;
		}
		//从胖虎的账户中减少1000
		sql = "UPDATE accounts SET blance = blance - ? WHERE name = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, 1000);
		ps.setString(2, "胖虎");
		ps.executeUpdate();
		
		//模拟停电,   --这样会出现  胖虎的钱少了1000但是静香的钱并没有增加
		//说明了胖虎钱的减少和静香钱的增加这个是一对原子操作，必须同时进行
		//int a = 1/0;
		
		
		//静香的账户增加100
		sql = "UPDATE accounts SET blance = blance + ? WHERE name = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, 1000);
		ps.setString(2, "静香");
		ps.executeUpdate();
		
		JdbcUtil.close(conn, ps, rs);
	}
	@Test   //用事务来操作
 	public void testTrans2() {
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			String sql = "SELECT * FROM accounts WHERE name = ? AND blance >= ?";
			//先查询胖虎的账户中有没有1000
			ps = conn.prepareStatement(sql);
			ps.setString(1, "胖虎");
			ps.setInt(2, 1000);
			rs = ps.executeQuery();
			if(!rs.next()){
				throw new RuntimeException("没钱了");
			}
			//取消事务的自动提交
			conn.setAutoCommit(false);
			//从胖虎的账户中减少1000
			sql = "UPDATE accounts SET blance = blance - ? WHERE name = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "胖虎");
			ps.executeUpdate();
			//模拟停电
			//int a = 1/0;
			
			//静香的账户增加100
			sql = "UPDATE accounts SET blance = blance + ? WHERE name = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1000);
			ps.setString(2, "静香");
			ps.executeUpdate();
			//提交事务
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			try {
				//回滚事务
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			//JdbcUtil.close(conn, ps, rs);
		}
	}
}
