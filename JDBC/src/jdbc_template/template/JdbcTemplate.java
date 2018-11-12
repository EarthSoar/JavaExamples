package jdbc_template.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc_template.handler.IResultSetHandler;
import util.JdbcUtil;

public class JdbcTemplate {
	/**
	 * DML语句的操作的模板
	 * @param sql  sql语句 ：UPDATE INSERT DELETE
	 * @param params sql语句中的站位符? 对应值的数组
	 * @return		返回受影响的行数
	 */
	public static int update(String sql,Object...params){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//加载注册驱动，获取连接对象
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			//
			for(int i = 0; i < params.length; i++){
				ps.setObject(i + 1, params[i]);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			JdbcUtil.close(conn, ps, null);
		}
		return 0;
	}
	public static <T> T query(String sql,IResultSetHandler<T> ih,Object...params){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			//获取语句对象
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < params.length; i++){
				ps.setObject(i + 1, params[i]);
			}
			//执行sql语句
			rs = ps.executeQuery();
			
			//处理结果集
			return ih.handle(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps, rs);
		}
		return null;
	}
}
