package dom4j;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author 15626
 *	使用dom4j获取document的对象,查询所有联系人信息
 */
public class GetDocument {
	public static void main(String[] args) throws DocumentException {
		File f = new File("D:/JavaWork/other/src/xml/contants.xml");
		SAXReader reader = new SAXReader();
		//获取Document的对象，注意这里导入的包都是dom4j的包
		Document doc = reader.read(f);
		//获取根元素
		Element root = doc.getRootElement();
		@SuppressWarnings("unchecked")
		//得到根元素的所有子元素对象的list集合
		List<Element> linkmanList = root.elements("linkman");
		//对List集合迭代，调用elementText获取文本内容
		//也可以先获取元素对象element()，再获取文本内容getText()
		for (Element linkmanEle : linkmanList) {
			String name = linkmanEle.elementText("name");
			String age = linkmanEle.elementText("age");
			String adress = linkmanEle.elementText("adress");
			String email = linkmanEle.elementText("email");
			System.out.println(name + "," + age + "," + adress + "," +email);
		}
	}
}
