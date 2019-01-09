package util;

/**
 * @author Willing
 * @date 2019/1/8
 */
public class StringUtil {
    /**
     * 判断字符是否为空字符串(包括"")
     * @param str
     * @return 空字符串返回false
     */
    public static boolean hasLength(String str){
        return str != null && !"".equals(str.trim());
    }
}
