package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtil {
	private static Properties p = new Properties();
	private static DataSource dataSource = null;
	//������Դ�ļ�
	static{
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inStream = loader.getResourceAsStream("dbcp.properties");
		try {
			p.load(inStream);
			//����DataSource����
			dataSource = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����ע�������쳣");
		}
	}

	//�����ӳ��л�ȡ���Ӷ���
	public static Connection getConn(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//�ر���Դ
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
