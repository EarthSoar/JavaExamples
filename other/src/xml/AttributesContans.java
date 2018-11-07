package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author 15626
 *	操作元素的属性，设置并获取第三个人的id
 */
public class AttributesContans {
	public static void main(String[] args) throws Exception {
		/**
		 * 1.获取Document文档对象
		 * 2.获得文档的根元素
		 * 3.获得第三人的属性
		 * 4.设置第三人的属性
		 * 5.同步，把内存中的数据同步到xml文件中
		 */
		File f = new File("D:/JavaWork/other/src/xml/contants.xml");
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		
		Element root = doc.getDocumentElement();
		//得到第三个人的元素对象
		Element linkmanEle = (Element) root.getElementsByTagName("linkman").item(2);
		
		//获取属性id的值
		String name = linkmanEle.getAttribute("id");
		System.out.println(name);
		//设置属性值
		linkmanEle.setAttribute("id", "88");
		
		//同步
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.transform(new DOMSource(doc), new StreamResult(f));
	}
}
