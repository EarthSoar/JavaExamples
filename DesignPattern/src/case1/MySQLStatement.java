package case1;

public class MySQLStatement implements Statement{
    @Override
    public void createStatement() {
        System.out.println("MySQL 语句对象");
    }
}
