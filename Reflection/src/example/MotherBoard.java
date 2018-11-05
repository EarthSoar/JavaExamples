package example;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 *	�ü�����Դ�ļ��ķ�ʽ����Դ�ļ��д������ȫ�޶����ƣ����Կ��Ը��ݷ��䴴�����󣬴Ӷ�ʹ�ò����򵥣�ֻ��Ҫ����Դ�ļ���
 *	�޸ļ���
 *	
 *	ע�⣺��Դ�ļ�һ����Source FolderĿ¼�´�������������ֱ�ӱ��뵽classpath��Ŀ¼�£��������Ҳ�Ǵ�classpath��Ŀ¼��
 *		��ȥ���ļ�
 */
public class MotherBoard {
	//plugins������Ų�������ƺͲ������Ĺ�ϵ
	static Map<String,IUSB> plugins = new HashMap<>();
	//������Դ�ļ�
	static Properties p = new Properties();
	
	static{
		//����һ���������������properties�ļ�
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inStream = loader.getResourceAsStream("config.properties");
		try {
			//��load��������һ����
			p.load(inStream);
			//��ʼ����������������Ķ���
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void init() throws Exception {
		//PropertiesҲ��һ�������Map,�õ�����entry��ֵ��Ҳ����һ��Set���Ͻ��е���
		Set<Entry<Object, Object>> entrys = p.entrySet();
		
		for (Entry<Object, Object> entry : entrys) {
			String key = (String) entry.getKey();
			String values = (String) entry.getValue();
			//�÷��䴴���������б����ṩһ���������޲���������
			IUSB usb = (IUSB) Class.forName(values).newInstance();
			//��������Ķ���û��ʵ��USB�ӿڣ��׳�һ���쳣
			if(!(usb instanceof IUSB)){
				throw new RuntimeException("�ò��û����ѭUSB�淶");
			}
			//������-�����ֵ���͵�Map��ȥ
			plugins.put(key, usb);
		}
	}
	public void work(){//�����ϲ�������ʼ����
		//�����Map��ֵ��Ҳ���Ƕ�����е���
		for(IUSB usb : plugins.values()){
			usb.swapData();//������÷���
		}
	}
}
