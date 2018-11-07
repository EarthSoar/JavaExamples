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
 * 	��ȡxml�ļ���Ԫ�ص��ı�����
 * 
 *	�޸�xml�ļ���Ԫ�ص��ı�����
 */
public class UpdateDocument {
	public static void main(String[] args) throws Exception {
		//1.��ȡDocument����
		File f = new File("D:/JavaWork/other/src/xml/contants.xml");
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		//��ȡ����ĵ��ĸ�Ԫ��
		Element root = doc.getDocumentElement();
		//Ԫ�ص���getElementByTargetName("");�����Ԫ�����ƴ���Ԫ����ȥ��ȡĿ������ͬ�ķ���һ��NodeList��
		//���Ե�ͷiteam(int index) ��ȡ����Ϊindex��Ԫ�ض��� �����⻹��ҪǿתΪElement����
		//����ĵ�����docȥ����getElementByTargetName  ���������ĵ���ȥ��
		Element linkmanEle = (Element) root.getElementsByTagName("linkman").item(1);
		//��ȡemailԪ�ض���
		Element emailEle = (Element) linkmanEle.getElementsByTagName("email").item(0);
		//�õ�emailԪ���е��ı�����
		System.out.println(emailEle.getTextContent());
		
		
		//�޸�Ԫ���е��ı�����
		emailEle.setTextContent("shabi.com");
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer trans = factory.newTransformer();
		//����Դ��Դ���ڴ��е�Document����
		Source xmlSource = new DOMSource(doc);
		//����Ŀ�꣬Ŀ����xml�ļ�
		Result outputTarget = new StreamResult(f);
		//ͬ��
		trans.transform(xmlSource, outputTarget);
	}
}
