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
 *	��ָ��Ԫ�ؽڵ��в�����Ԫ�ؽڵ㣬����һ����ϵ����Ϣ
 *
 *	<linkman>
		<age>lili</age>
		<age>23</age>
		<eamil>1008611@yd.com</eamil>
		<adress>����</adress>
	</linkman>
 */

public class AddContants {
	public static void main(String[] args) throws Exception {
		/**
		 * 1.��ȡDocument�ĵ��Ķ���
		 * 2.��ȡ��Ԫ��
		 * 3.����һ��linkmanƬ��
		 * 3.1����linkman,name,age,email,adressԪ��
		 * 3.2��name,age,email,adressԪ�������ı�����
		 * 3.3��name,age,eamil,adressԪ����Ϊlinkman����Ԫ��
		 * 3.4��linkman��Ϊroot����Ԫ��
		 * 4.���ڴ��е�����ͬ����xml�ļ���
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
		adressEle.setTextContent("����");
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
