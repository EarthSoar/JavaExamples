package producer_consumer;

public class Producer implements Runnable{
	ShareResource resource = null;
	public Producer(ShareResource resource){
		this.resource = resource;
	}
	@Override
	public void run() {
		for(int i = 0; i < 50;i++){
			if(i % 2 == 0){
				resource.product("ÀîÐ¡Áú", "ÄÐ");
			}else{
				resource.product("¹·êÏ","Å®");
			}
		}
	}
	
}
