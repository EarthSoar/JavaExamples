package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtil {
	private static Properties p = new Properties();
	private static DataSource ds = null;
	static{//加载注册驱动
		InputStream inStream = Thread.currentThread().getContextClassLoader().
				getResourceAsStream("druid.properties");
		try {
			p.load(inStream);
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//从缓冲池中获取连接对象
	public static Connection getConn(){
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭资源
	public static void close(Connection conn, Statement st, ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(st != null){
					st.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if(conn != null){
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					
				}
			}
		}
	}
}
