package control;

public class DeamonDemo {
	public static void main(String[] args) {
		//�ж�main�߳��Ƿ��̨�߳�
//		boolean b = Thread.currentThread().isDaemon();
//		System.out.println(b);
		//����main�߳�Ϊ��̨�߳�,�����߳�һ�������Ͳ����޸�Ϊ��̨�߳�
		//Thread.currentThread().setDaemon(true);
		//����������Demo�߳�,����Ϊ��̨�߳�
		/**
		 * ��ʱDemoΪ�ػ��̣߳������е�ǰ̨�̶߳�ִ����Ϻ��ػ��߳��Զ�����
		 * ����ᷢ�֣������߳�ִ����Ϻ��ػ��߳�Demoû��ִ�����Լ��ķ�����������
		 * ����Ҳ��һ���ػ��߳������ֹͣ�ˣ�ҲҪ�з�Ӧʱ��
		 */
		Demo d = new Demo();
		d.setDaemon(true);
		d.start();
		for (int i = 0; i < 20; i++) {
			System.out.println("main" + "--" + i);
		}
	}
}

class Demo extends Thread{
	@Override
	public void run() {
		for(int i = 0;i < 50;i++){
			System.out.println("Demo" + "--" + i);
		}
	}
}