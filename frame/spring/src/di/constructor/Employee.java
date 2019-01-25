package di.constructor;

public class Employee {
	private String username;
	private Double salary;
	private Integer age;
	
	public Employee(String username, Double salary, Integer age) {
		this.username = username;
		this.salary = salary;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", salary=" + salary + ", age=" + age + "]";
	}
}
