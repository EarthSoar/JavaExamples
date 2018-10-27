package producer_consumer;

public class Consumer implements Runnable {
	ShareResource resource = null;
	public Consumer(ShareResource resource){
		this.resource = resource;
	}
	public void run(){
		for(int i = 0;i < 50;i++){
			resource.consume();
		}
	}
}
