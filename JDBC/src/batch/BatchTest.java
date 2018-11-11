package batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

import util.JdbcUtil;

/**
 *	批处理向表中添加数据
 *	比较InnoDB和MyISAM插入数据速度
 *	MySql不支持批量处理，也不支持预编译
 *	MySQL的批处理也需要通过参数来打开：rewriteBatchedStatements=true
 *	预编译打开useServerPrepStmts=true
 */
public class BatchTest {
	@Test
	//InnoDB:1570ms    不批量的是1388ms  
	//MyISAM:257ms
	public void testInsertByStatementBatch() throws Exception {
		Connection conn = JdbcUtil.getConn();
		Statement st = conn.createStatement();
		long begin = System.currentTimeMillis();
		for(int i = 1; i <= 1000; i++){
			String sql = "INSERT INTO s_student(age) VALUES("+ i+ ")";
			st.addBatch(sql);
			if(i % 20 == 0){
				st.executeBatch();
				st.clearBatch();
			}
		}
		System.out.println(System.currentTimeMillis() - begin);
		JdbcUtil.close(conn, st, null);
	}
	@Test
	//InnoDB:1346ms
	//MyISAM:209ms
	public void testInsertByPreparedStatementBatch() throws Exception {
		Connection conn = JdbcUtil.getConn();
		String sql = "INSERT INTO s_student(age) VALUES(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		long begin = System.currentTimeMillis();
		for(int i = 1; i <= 1000; i++){
			ps.setInt(1, i);
			ps.addBatch();
			if(i % 20 == 0){
				ps.executeBatch();
				ps.clearBatch();//清除批处理的缓存
				ps.clearParameters();//清除批处理的参数
			}
		}
		System.out.println(System.currentTimeMillis() - begin);
		JdbcUtil.close(conn, ps, null);
	}
}
