package case1;

import org.w3c.dom.NodeList;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLUtil {
	public static Object getBean() {
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().
					parse(new File("file/config.xml"));
			NodeList n1 = doc.getElementsByTagName("className");
			Node classNode = n1.item(0).getFirstChild();
			String cName = classNode.getNodeValue();
			Object obj = Class.forName("case1." + cName).newInstance();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
