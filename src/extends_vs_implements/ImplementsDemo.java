package extends_vs_implements;
class Apple implements Runnable{
	private int num = 50;
	public void run(){
		for(int i = 0; i< 50 ;i++){
			if(num > 0){
				System.out.println(Thread.currentThread().getName()+"���˵�"+num--+"��ƻ��");
			}//Thread.currentThread()   ���ضԵ�ǰ����ִ�е��̶߳�������á�
		}
	}
}
//ʹ��ʵ��Runnable�ӿڵķ�ʽ�����ַ������Խ��������
public class ImplementsDemo {
	public static void main(String[] args){
		Runnable r = new Apple();
		new Thread(r,"A").start();
		new Thread(r,"B").start();
		new Thread(r,"C").start();
	}
}
