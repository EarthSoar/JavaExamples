package facade;

/**
 * @author Willing
 * @date 2019/4/27
 */
public class CipherMachine {
    public String encrypt(String plainText){
        System.out.println("加密");
        return "加密"+plainText;
    }
}
