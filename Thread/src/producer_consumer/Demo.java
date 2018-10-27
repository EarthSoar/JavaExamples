package producer_consumer;

public class Demo {
	public static void main(String[]args){
		ShareResource resource = new ShareResource();
		new Thread(new Producer(resource)).start();
		new Thread(new Consumer(resource)).start();
	}
}
