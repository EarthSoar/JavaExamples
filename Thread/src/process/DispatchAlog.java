package process;

import java.util.Scanner;

class Process{
	String pid;
	int arriveTime;
	int serviceTime;
	int finishTime;
	int turnroundTime;
	double weightTime;
	public Process(int arriveTime, int serviceTime, String pid) {
		this.arriveTime = arriveTime;
		this.serviceTime = serviceTime;
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "Process [pid=" + pid + ", arriveTime=" + arriveTime + ", serviceTime=" + serviceTime + ", finishTime="
				+ finishTime + ", turnroundTime=" + turnroundTime + ", weightTime=" + weightTime + "]";
	}
}
public class DispatchAlog {
	public static void main(String[] args) {
		/*ps[0] = new Process(0,3,"A");
		ps[1] = new Process(2,6,"B");
		ps[2] = new Process(4,4,"C");*/
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入进程数:");
		Process[] ps = new Process[sc.nextInt()];
		for(int i = 0; i < ps.length; i++){
			System.out.print("请输入第" + (i + 1) + "个进程的进程名，就绪时间和服务时间：");
			ps[i] = new Process(sc.nextInt(),sc.nextInt(),sc.next());
		}
		sc.close();
		fcfs(ps);
		for (Process p : ps) {
			System.out.println(p);
		}
	}
	public static void fcfs(Process[] p){
		int preFinished = 0;
		for(int i = 0; i < p.length; i++){
			p[i].finishTime = preFinished + p[i].serviceTime;
			p[i].turnroundTime = p[i].finishTime - p[i].arriveTime;
			p[i].weightTime = (double)p[i].turnroundTime / (double)p[i].serviceTime;
			preFinished = p[i].finishTime;
		}
	}
}
