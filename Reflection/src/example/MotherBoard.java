package example;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 *	用记载资源文件的方式，资源文件中存有类的全限定名称，所以可以根据反射创建对象，从而使得操作简单，只需要在资源文件中
 *	修改即可
 *	
 *	注意：资源文件一般在Source Folder目录下创建，这样可以直接编译到classpath根目录下，类加载器也是从classpath根目录下
 *		下去找文件
 */
public class MotherBoard {
	//plugins用来存放插件的名称和插件对象的关系
	static Map<String,IUSB> plugins = new HashMap<>();
	//用来资源文件
	static Properties p = new Properties();
	
	static{
		//创建一个类加载器，加载properties文件
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inStream = loader.getResourceAsStream("config.properties");
		try {
			//用load方法加载一个流
			p.load(inStream);
			//初始化操作，创建插件的对象
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void init() throws Exception {
		//Properties也是一种特殊的Map,得到它的entry键值对也就是一个Set集合进行迭代
		Set<Entry<Object, Object>> entrys = p.entrySet();
		
		for (Entry<Object, Object> entry : entrys) {
			String key = (String) entry.getKey();
			String values = (String) entry.getValue();
			//用反射创建对象，类中必须提供一个公共的无参数构造器
			IUSB usb = (IUSB) Class.forName(values).newInstance();
			//如果创建的对象并没有实现USB接口，抛出一个异常
			if(!(usb instanceof IUSB)){
				throw new RuntimeException("该插件没有遵循USB规范");
			}
			//把名称-对象键值对送到Map中去
			plugins.put(key, usb);
		}
	}
	public void work(){//主板上插的配件开始工作
		//对这个Map的值，也就是对象进行迭代
		for(IUSB usb : plugins.values()){
			usb.swapData();//对象调用方法
		}
	}
}
