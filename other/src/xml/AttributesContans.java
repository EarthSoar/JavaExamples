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
 *	����Ԫ�ص����ԣ����ò���ȡ�������˵�id
 */
public class AttributesContans {
	public static void main(String[] args) throws Exception {
		/**
		 * 1.��ȡDocument�ĵ�����
		 * 2.����ĵ��ĸ�Ԫ��
		 * 3.��õ����˵�����
		 * 4.���õ����˵�����
		 * 5.ͬ�������ڴ��е�����ͬ����xml�ļ���
		 */
		File f = new File("D:/JavaWork/other/src/xml/contants.xml");
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		
		Element root = doc.getDocumentElement();
		//�õ��������˵�Ԫ�ض���
		Element linkmanEle = (Element) root.getElementsByTagName("linkman").item(2);
		
		//��ȡ����id��ֵ
		String name = linkmanEle.getAttribute("id");
		System.out.println(name);
		//��������ֵ
		linkmanEle.setAttribute("id", "88");
		
		//ͬ��
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.transform(new DOMSource(doc), new StreamResult(f));
	}
}
