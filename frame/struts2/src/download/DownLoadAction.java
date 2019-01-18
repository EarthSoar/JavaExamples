package download;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownLoadAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private String fileName;
	private InputStream inputStream;
	public void setFileName(String fileName) throws Exception {
		//解决GET请求中文乱码
		this.fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
	}
	//提供getter方法在xml配置文件中获取fileName
	public String getFileName() {
		return fileName;
	}
	
	//提供getter方法对输入流,  把服务器中的文件读取到程序中
	public InputStream getInputStream() throws Exception {
		return inputStream;
	}
	public String execute() throws Exception {
		String realPath = ServletActionContext.getServletContext().getRealPath("/service");
		File f = new File(realPath,fileName);
		inputStream = new FileInputStream(f);
		
		fileName = new String(fileName.getBytes(),"ISO-8859-1");
		return SUCCESS;
	}
}
