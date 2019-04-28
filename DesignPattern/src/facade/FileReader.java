package facade;

/**
 * @author Willing
 * @date 2019/4/27
 */
public class FileReader {
    public String read(String fileNameSrc){
        System.out.println("从"+fileNameSrc+"读文件");
        return fileNameSrc;
    }
}
