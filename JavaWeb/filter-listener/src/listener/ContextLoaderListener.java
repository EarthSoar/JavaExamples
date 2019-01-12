package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *  监听作用域对象的创建和销毁
 *  ServletContextListener	监听WEB应用的创建和销毁
 *  ServletRequestListener	监听请求对象的创建和销毁
 *  HttpSessionListener		监听回话对象的创建和销毁
 */
public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("WEB应用销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("WEB应用初始化操作");
	}

}
