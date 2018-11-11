package prepared_statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import util.JdbcUtil;

/**
 * @author 15626
 *	模拟用户登录案例 测试PreparedStatement和Statement的区别
 *	PreparedStatement优点
 *	1.安全：可以发现使用PreparedStatement可以防止sql注入
 *	2.可以提高性能：预编译，但是Mysql不支持PreparedStatement也就是不能预编译
 *	3.代码可读性高：不用拼接sql了
 */
public class PrepareStatementTest {
	@Test // SQL注入    如：         ' OR 1=1 OR '  也可以成功
	public void testLoginByStatement() throws Exception {
		String sql = "SELECT * FROM login WHERE name = '胖虎' AND password = '123'";
		Connection conn = JdbcUtil.getConn();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}
		JdbcUtil.close(conn, st, rs);
	}
	
	@Test
	public void testLoginByPreparedStatement() throws Exception {
		String sql = "SELECT * FROM login WHERE name = ? AND password = ?";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "静香");
		ps.setString(2, "789");
		ResultSet rs= ps.executeQuery();
		if(rs.next()){
			System.out.println(rs.getString("password"));
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}
		JdbcUtil.close(conn,ps,rs);
	}
}
