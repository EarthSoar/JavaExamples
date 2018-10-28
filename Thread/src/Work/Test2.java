package Work;

/**
 *	编写一个程序包括两个线程，第一个线程是计算2-10万之间质数的个数,第二个是计算10w到20w之间质数的个数。
 */
class Count{
	public void count(int x,int y){
		if(x > y){
			return;
		}
		int count = 0;
		for(int i = x;i < y; i++){
			if(isPrime(i) == 1){
				count++;
			}
		}
		System.out.println(count);
	}
	public int isPrime(int num){
		if(num == 2){
			return 1;
		}
		for(int i = 2;i < num /2;i++)
		{
			if(num % i == 0){
				return 0;
			}
		}
		return 1;
	}
}
class Thread11 implements Runnable{
	public void run() {
		new Count().count(2, 100000);
	}
}
class Thread22 implements Runnable{
	public void run(){
		new Count().count(100000, 200000);
	}
}
public class Test2 {
	public static void main(String[] args) {
		new Thread(new Thread11()).start();
		new Thread(new Thread22()).start();
	}
}
