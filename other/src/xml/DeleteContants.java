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
 *	删除指定元素节点：删除第三个联系人信息
 *	元素对象.getParentNode().removeChild(元素对象);
 *	父元素节点.removeChild(子元素节点);
 */
public class DeleteContants {
	public static void main(String[] args) throws Exception {
		/**
		 * 1.获取Document对象
		 * 2.获取文档的根元素
		 * 3.获取第三个人的元素对象
		 * 4.删除第三个联系人
		 * 5.同步，把内存中的数据同步到xml文件中
		 */
		File f = new File("D:/JavaWork/other/src/xml/contants.xml");
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		
		Element root = doc.getDocumentElement();
		
		Element linkmanEle = (Element) root.getElementsByTagName("linkman").item(2);
		
		//删除联系人
		//linkmanEle.getParentNode().removeChild(linkmanEle);
		root.removeChild(linkmanEle);
		
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.transform(new DOMSource(doc), new StreamResult(f));
	}
}
