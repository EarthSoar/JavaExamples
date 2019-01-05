package tt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Bank {
	static Scanner sc = new Scanner(System.in);

	// needMatirx = maxMatrix - allocationMatirx
	// 如果存在安全序列，则为安全状态；否则为不安全状态。
	public static void main(String[] args) {
		Struct struct = new Struct(2, 3);// 资源数,进程数
		struct.init();
		printCurrentStatus(struct);
		
		while (true) {
			requestResource(struct);
			System.out.println("是否继续分配资源y/n");
			if (!"y".equals(sc.next())) {
				break;
			}
		}
	}

	private static void requestResource(Struct struct) {
		// 开始一个请求
		System.out.print("输入请求的进程:");
		int[] request = new int[struct.getResourceNum()];
		// 请求的进程p
		int p = sc.nextInt();
		for (int i = 0; i < struct.getResourceNum(); i++) {
			System.out.print("输入请求资源" + i + "的数目: ");
			int num = sc.nextInt();
			request[i] = num;
		}
		// 判断请求的合法性
		for (int i = 0; i < struct.getResourceNum(); i++) {
			if (request[i] > struct.getNeedMatirx()[p][i]) {
				System.out.println("请求的资源超出需求!");
				return;
			}
		}
		for (int i = 0; i < struct.getResourceNum(); i++) {
			if (request[i] > struct.getAvailableResource().get(i)) {
				System.out.println("请求的资源超出可分配资源!");
				return;
			}
		}

		// 试分配
		for (int i = 0; i < struct.getResourceNum(); i++) {
			int newAR = struct.getAvailableResource().get(i) - request[i];
			struct.getAvailableResource().put(i, newAR);
			struct.getAllocationMatrix()[p][i] += request[i];
			struct.getNeedMatirx()[p][i] -= request[i];
		}
		System.out.println("试分配后的状态:");
		printCurrentStatus(struct);
		// 安全性检查
		checkSecurity(struct, request, p);
	}

	private static void checkSecurity(Struct struct, int[] request, int p) {
		// 可提供给进程的各资源数目
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer> work = (HashMap<Integer, Integer>) struct.getAvailableResource().clone();
		// 当有足够资源分配给进程时，finish=true
		HashMap<Integer, Boolean> finish = new HashMap<Integer, Boolean>();
		for (int i = 0; i < struct.getProcessNum(); i++) {
			finish.put(i, false);
		}

		// 从进程集合中找到一个满足以下条件的进程:
		// finish = false
		// need <= work
		ArrayList<Integer> saveSequence = new ArrayList<Integer>();// 安全序列
		for (int i = 0; i < struct.getProcessNum(); i++) {
			int count = 0;
			for (int j = 0; j < struct.getResourceNum(); j++) {
				if (finish.get(i).equals(false) && struct.getNeedMatirx()[i][j] <= work.get(j)) {
					count++;
				}
			}
			if (count == struct.getResourceNum()) {
				// 找到了满足条件的资源,加入序列
				for (int j = 0; j < struct.getResourceNum(); j++) {
					int newAM = work.get(j) + struct.getAllocationMatrix()[i][j];
					work.put(j, newAM);
				}
				finish.put(i, true);
				saveSequence.add(i);
				i = -1;
			}
		}
		// 当前请求进程号

		for (boolean v : finish.values()) {
			if (!v) {
				System.out.println("ERROR:无法找到安全序列，系统处于不安全状态!");

				// 回收资源
				for (int i = 0; i < struct.getResourceNum(); i++) {
					int newAR = struct.getAvailableResource().get(i) + request[i];
					struct.getAvailableResource().put(i, newAR);
					struct.getAllocationMatrix()[p][i] -= request[i];
					struct.getNeedMatirx()[p][i] += request[i];
				}
				System.out.println("---------------------");
				System.out.println("资源回收后的状态");
				printCurrentStatus(struct);
				return;
			}
		}

		System.out.println("分配资源后线程安全，安全序列:");
		for (int x : saveSequence) {
			System.out.print("进程" + x + " -> ");
		}
		System.out.println("end");
	}

	private static void printCurrentStatus(Struct struct) {
		System.out.println("当前状态:");
		System.out.println("===============================================");
		System.out.println("可获得资源:");
		System.out.print("    ");
		for (int i = 0; i < struct.getResourceNum(); i++) {
			System.out.print("资源" + i + "  ");
		}
		System.out.println();
		System.out.print("    ");

		for (int v : struct.getAvailableResource().values()) {
			System.out.print(v + "\t");
		}
		System.out.println();
		System.out.println();
		System.out.println("-----------------------------------------------");
		printMatrix("最大需求矩阵", struct);
		System.out.println("-----------------------------------------------");
		printMatrix("分配矩阵", struct);
		System.out.println("-----------------------------------------------");
		printMatrix("需求矩阵", struct);
		System.out.println("-----------------------------------------------");
	}

	private static void printMatrix(String matrixName, Struct struct) {
		System.out.println(matrixName + ":");
		System.out.print("    ");
		for (int i = 0; i < struct.getProcessNum(); i++) {
			System.out.print("\t" + "进程" + i + "");
		}
		System.out.println();
		for (int i = 0; i < struct.getResourceNum(); i++) {
			System.out.print("资源" + i + "\t");
			for (int j = 0; j < struct.getProcessNum(); j++) {
				if (matrixName.equals("最大需求矩阵")) {
					System.out.print(struct.getMaxRequestMatrix()[j][i] + "\t");
				} else if (matrixName.equals("分配矩阵")) {
					System.out.print(struct.getAllocationMatrix()[j][i] + "\t");
				} else if (matrixName.equals("需求矩阵")) {
					System.out.print(struct.getNeedMatirx()[j][i] + "\t");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
