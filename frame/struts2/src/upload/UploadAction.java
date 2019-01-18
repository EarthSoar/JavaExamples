package upload;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private String username;
	private File headImg;//上传的文件,注意  属性名称必须这样起名
	private String headImgFileName;//上传文件的文件名
	private String headImgContentType;//上传文件MIME类型

	@Override
	public String execute() throws Exception {
		
		System.out.println(username);
		System.out.println(headImg);
		System.out.println(headImgFileName);
		System.out.println(headImgContentType);
		
		//上传文件
		String dir = ServletActionContext.getRequest().getServletContext().getRealPath("/upload");
		File destFile = new File(dir,headImgFileName);
		//拷贝操作
		//FileUtils.copyFile(headImg, destFile);
		Files.copy(headImg.toPath(), new FileOutputStream(destFile));
		return NONE;
	}
	
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}
	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}
	public void setHeadImgType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}
}
