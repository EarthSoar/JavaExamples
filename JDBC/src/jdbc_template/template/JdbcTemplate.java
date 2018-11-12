package jdbc_template.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc_template.handler.IResultSetHandler;
import util.JdbcUtil;

public class JdbcTemplate {
	/**
	 * DML���Ĳ�����ģ��
	 * @param sql  sql��� ��UPDATE INSERT DELETE
	 * @param params sql����е�վλ��? ��Ӧֵ������
	 * @return		������Ӱ�������
	 */
	public static int update(String sql,Object...params){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//����ע����������ȡ���Ӷ���
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
			//�ͷ���Դ
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
			//��ȡ������
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < params.length; i++){
				ps.setObject(i + 1, params[i]);
			}
			//ִ��sql���
			rs = ps.executeQuery();
			
			//��������
			return ih.handle(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps, rs);
		}
		return null;
	}
}
