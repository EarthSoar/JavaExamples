package process;

import java.io.IOException;
//�����java���Կ���һ������
public class ProcessDemo {
	public static void main(String[] args) throws IOException{
		//��ʽһ��ʹ��Runtime��exec����
		Runtime.getRuntime().exec("notepad");
		//��ʽ����ʹ��ProcessBuilder���е�start����
		ProcessBuilder pb = new ProcessBuilder("notepad");
		pb.start();
	}
}
