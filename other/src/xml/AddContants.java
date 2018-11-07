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
 *	向指定元素节点中插入子元素节点，增加一个联系人信息
 *
 *	<linkman>
		<age>lili</age>
		<age>23</age>
		<eamil>1008611@yd.com</eamil>
		<adress>月球</adress>
	</linkman>
 */

public class AddContants {
	public static void main(String[] args) throws Exception {
		/**
		 * 1.获取Document文档的对象
		 * 2.获取根元素
		 * 3.创建一个linkman片段
		 * 3.1创建linkman,name,age,email,adress元素
		 * 3.2给name,age,email,adress元素设置文本内容
		 * 3.3把name,age,eamil,adress元素作为linkman的子元素
		 * 3.4把linkman作为root的子元素
		 * 4.把内存中的数据同步到xml文件中
		 */
		
		File f = new File("D:/JavaWork/other/src/xml/contants.xml");
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		
		Element root = doc.getDocumentElement();
		
		Element linkmanEle = doc.createElement("linkman");
		Element nameEle = doc.createElement("age");
		Element eamilEle = doc.createElement("eamil");
		Element adressEle = doc.createElement("adress");
		Element ageEle = doc.createElement("age");
		
		nameEle.setTextContent("lili");
		eamilEle.setTextContent("1008611@yd.com");
		adressEle.setTextContent("月球");
		ageEle.setTextContent("23");
		
		linkmanEle.appendChild(nameEle);
		linkmanEle.appendChild(ageEle);
		linkmanEle.appendChild(eamilEle);
		linkmanEle.appendChild(adressEle);
		
		root.appendChild(linkmanEle);
		
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.transform(new DOMSource(doc),new StreamResult(f));
	}
}
