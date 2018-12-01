package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static Properties p;
	static {
		p = new Properties();
		InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
		try {
			p.load(inStream);
			Class.forName(p.getProperty("driverClassName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),p.getProperty("password"));
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
		}finally {
			try {
				if(st != null) {
					st.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) {
						rs.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					
				}
			}
		}
	}
}
