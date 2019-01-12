package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class HttpSessionAttributeListenerDemo implements HttpSessionAttributeListener {

	@Override
	//监听属性的添加
	public void attributeAdded(HttpSessionBindingEvent even) {
		System.out.println("添加属性" + even.getName() + "," + even.getValue());
	}

	@Override
	//监听属性的删除
	public void attributeRemoved(HttpSessionBindingEvent even) {
		System.out.println("删除属性" + even.getName());
	}

	@Override
	//监听属性的替换
	public void attributeReplaced(HttpSessionBindingEvent even) {
		System.out.println("替换属性" + even.getName());
	}

}
