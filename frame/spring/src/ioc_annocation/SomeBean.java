package ioc_annocation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//<bean id="some" class="ioc_annocation.SomeBean"/>

@Component("someBean")//属性名称默认 为类名首字母小写
public class SomeBean {
	
//	@Autowired()
//	@Qualifier("other11")
	@Resource
	OtherBean1 other1;
	@Autowired
	OtherBean2 other2;

	@PostConstruct//构造器执行之前执行 的方法
	public void open() {
		System.out.println("SomeBean.open()");
	}
	
	@PreDestroy//销毁之前执行的方法
	public void close() {
		System.out.println("SomeBean.close()");
	}
	
	@Override
	public String toString() {
		return "SomeBean [other1=" + other1 + ", other2=" + other2 + "]";
	}
	
}
