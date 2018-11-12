package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil_bak_old {
	private static Properties p = new Properties();
	//加载资源文件
	static{
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inStream = loader.getResourceAsStream("db.properties");
		try {
			p.load(inStream);
			Class.forName(p.getProperty("classDriver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//获取连接对象
	public static Connection getConn(){
		Connection conn = null;
		try {
			 conn = DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"), p.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//关闭资源
	public static void close(Connection conn,Statement st,ResultSet rs){
		try{
			if(rs != null){
				rs.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(st != null){
					st.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(conn != null){
						conn.close();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
