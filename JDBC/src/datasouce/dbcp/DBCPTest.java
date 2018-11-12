package datasouce.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import util.DBCPUtil;
import util.JdbcUtil;

public class DBCPTest {
	//没有使用连接池的做法
	@Test
	public void test1() throws Exception {
		String sql = "SELECT * FROM accounts WHERE id = ?";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, 1);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			String name = rs.getString("name");
			System.out.println(name);
		}
		JdbcUtil.close(conn, ps, rs);
	}
	
	@Test  //使用DBCP连接池
	public void test2() throws Exception {
		String sql = "SELECT * FROM accounts WHERE id = ?";
		Connection conn = getDataSource().getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, 1);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			String name = rs.getString("name");
			System.out.println(name);
		}
		JdbcUtil.close(conn, ps, rs);
	}
	public DataSource getDataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/demo");
		ds.setUsername("root");
		ds.setPassword("admin");
		ds.setMaxActive(5);
		return ds;
	}
	
	@Test  //使用DBCPUtil操作
	public void test3() throws Exception {
		String sql = "SELECT * FROM accounts WHERE id = ?";
		Connection conn = DBCPUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, 1);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			String name = rs.getString("name");
			System.out.println(name);
		}
		DBCPUtil.close(conn, ps, rs);
	}
}
