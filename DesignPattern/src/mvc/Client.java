package mvc;

/**
 * @author Willing
 * @date 2019/4/27
 */
public class Client {
    public static void main(String[] args) {
        Stock stock = new Stock("青岛海尔", 10);
        Investor investor1 = new ConcreteInvestor("杨过");
        Investor investor2 = new ConcreteInvestor("小龙女");
        stock.attach(investor1);
        stock.attach(investor2);
        stock.setPrice(20);
    }
}
