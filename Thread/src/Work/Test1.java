package Work;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test1 {
	public static void main(String[] args) {
		Gui gui = new Gui();// 创建Gui的对象
		LabelThread_1 lt_1 = new LabelThread_1(gui); // 创建各线程的对象
		LabelThread_2 lt_2 = new LabelThread_2(gui);
		LabelThread_3 lt_3 = new LabelThread_3(gui);
		LabelThread_4 lt_4 = new LabelThread_4(gui);
		lt_1.start();// 对象启动
		lt_2.start();
		lt_3.start();
		lt_4.start();
	}
}

class Gui extends JFrame { // 窗口界面类
	private static final long serialVersionUID = 1L;
	JLabel jl_1;
	JLabel jl_2;
	JLabel jl_3;
	JLabel jl_4;
	JFrame jf;

	public Gui() {
		jf = new JFrame("多线程显示标签");// 设置标题
		jl_1 = new JLabel("标签一");
		jl_2 = new JLabel("标签二");
		jl_3 = new JLabel("标签三");
		jl_4 = new JLabel("标签四");
		// 四个标签都设置为不可见
		jl_1.setVisible(false);
		jl_2.setVisible(false);
		jl_3.setVisible(false);
		jl_4.setVisible(false);
		jf.setLayout(new FlowLayout(FlowLayout.CENTER));// 设置面板的布局管理
		jf.add(jl_1);// 把标签添加到面板
		jf.add(jl_2);
		jf.add(jl_3);
		jf.add(jl_4);
		jf.setSize(200, 200);
		jf.setVisible(true);// 面板设置为可见
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class LabelThread_1 extends Thread {// 标签一线程类
	private Gui gui;

	LabelThread_1(Gui gui) {
		this.gui = gui;
	}

	public void run() {
		try {
			gui.jl_1.setVisible(true);
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			System.out.print(ie.getMessage());
		}

	}
}

class LabelThread_2 extends Thread {// 标签二线程类
	private Gui gui;

	LabelThread_2(Gui gui) {
		this.gui = gui;
	}

	public void run() {
		try {
			Thread.sleep(1000);
			gui.jl_2.setVisible(true);
		} catch (InterruptedException ie) {
			System.out.print(ie.getMessage());
		}
	}
}

class LabelThread_3 extends Thread {// 标签三线程类
	private Gui gui;

	LabelThread_3(Gui gui) {
		this.gui = gui;
	}

	public void run() {
		try {
			Thread.sleep(3000); // 休眠
			gui.jl_3.setVisible(true);
		} catch (InterruptedException ie) {
			System.out.print(ie.getMessage());
		}
	}
}

class LabelThread_4 extends Thread {// 标签四线程类
	private Gui gui;

	LabelThread_4(Gui gui) {
		this.gui = gui;
	}

	public void run() {
		try {
			Thread.sleep(4000);
			gui.jl_4.setVisible(true);
		} catch (InterruptedException ie) {
			System.out.print(ie.getMessage());
		}

	}
}