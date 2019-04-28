package case1;

public class MySQLFactory implements DBFactory{
    @Override
    public Connection createConnect() {
        return new MySQLConnection();
    }

    @Override
    public Statement createStatement() {
        return new MySQLStatement();
    }
}
