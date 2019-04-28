package case1;

/**
 * @ClassName OracleFactory
 * @Description TODO
 * @Author QZZ
 * @Date 2019/4/27 23:11
 * @Title 愿上苍有好生之德
 * @Description:
 **/
public class OracleFactory implements DBFactory{
    @Override
    public Connection createConnect() {
        return new OracleConnection();
    }

    @Override
    public Statement createStatement() {
        return new OracleStatement();
    }
}
