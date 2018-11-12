package jdbc_template.daomain;

public class Student {
	private Long id;//Ö÷¼ü
	private String name;//ĞÕÃû
	private Integer age;//ÄêÁä
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	public Student(Long id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public Student(){}
}
