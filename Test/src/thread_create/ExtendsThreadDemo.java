package thread_create;
//�̳з�ʽ �����������߳�
class MusicThread extends Thread{      //MusicThread���߳�����
	public void run() {               //���������дrun()����
		for(int i = 0 ;i < 50;i++)
		{
			System.out.println("������"+i);
		}
	}
	
}
public class ExtendsThreadDemo {
	public static void main(String[] args){
		for(int i = 0 ;i < 50;i++)
		{
			System.out.println("����Ϸ"+i);
			if( i == 10){
				MusicThread t = new MusicThread();  //�����߳������ʵ��
				t.start(); //�ײ�Ҳ������run();  �����߳�
			}
		}
			
	}
}
