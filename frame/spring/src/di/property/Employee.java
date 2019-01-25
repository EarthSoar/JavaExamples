package di.property;

public class Employee {
	private String username;
	private Double salary;
	private Integer age;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [username=" + username + ", salary=" + salary + ", age=" + age + "]";
	}
}
