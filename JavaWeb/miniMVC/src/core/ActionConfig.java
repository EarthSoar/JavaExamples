package core;

//封装<action>元素中的所有信息
public class ActionConfig {
	private String name; // <action>元素中的name属性
	private String className;// <action>元素中的class属性
	private String method;// <action>元素中的method属性

	public String getName() {
		return name;
	}

	public String getClassName() {
		return className;
	}

	public String getMethod() {
		return method;
	}

	public ActionConfig(String name, String className, String method) {
		this.name = name;
		this.className = className;
		this.method = method;
	}
}
