package other;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class User {
	private String name;
	private int age;
	private boolean man;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMan() {
		return man;
	}
	public void setMan(boolean man) {
		this.man = man;
	}
	public User(){}
	public User(String name, int age, boolean man) {
		this.name = name;
		this.age = age;
		this.man = man;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", man=" + man + "]";
	}
	public static void main(String[] args) throws Exception {
		BeanInfo info = Introspector.getBeanInfo(User.class,Object.class);
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		User u = User.class.newInstance();
		for (PropertyDescriptor pd : pds) {
			//获取属性名称 和属性的类型
			System.out.println(pd.getName()+","+pd.getDisplayName());
			Method get = pd.getReadMethod();
			Method set = pd.getWriteMethod();
			System.out.println("getter方法："+get);
			System.out.println("setter方法："+set);
			
			
			if("name".equals(pd.getName())){
				Method setter = pd.getWriteMethod();
				setter.invoke(u, "xx");
				Method getter = pd.getReadMethod();
				Object o = getter.invoke(u);//获取名字
				System.out.println(o);
			}
		}
		System.out.println(u);
	}
}
