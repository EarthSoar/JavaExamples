package set;

import java.util.*;



class Person{
	private int id;
	private String name;
	private int age;
	public String toString(){
		return "{id:"+id+",+name:"+name+","+"age:"+age+"}";
	}
	public Person(int id,String name,int age){
		this.age = age;
		this.name = name;
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}

/**
 * @author 15626
 *	��סshift+alt+s,������Ҽ���eclipse�����Զ�����equals������hashCode����
 *����ѡ�����ʲô���ж��Ƿ�һ����������ѡ���Ǹ���id���жϣ��������id��ͬ���͵�����ͬ�Ķ���
 *�����hashCodeֵ�������ڹ�ϣ���еĴ洢λ��.
 */

/**
 * @author 15626
 *
 *����HashSet����������µĶ����ʱ��,�Ȼ��жϸö���ͼ��϶����е�hashCodeֵ:
      1):����: ֱ�ӰѸ��µĶ���洢��hashCodeָ����λ��.
      2):���: �ټ����ж��¶���ͼ��϶����е�equals���Ƚ�.

 */
public class HashSetDemo3 {
	public static void main(String []args){
		Set<Person> set = new HashSet<>();
		set.add(new Person(6,"����",19));
		set.add(new Person(1,"̫���Ͼ�",99));
		set.add(new Person(3,"����",20));
		System.out.println(set);
		System.out.println(set.size());
	}
}
