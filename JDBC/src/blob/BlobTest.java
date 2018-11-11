package blob;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import util.JdbcUtil;

/**
 * @author 15626
 *	BLOB系列是大的二进制类型,允许存储(255个字节到4G).
 */
public class BlobTest {
	@Test      //将本地文件推向数据库
	public void testWrite() throws Exception {
		String sql = "INSERT INTO image(image) VALUES(?)";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setBlob(1, new FileInputStream("C:/Users/15626/Desktop/aaa.png"));
		ps.executeUpdate();
		JdbcUtil.close(conn, ps, null);
	}
	 
	@Test     //从数据库中把图片读出来
	public void testRead() throws Exception {
		String sql = "SELECT * FROM image";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			Blob image = rs.getBlob("image");
			InputStream fs = image.getBinaryStream();//返回一个输入流
			
			FileOutputStream out = new FileOutputStream("C:/Users/15626/Desktop/ccc.png");
			byte[] buffer = new byte[1024];
			int len = -1;
			while((len = fs.read(buffer)) != -1){
				out.write(buffer, 0, len);
			}
			//Files.copy(fs, Paths.get("C:/Users/15626/Desktop/bbb.png"));
			fs.close();
			out.close();
		}
		JdbcUtil.close(conn, ps, null);
	}
}
