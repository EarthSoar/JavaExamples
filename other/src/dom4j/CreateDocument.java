package dom4j;

import java.io.File;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * @author 15626 创建一个xml文档，增加一个联系人
 */
public class CreateDocument {
	public static void main(String[] args) throws Exception {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("Contants");
		Element linkmanEle = root.addElement("linkman");
		linkmanEle.addElement("name").addText("qianer");
		linkmanEle.addElement("age").addText("18");
		linkmanEle.addElement("email").addText("132@qq");

		// 同步到文件中

		// A quick and easy way to write a Document
		// (or any Node) to a Writer is via the write() method.
		//打印格式是一行
		FileWriter out = new FileWriter(new File("file/test.xml"));
		doc.write(out);
		out.close();

		//漂亮的打印
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileWriter("file/test2.xml"), format);
		writer.write(doc);
		writer.close();
		
		//压缩形式打印,打印出一行
		format = OutputFormat.createCompactFormat();
		writer = new XMLWriter(System.out, format);
		writer.write(doc);
		writer.close();
	}
}
