package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author 15626
 * 	获取xml文件中元素的文本内容
 * 
 *	修改xml文件中元素的文本内容
 */
public class UpdateDocument {
	public static void main(String[] args) throws Exception {
		//1.获取Document对象
		File f = new File("D:/JavaWork/other/src/xml/contants.xml");
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		//获取这个文档的根元素
		Element root = doc.getDocumentElement();
		//元素调用getElementByTargetName("");会根据元素名称从子元素中去获取目标名相同的返回一个NodeList，
		//可以掉头iteam(int index) 获取索引为index的元素对象 ，另外还需要强转为Element对象
		//如果文档对象doc去调用getElementByTargetName  则会从整个文档中去找
		Element linkmanEle = (Element) root.getElementsByTagName("linkman").item(1);
		//获取email元素对象
		Element emailEle = (Element) linkmanEle.getElementsByTagName("email").item(0);
		//得到email元素中的文本内容
		System.out.println(emailEle.getTextContent());
		
		
		//修改元素中的文本内容
		emailEle.setTextContent("shabi.com");
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer trans = factory.newTransformer();
		//创建源，源是内存中的Document对象
		Source xmlSource = new DOMSource(doc);
		//创建目标，目标是xml文件
		Result outputTarget = new StreamResult(f);
		//同步
		trans.transform(xmlSource, outputTarget);
	}
}
