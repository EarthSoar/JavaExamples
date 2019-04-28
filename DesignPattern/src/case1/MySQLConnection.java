package case1;

public class MySQLConnection implements Connection{
    @Override
    public void createConnection() {
        System.out.println("MySQL 连接对象... ...");
    }
}
