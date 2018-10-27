package producer_consumer;

/**
 * 	������Դ��,����˵��һ��������
 *
 *	��synchronized���η��������Զ���ȡ�����Զ��ͷ�����java5֮���ṩ��Lock���ƣ������Լ���ȡ���Լ��ͷ���
 *	 ��Lock����д����ShareResouce2.java
 */
public class ShareResource {
	private String name;
	private String sex;
	private boolean isEmpty = true;//�жϹ������պ�����һ����־
	//����������
	synchronized public void product(String name,String sex){
		try {
			while(!isEmpty){//���������գ���������Ҫͣ�µȴ�����������
				/**
				 * this��ͬ����(ͬ����������)��wait������Object���� �ķ��������ø÷������ͷ�ͬ����
				 * Ȼ��JVM�Ѹ��̴߳�ŵ��ȴ����У��ȴ������̻߳��Ѹ��߳�
				 * �÷���ֻ�ܱ�ͬ������������ã����򱨴�IllegalMonitorStateException.
				 */
				
				this.wait();
			}
			//----------��ʼ����-----------
			this.name = name;
			Thread.sleep(10);
			this.sex = sex;
			//---------��������------------
			isEmpty = false;  //���ù�����Ϊ����
			/**
			 * notify�����ǻ��ѵȴ����е����һ���̣߳����߳�ת�Ƶ������еȴ�(�������л����ȡ����)
			 * notifyAll�����ǻ��ѵȴ����е������̣߳����߳�ת�Ƶ������еȴ�
			 * �÷���ֻ�ܱ�ͬ���������������ã����򱨴�
			 */
			this.notify();	//����һ��������               notify�ǻ�������һ����notifyAll�ǻ���ȫ��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//����������
	synchronized public void consume(){
		try {
			while(isEmpty){//��������Ϊ��ʱ�������߽��еȴ�
				this.wait();
			}
			//------------��ʼ����-------------
			Thread.sleep(30);
			System.out.println(name + " " + sex);
			//------------��������-------------
			isEmpty = true;
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
}