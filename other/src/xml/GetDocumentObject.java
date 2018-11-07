package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

/**
 * @author 15626
 *	��ȡdocument�ĵ��Ķ���
 */
public class GetDocumentObject {
	public static void main(String[] args) throws Exception {
		//������Ҫ����xml�ļ��Ķ���
		File f = new File("D:/JavaWork/other/src/xml/contants.xml");
		//���ù�����ľ�̬������ȡ�Լ��Ķ���
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//��ȡbuilder����
		DocumentBuilder builder = factory.newDocumentBuilder();
		//����builder�������һ���Ѿ����ڵ�xml�ļ�,�õ�Document����
		//parse�������ĵ����ڵ�ʱ����н�����newDoument�������ĵ������ڵ�ʱ�����ڴ��д���һ��Document����
		Document doc = builder.parse(f);
		System.out.println(doc);
	}
}
