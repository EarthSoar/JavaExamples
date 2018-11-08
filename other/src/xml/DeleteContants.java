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
 *	ɾ��ָ��Ԫ�ؽڵ㣺ɾ����������ϵ����Ϣ
 *	Ԫ�ض���.getParentNode().removeChild(Ԫ�ض���);
 *	��Ԫ�ؽڵ�.removeChild(��Ԫ�ؽڵ�);
 */
public class DeleteContants {
	public static void main(String[] args) throws Exception {
		/**
		 * 1.��ȡDocument����
		 * 2.��ȡ�ĵ��ĸ�Ԫ��
		 * 3.��ȡ�������˵�Ԫ�ض���
		 * 4.ɾ����������ϵ��
		 * 5.ͬ�������ڴ��е�����ͬ����xml�ļ���
		 */
		File f = new File("D:/JavaWork/other/src/xml/contants.xml");
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		
		Element root = doc.getDocumentElement();
		
		Element linkmanEle = (Element) root.getElementsByTagName("linkman").item(2);
		
		//ɾ����ϵ��
		//linkmanEle.getParentNode().removeChild(linkmanEle);
		root.removeChild(linkmanEle);
		
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.transform(new DOMSource(doc), new StreamResult(f));
	}
}
