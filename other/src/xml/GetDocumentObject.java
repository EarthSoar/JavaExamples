package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

/**
 * @author 15626
 *	获取document文档的对象
 */
public class GetDocumentObject {
	public static void main(String[] args) throws Exception {
		//创建需要操作xml文件的对象
		File f = new File("D:/JavaWork/other/src/xml/contants.xml");
		//调用工厂类的静态方法获取自己的对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取builder对象
		DocumentBuilder builder = factory.newDocumentBuilder();
		//根据builder对象解析一个已经存在的xml文件,得到Document对象
		//parse方法在文档存在的时候进行解析，newDoument方法在文档不存在的时候在内存中创建一个Document对象
		Document doc = builder.parse(f);
		System.out.println(doc);
	}
}
