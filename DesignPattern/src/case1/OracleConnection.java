package case1;

/**
 * @ClassName OracleConnection
 * @Description TODO
 * @Author QZZ
 * @Date 2019/4/27 23:12
 * @Title 愿上苍有好生之德
 * @Description:
 **/
public class OracleConnection implements Connection{

    @Override
    public void createConnection() {
        System.out.println("oracle 连接对象");
    }
}
