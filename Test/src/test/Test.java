package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {
	static Scanner sc = new Scanner(System.in);
	static int a;
	public static List<Integer> init() {
		LinkedList<Integer> list = new LinkedList<>();
		list.addAll(Arrays.asList(1, 2, 3, 3, 5));
		return list;
	}

	public static void ff(List<Integer> list, int size) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) >= size) {
				list.set(i, list.get(i) - size);
				System.out.println("分配成功");
				return;
			}
		}
		System.out.println("分配失败");
	}
	public static void xh(List<Integer> list, int size,int n) {
		if(a + 1 > list.size()) {
			a = 0;
		}
		for (int i = a; i < list.size(); i++) {
			if (list.get(i) >= size) {
				list.set(i, list.get(i) - size);
				System.out.println("分配成功");
				a = i;
				return;
			}
		}
		System.out.println("分配失败");
	}
	public static void best(List<Integer> list, int size) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) >= size) {
				list.set(i, list.get(i) - size);
				System.out.println("分配成功");
				list.toArray();
				return;
			}
		}
		System.out.println("分配失败");
	}

	public static void main(String[] args) {
		// 初始化内存
		List<Integer> list = init();

		int op = 0;
		while (true) {
			System.out.println("\n************************************************");
			System.out.println("   1: 为新作业分配内存 ");
			System.out.println("   2: 查看FF算法内存分配      3: 退出");
			System.out.print("请输入操作: ");
			op = sc.nextInt();
			switch (op) {
			case 1:
				System.out.print("请输入作业的大小：");
				ff(list, sc.nextInt());
				break;
			case 2:
				System.out.println(list);
				break;
			case 3:
				return;
			case 4:
				System.out.print("请输入作业的大小：");
				xh(list,sc.nextInt(),a);
				break;
			}
		}
	}
}
