package process;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class SJF {
	public static void main(String[] args) {
		// 对进程的到达时间排序
		Arrays.sort(Process.processes, Comparator.comparingInt(e -> e.arriveTimePoint));
		// 队列模拟程序调度
		LinkedList<Process> queue = new LinkedList<>();

		// 未到达的进程序号
		int arriveProcessIndex = 0;

		// 直接跳到第一个到达的进程
		int timePoint = Process.processes[0].arriveTimePoint;
		queue.add(Process.processes[0]);

		arriveProcessIndex++;
		while (true) {
			Process process = null;
			// 根据服务时间进行排序
			Arrays.sort(Process.processes, Comparator.comparingInt(e -> e.serveTime));
			queue.add(process);
			if (!queue.isEmpty()) {
				process = queue.poll();
			}
			// 判断该时刻有无进程到达
			if (arriveProcessIndex < Process.processes.length
					&& timePoint >= Process.processes[arriveProcessIndex].arriveTimePoint) {
				queue.add(Process.processes[arriveProcessIndex]);
				arriveProcessIndex++;
			}
			// 所有进程都已经到达且队列为空
			if (arriveProcessIndex >= Process.processes.length && queue.isEmpty()) {
				break;
			}
		}
	}
}
