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
 *	BLOBϵ���Ǵ�Ķ���������,����洢(255���ֽڵ�4G).
 */
public class BlobTest {
	@Test      //�������ļ��������ݿ�
	public void testWrite() throws Exception {
		String sql = "INSERT INTO image(image) VALUES(?)";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setBlob(1, new FileInputStream("C:/Users/15626/Desktop/aaa.png"));
		ps.executeUpdate();
		JdbcUtil.close(conn, ps, null);
	}
	 
	@Test     //�����ݿ��а�ͼƬ������
	public void testRead() throws Exception {
		String sql = "SELECT * FROM image";
		Connection conn = JdbcUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			Blob image = rs.getBlob("image");
			InputStream fs = image.getBinaryStream();//����һ��������
			
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
