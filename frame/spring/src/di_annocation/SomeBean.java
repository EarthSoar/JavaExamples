package di_annocation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class SomeBean {
	
//	@Autowired()
//	@Qualifier("other11")
	@Resource
	OtherBean1 other1;
	
	/**
	 * 	Autowired 标签可以让Spring自动的把属性从容器中找出来并注入给该属性 ，可以放在setter方法上，也可以直接放在字段上 
	 * 	
	 * 	找属性的方式是  ： 先按照类型去找，如果找到则直接注入
	 * 	如果有多个类型相同的bean,再去按照名称id去寻找，如果没找到则报错
	 * 	(先类型 ->后名称)
	 * 	可以直接指定去哪个名称 下去找,用 Qualifier标签  value值就是指定要寻找属性的名称
	 */
	
	/**
	 * 	Resource 标签是 JavaEE 提供的注入的标签
	 * 	寻找属性的方式是：先按照属性名去找，找到就注入 ，按照名称找不到就去按照类型去寻找 
	 * 	(先名称-> 后类型)
	 */
	@Autowired
	OtherBean2 other2;


	@Override
	public String toString() {
		return "SomeBean [other1=" + other1 + ", other2=" + other2 + "]";
	}
	
}
