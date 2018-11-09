package dom4j;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author 15626
 *	ʹ��dom4j��ȡdocument�Ķ���,��ѯ������ϵ����Ϣ
 */
public class GetDocument {
	public static void main(String[] args) throws DocumentException {
		File f = new File("D:/JavaWork/other/src/xml/contants.xml");
		SAXReader reader = new SAXReader();
		//��ȡDocument�Ķ���ע�����ﵼ��İ�����dom4j�İ�
		Document doc = reader.read(f);
		//��ȡ��Ԫ��
		Element root = doc.getRootElement();
		@SuppressWarnings("unchecked")
		//�õ���Ԫ�ص�������Ԫ�ض����list����
		List<Element> linkmanList = root.elements("linkman");
		//��List���ϵ���������elementText��ȡ�ı�����
		//Ҳ�����Ȼ�ȡԪ�ض���element()���ٻ�ȡ�ı�����getText()
		for (Element linkmanEle : linkmanList) {
			String name = linkmanEle.elementText("name");
			String age = linkmanEle.elementText("age");
			String adress = linkmanEle.elementText("adress");
			String email = linkmanEle.elementText("email");
			System.out.println(name + "," + age + "," + adress + "," +email);
		}
	}
}
