package test;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Test3 extends JFrame{
	private static final long serialVersionUID = 1L;
	JFrame jf = new JFrame("改变颜色");
	JTextField jtf = new JTextField(25);
	JPanel jp1 = new JPanel();
	JButton jb_1 = new JButton("红");
	JButton jb_2 = new JButton("绿");
	JButton jb_3 = new JButton("蓝");
	public Test3() {
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.setSize(600, 300);
		jf.setLayout(new GridLayout(2,3,3,3));
		jf.add(jtf);
		jf.add(jp1);
		jp1.setLayout(new GridLayout(1,3,3,3));
		jp1.add(jb_1);
		jp1.add(jb_2);
		jp1.add(jb_3);
		jb_1.addActionListener(jb1Red);
		jb_2.addActionListener(jb2Green);
		jb_3.addActionListener(jb3Blue);
	}
	public ActionListener jb1Red = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			jtf.setBackground(Color.RED);
		}
	};
	public ActionListener jb2Green = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			jtf.setBackground(Color.GREEN);
		}
	};
	public ActionListener jb3Blue = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			jtf.setBackground(Color.BLUE);
		}
	};
	public static void main(String[] args) {
		new Test3();
	}
}

