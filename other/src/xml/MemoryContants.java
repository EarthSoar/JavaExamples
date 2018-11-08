package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author 15626
 *	在内存中创建联系人
 *	由于xml文件不一定存在，判断是否存在，若不存在现在内存中创建，然后同步。
 */
public class MemoryContants {
	public static void main(String[] args) throws Exception {
		/**
		 * 1.判断xml文档是否存在
		 * 2.不存在就在内存中创建Document对象
		 * 3.创建一个linkman片段
		 * 3.1创建linkman,name,age,email,adress元素
		 * 3.2给name,age,email,adress元素设置文本内容
		 * 3.3把name,age,eamil,adress元素作为linkman的子元素
		 * 3.4把linkman作为root的子元素
		 * 4.把内存中的数据同步到xml文件中
		 */
		File f = new File("D:/JavaWork/other/src/xml/contants2.xml");
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = null;
		if(f.exists()){
			doc = builder.parse(f);
		}else{
			//在内存中创建document对象
			doc = builder.newDocument();
			//创建根元素
			Element root = doc.createElement("contants");
			//把根元素作为文档的子元素
			doc.appendChild(root);
		}
		//获取根元素
		Element root = doc.getDocumentElement(); 
		
		Element linmanEle = doc.createElement("linkman");
		Element nameEle = doc.createElement("name");
		Element ageEle = doc.createElement("age");
		Element emailEle = doc.createElement("email");
		Element adressEle = doc.createElement("adress");
		
		linmanEle.setAttribute("id", "886");
		nameEle.setTextContent("lihua");
		ageEle.setTextContent("11");
		emailEle.setTextContent("23@23.com");
		adressEle.setTextContent("haha");
		
		linmanEle.appendChild(nameEle);
		linmanEle.appendChild(ageEle);
		linmanEle.appendChild(emailEle);
		linmanEle.appendChild(adressEle);
		
		root.appendChild(linmanEle);
		
		TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(f));
	}
}
