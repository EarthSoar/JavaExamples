package test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Test2 extends JFrame{

	private static final long serialVersionUID = 1L;
	JFrame jf = new JFrame("计算");
	JTextField jtf_1 = new JTextField(15);
	JTextField jtf_2 = new JTextField(15);
	JTextField jtf_3 = new JTextField(15);
	JButton jb_1 = new JButton("+");
	JButton jb_2 = new JButton("-");
	JButton jb_3 = new JButton("*");
	JButton jb_4 = new JButton("/");
	int result = 0;
	public Test2() {
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.setSize(400, 300);
		jf.setLayout(new FlowLayout());
		jb_1.setBorderPainted(false);
		jb_2.setBorderPainted(false);
		jb_3.setBorderPainted(false);
		jb_4.setBorderPainted(false);
		jf.add(jtf_1);
		jf.add(jtf_2);
		jf.add(jtf_3);
		jf.add(jb_1);
		jf.add(jb_2);
		jf.add(jb_3);
		jf.add(jb_4);
		jb_1.addActionListener(add);
		jb_2.addActionListener(sub);
		jb_3.addActionListener(mul);
		jb_4.addActionListener(div);
	}
	public ActionListener add = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int value1 = Integer.parseInt(jtf_1.getText().trim());
			int value2 = Integer.parseInt(jtf_2.getText().trim());
			jtf_3.setText(String.valueOf(value1+value2));
		}
	};
	public ActionListener sub = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int value1 = Integer.parseInt(jtf_1.getText().trim());
			int value2 = Integer.parseInt(jtf_2.getText().trim());
			jtf_3.setText(String.valueOf(value1-value2));
		}
	};
	public ActionListener mul = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int value1 = Integer.parseInt(jtf_1.getText().trim());
			int value2 = Integer.parseInt(jtf_2.getText().trim());
			jtf_3.setText(String.valueOf(value1*value2));
		}
	};
	public ActionListener div = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int value1 = Integer.parseInt(jtf_1.getText().trim());
			int value2 = Integer.parseInt(jtf_2.getText().trim());
			jtf_3.setText(String.valueOf(value1/value2));
		}
	};
	public static void main(String[] args) {
		new Test2();
	}
}