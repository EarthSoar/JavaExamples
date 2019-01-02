package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {
	static Scanner sc = new Scanner(System.in);
	static int a;
	public static List<Integer> init() {
		LinkedList<Integer> list = new LinkedList<>();
		list.addAll(Arrays.asList(4, 2, 3, 3, 5));
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
			list.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});
			if (list.get(i) >= size) {
				list.set(i, list.get(i) - size);
				System.out.println("分配成功");
				return;
			}
		}
		System.out.println("分配失败");
	}
	public static void worst(List<Integer> list, int size) {
		for (int i = 0; i < list.size(); i++) {
			list.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			if (list.get(i) >= size) {
				list.set(i, list.get(i) - size);
				System.out.println("分配成功");
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
			System.out.println("   1: 先来先服务算法分配  2:循环首次适应算法分配");
			System.out.println("   3: 最佳适应算法分配       4: 最坏适应算法分配");
			System.out.println("   5: 退出");
			System.out.print("请输入操作: ");
			op = sc.nextInt();
			switch (op) {
			case 1:
				System.out.print("请输入作业的大小：");
				ff(list, sc.nextInt());
				System.out.println(list);
				break;
			case 2:
				System.out.print("请输入作业的大小：");
				xh(list,sc.nextInt(),a);
				System.out.println(list);
				break;
			case 3:
				System.out.print("请输入作业的大小：");
				best(list, sc.nextInt());
				System.out.println(list);
				break;
			case 4:
				System.out.print("请输入作业的大小：");
				worst(list, sc.nextInt());
				System.out.println(list);
				break;
			case 5:
				return;
			}
		}
	}
}
