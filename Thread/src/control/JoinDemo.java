package control;

/**
 *	联合线程
 */
class Join extends Thread{
	public void run(){
		for(int i = 0; i < 50; i++){
			System.out.println("Join"+"--" + i);
		}
	}
}
public class JoinDemo {
	public static void main(String[] args) throws Exception {
		Join j = new Join();
		for(int i = 0;i < 50;i++){
			System.out.println("main" + "--" + i);
			if(i == 10){
				j.start();
			}
			if(i == 20){
				j.join();//强制执行，执行完该线程再执行主线程
			}
		}
	}
}
