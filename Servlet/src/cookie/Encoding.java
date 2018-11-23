package cookie;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class Encoding {
	public static void main(String[] args) throws Exception {
		String name = "狗哲";
		String ret = URLEncoder.encode(name, "UTF-8");
		System.out.println(ret);
		String result = URLDecoder.decode(ret, "UTF-8");
		System.out.println(result);
	}
}
