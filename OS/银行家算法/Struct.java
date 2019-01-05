package tt;

import java.util.HashMap;
import java.util.Scanner;

public class Struct {

	private int resourceNum;
	private int processNum;
	// 可用资源向量,key表示资源号,value表示该资源的可用数目
	private HashMap<Integer, Integer> availableResource;
	// 最大需求矩阵,n:进程号,m:资源号,值为最大需求
	private int[][] maxRequestMatrix;
	// 分配矩阵,n:进程号,m:资源号,值为已分配数
	private int[][] allocationMatrix;
	// 需求矩阵 ，n:进程号,m:资源号,值为还需资源数
	private int[][] needMatirx;

	public Struct(int resourceNum, int processNum) {
		this.resourceNum = resourceNum;
		this.processNum = processNum;
		this.availableResource = new HashMap<Integer, Integer>();
	}

	public void init() {

		maxRequestMatrix = new int[processNum][resourceNum];
		allocationMatrix = new int[processNum][resourceNum];
		needMatirx = new int[processNum][resourceNum];

		Scanner s = new Scanner(System.in);
		System.out.println("初始化最大需求矩阵：");
		for (int n = 0; n < processNum; n++) {
			System.out.print("  请输入第" + n + "个进程最大需求资源量:");
			for (int m = 0; m < resourceNum; m++) {
				maxRequestMatrix[n][m] = s.nextInt();
			}
		}

		System.out.println("初始化已分配矩阵：");
		for (int n = 0; n < processNum; n++) {
			System.out.print("  请输入第" + n + "个进程分配的资源:");
			for (int m = 0; m < resourceNum; m++) {
				allocationMatrix[n][m] = s.nextInt();
			}
		}
		
		System.out.println("初始化当先系统可利用资源：");
		for (int n = 0; n < resourceNum; n++) {
			System.out.print("	请输入第" + n + "个资源数:");
			if (s.hasNext()) {
				availableResource.put(n, s.nextInt());
			}
		}

		for (int i = 0; i < processNum; i++) {
			for (int j = 0; j < resourceNum; j++) {
				needMatirx[i][j] = maxRequestMatrix[i][j] - allocationMatrix[i][j];
			}
		}
	}

	public int getResourceNum() {
		return resourceNum;
	}

	public void setResourceNum(int resourceNum) {
		this.resourceNum = resourceNum;
	}

	public int getProcessNum() {
		return processNum;
	}

	public void setProcessNum(int processNum) {
		this.processNum = processNum;
	}

	public HashMap<Integer, Integer> getAvailableResource() {
		return availableResource;
	}

	public void setAvailableResource(HashMap<Integer, Integer> availableResource) {
		this.availableResource = availableResource;
	}

	public int[][] getMaxRequestMatrix() {
		return maxRequestMatrix;
	}

	public void setMaxRequestMatrix(int[][] maxRequestMatrix) {
		this.maxRequestMatrix = maxRequestMatrix;
	}

	public int[][] getAllocationMatrix() {
		return allocationMatrix;
	}

	public void setAllocationMatrix(int[][] allocationMatrix) {
		this.allocationMatrix = allocationMatrix;
	}

	public int[][] getNeedMatirx() {
		return needMatirx;
	}

	public void setNeedMatirx(int[][] needMatirx) {
		this.needMatirx = needMatirx;
	}

}
