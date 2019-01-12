package util;

abstract public class CommUtil {
	
	public static boolean hasLength(String str){
		return str!= null && !"".equals(str.trim()); 
	}
}
