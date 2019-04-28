package case1;

public class Client {
	public static void main(String[] args) {
		DBFactory factory = (DBFactory) XMLUtil.getBean();
		Connection cn = factory.createConnect();
		Statement st = factory.createStatement();
		cn.createConnection();
		st.createStatement();
	}
}
