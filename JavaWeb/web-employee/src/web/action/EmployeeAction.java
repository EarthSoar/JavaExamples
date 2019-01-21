package web.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import daomain.Employee;
import page.PageResult;
import query.EmployeeQueryObject;
import service.IEmployeeService;
import service.impl.EmployeeServiceImpl;

public class EmployeeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private IEmployeeService service = new EmployeeServiceImpl();
	private EmployeeQueryObject qo = new EmployeeQueryObject();
	private Employee employee = new Employee();
	
	private File headImg;
	private String headImgFileName;

	@Override
	public String execute() throws Exception {
		PageResult pageResult = service.query(qo);
		ActionContext.getContext().put("pageResult", pageResult);
		return "list";
	}
	public String save() {
		String dir = ServletActionContext.getRequest().getServletContext().getRealPath("/upload");
		try {
			if (headImg != null) {
				File destFile = new File(dir, headImgFileName);
				Files.copy(headImg.toPath(), new FileOutputStream(destFile));
				employee.setHeadImg("/upload/" + headImgFileName);
			} else {
				employee.setHeadImg("/upload/default.png");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (employee.getId() == null) {
			service.save(employee);
		} else {
			service.update(employee);
		}
		return SUCCESS;
	}

	public String input() {
		// 回显数据
		if (employee.getId() != null) {
			employee = service.get(employee.getId());
		}
		return INPUT;
	}

	public String delete() {
		service.delete(employee.getId());
		return SUCCESS;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

	public EmployeeQueryObject getQo() {
		return qo;
	}
}
