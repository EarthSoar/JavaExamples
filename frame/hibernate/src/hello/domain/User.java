package hello.domain;

import java.math.BigDecimal;

public class User {
	private Long id;
	private String name;
	private BigDecimal salary;
	private java.util.Date hiredate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public java.util.Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(java.util.Date hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", salary=" + salary + ", hiredate=" + hiredate + "]";
	}
}
