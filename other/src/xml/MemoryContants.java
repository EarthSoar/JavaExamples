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
 *	���ڴ��д�����ϵ��
 *	����xml�ļ���һ�����ڣ��ж��Ƿ���ڣ��������������ڴ��д�����Ȼ��ͬ����
 */
public class MemoryContants {
	public static void main(String[] args) throws Exception {
		/**
		 * 1.�ж�xml�ĵ��Ƿ����
		 * 2.�����ھ����ڴ��д���Document����
		 * 3.����һ��linkmanƬ��
		 * 3.1����linkman,name,age,email,adressԪ��
		 * 3.2��name,age,email,adressԪ�������ı�����
		 * 3.3��name,age,eamil,adressԪ����Ϊlinkman����Ԫ��
		 * 3.4��linkman��Ϊroot����Ԫ��
		 * 4.���ڴ��е�����ͬ����xml�ļ���
		 */
		File f = new File("D:/JavaWork/other/src/xml/contants2.xml");
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = null;
		if(f.exists()){
			doc = builder.parse(f);
		}else{
			//���ڴ��д���document����
			doc = builder.newDocument();
			//������Ԫ��
			Element root = doc.createElement("contants");
			//�Ѹ�Ԫ����Ϊ�ĵ�����Ԫ��
			doc.appendChild(root);
		}
		//��ȡ��Ԫ��
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
