package getprimarykey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import util.JdbcUtil;

/**
 * 获取自动生成的主键
 *1.Statement： 在执行语句st.execuUpdate(String sql,Statement.常量值);
 * 				用st.getGeneratedKey()获取;返回一个结果集
 *1.PreparedStatement: 在获取语句对象的时候  conn.PreparedStatement(String sql,Statement.常量值)；
 *				用ps.getGeneratedKey()获取;返回一个结果集
 */
public class GetPkTest {
	@Test
	public void testStatement() throws Exception {
		String sql = "INSERT INTO login(name) VALUES('大熊')";
		Connection conn = JdbcUtil.getConn();
		Statement st = conn.createStatement();
		st.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = st.getGeneratedKeys();
		if(rs.next()){
			long id = rs.getLong(1);
			System.out.println("当前主键值："+id);
		}
		JdbcUtil.close(conn, st, rs);
	}
	@Test
	public void testPreparedStatement() throws Exception {
		String sql = "INSERT INTO login(name) VALUES(?)";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, "小夫");
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if(rs.next()){
			long id = rs.getLong(1);
			System.out.println("当前主键值："+id);
		}
		JdbcUtil.close(conn, ps, rs);
	}
}
