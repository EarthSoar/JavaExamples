package case2;

public class Client {
    public static void main(String[] args) {
        ActorBuilder ac = (ActorBuilder)XMLUtil2.getBean();
        ActorController actor = new ActorController();
        actor.construct(ac);
    }
}
