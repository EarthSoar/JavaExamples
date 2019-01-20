package factoy;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import dao.IProductDAO;

//对象工厂类
public enum BeanFactoy {
	INSTANCE;

	private static Properties p = new Properties();
	private Map<String, Object> cache = new HashMap<>();
	static {// 加载资源文件
		InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("beans.properties");
		try {
			p.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 传递的参数等于资源文件中的key
	@SuppressWarnings("unchecked")
	public <T> T getBean(String beanName, Class<T> requiredType) {
		// 判断缓存中是否存在指定名称的对象
		Object current = cache.get(beanName);
		if (current == null) {
			String className = p.getProperty(beanName);// 得到类的权限顶名称
			if (className != null) {
				try {
					Object obj = Class.forName(className).newInstance();
					if (!requiredType.isInstance(obj)) {
						throw new RuntimeException("类型不正确");
					}
					cache.put(beanName, obj);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return (T) cache.get(beanName);
	}

	public static void main(String[] args) {
		IProductDAO dao1 = BeanFactoy.INSTANCE.getBean("productDAO", IProductDAO.class);
		IProductDAO dao2 = BeanFactoy.INSTANCE.getBean("productDAO", IProductDAO.class);
		System.out.println(dao1);
		System.out.println(dao2);// 相等. 说明是单例的
	}
}
