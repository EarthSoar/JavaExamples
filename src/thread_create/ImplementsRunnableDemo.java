package thread_create;
class MusicRunnable implements java.lang.Runnable{         //ע��MusicRunnable�಻���߳�������߳�����
	public void run() {									   //�ӿڵ�ʵ�ֱ��븲�Ƿ�����				
		for(int i = 0 ;i < 50;i++)
		{
			System.out.println("������"+i);
		}
	}
}
public class ImplementsRunnableDemo {
	public static void main(String[] args){
		for(int i = 0 ;i < 50;i++)
		{
			System.out.println("����Ϸ"+i);
			if( i == 10){
				Runnable t = new MusicRunnable();        //�����̱߳������߳���������start();
				new Thread(t).start();             //��Thread��һ����������Thread(Runnable target)�����µ� Thread ����
			}
		}
	}
}
