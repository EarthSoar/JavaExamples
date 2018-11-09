package dom4j;

import java.io.File;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * @author 15626 ����һ��xml�ĵ�������һ����ϵ��
 */
public class CreateDocument {
	public static void main(String[] args) throws Exception {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("Contants");
		Element linkmanEle = root.addElement("linkman");
		linkmanEle.addElement("name").addText("qianer");
		linkmanEle.addElement("age").addText("18");
		linkmanEle.addElement("email").addText("132@qq");

		// ͬ�����ļ���

		// A quick and easy way to write a Document
		// (or any Node) to a Writer is via the write() method.
		//��ӡ��ʽ��һ��
		FileWriter out = new FileWriter(new File("file/test.xml"));
		doc.write(out);
		out.close();

		//Ư���Ĵ�ӡ
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileWriter("file/test2.xml"), format);
		writer.write(doc);
		writer.close();
		
		//ѹ����ʽ��ӡ,��ӡ��һ��
		format = OutputFormat.createCompactFormat();
		writer = new XMLWriter(System.out, format);
		writer.write(doc);
		writer.close();
	}
}
