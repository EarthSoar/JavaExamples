package util;

import java.sql.*;
import java.util.Properties;

/**
 * @author Willing
 * @date 2018/12/18
 */
public class JdbcUtil {
    private static Properties properties = null;

    static {
        //加载注册驱动
        properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            Class.forName(properties.getProperty("driverClassName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  conn;
    }
    //关闭资源
    public static void close(Connection conn, Statement st, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(st != null){
                    st.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    if(conn != null){
                        rs.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
