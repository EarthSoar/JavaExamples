package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcUtil {
	//私有化构造器
	private JdbcUtil() {}
	
	private static DataSource ds = null;
	private static Properties p = null;
	//加载注册驱动
	static {
		p = new Properties();
		InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
		try {
			p.load(inStream);
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn,Statement st,ResultSet rs) {
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) {
						rs.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
