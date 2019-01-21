package daomain;

import java.util.Date;

public class Employee {
	private Long id;
	private String username;
	private String password;
	private String dept;
	private String headImg = "/upload/default.png";
	private java.util.Date entryDate;

	public String getHeadImg() {
		return headImg;
	}

	public Employee(Long id, String username, String password, String dept, String headImg, Date entryDate) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.dept = dept;
		this.headImg = headImg;
		this.entryDate = entryDate;
	}

	public Employee() {}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public java.util.Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(java.util.Date entryDate) {
		this.entryDate = entryDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", dept=" + dept
				+ ", entryDate=" + entryDate + "]";
	}
}
