package test;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Myself extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Myself();
			}
		});
	}
	public Myself() {
		JFrame jf = new JFrame("简历");
		JPanel jpt = new JPanel(null);
		JPanel jpl = new JPanel(null);
		JPanel jpr = new JPanel(null);
		jpt.setBackground(Color.WHITE);
		//jpl.setBackground(Color.yellow);
		//jpr.setBackground(Color.GREEN);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);//设置可见
		jf.setSize(540,700);
		jf.add(jpt);
		jf.add(jpl);
		jf.add(jpr);
		jpt.setBounds(5, 5, 572, 170);
		jpl.setBounds(5, 180, 400, 480);
		jpr.setBounds(410, 180, 170, 480);
		
		JLabel jL1 = new JLabel("三年工作经验");
		JLabel jL2 = new JLabel("21岁");
		JLabel jL3 = new JLabel("陕西");
		JLabel jL4 = new JLabel("88888888");
		JLabel jL5 = new JLabel("xxx@qq.com");
		JLabel jLp = new JLabel();
		JLabel jLp2 = new JLabel();
		JLabel jLName = new JLabel("GIAO");
		JLabel jL6 = new JLabel("求职意向");
		JLabel jL7 = new JLabel("职业技能");
		JLabel jL8 = new JLabel("教育背景");
		
		JLabel jL81 = new JLabel("学校: 西安工业大学         专业:软件工程");
		
		JLabel jL9 = new JLabel("自我评价");
		String s = "为人随和、待人真诚；工作认真负责，积极主动，能吃苦\n耐劳，勇于承受压力，上进心强、勤于学习，能不断提高\n自身的能力与综合素质。";
		JLabel jL91 = new JLabel(s);
		
		JLabel jL10 = new JLabel("个人爱好");
		JLabel jL101 = new JLabel("弹琴,下棋,书法,画画");
		JTextArea jta = new JTextArea(300,40);
		jta.setBounds(45, 325, 300,50);
		jta.setText(s);
		jta.setBackground(Color.cyan);
		jpl.add(jta);
		
		
		jL1.setBounds(30,80,100,20);
		jL2.setBounds(30,98,100,20);
		jL3.setBounds(30,116,100,20);
		jL4.setBounds(30,134,100,20);
		jL5.setBounds(30,152,100,20);
		jL6.setBounds(30,20,100,20);
		jLName.setBounds(230,130,140,40);
		jL7.setBounds(30,100,100,20);
		jL8.setBounds(30, 250, 100,20 );
		jL9.setBounds(30, 300, 100,20 );
		jL10.setBounds(30, 380, 100,20 );
		jL81.setBounds(45, 270, 300, 20);
		jL91.setBounds(45, 310, 300, 80);
		jL101.setBounds(45, 400, 300, 20);
		
		jL1.setFont(new Font("楷体", Font.BOLD, 15));
		jL2.setFont(new Font("楷体", Font.BOLD, 15));
		jL3.setFont(new Font("楷体", Font.BOLD, 15));
		jL4.setFont(new Font("楷体", Font.BOLD, 15));
		jL5.setFont(new Font("楷体", Font.BOLD, 15));
		jL6.setFont(new Font("楷体", Font.BOLD, 13));
		jL7.setFont(new Font("楷体", Font.BOLD, 13));
		jL8.setFont(new Font("楷体", Font.BOLD, 13));
		jL9.setFont(new Font("楷体", Font.BOLD, 13));
		jL10.setFont(new Font("楷体", Font.BOLD, 13));
		jL101.setFont(new Font("宋体", Font.BOLD, 13));
		
		jLName.setFont(new Font("微软雅黑", Font.BOLD, 30));
		jpt.add(jL1);
		jpt.add(jL2);
		jpt.add(jL3);
		jpt.add(jL4);
		jpt.add(jL5);
		jpt.add(jLp);
		jpl.add(jLp2);
		jpt.add(jLName);
		jpl.add(jL6);
		jpl.add(jL7);
		jpl.add(jL8);
		jpl.add(jL9);
		jpl.add(jL10);
		jpl.add(jL81);
		jpl.add(jL91);
		jpl.add(jL101);
		Icon ic = new ImageIcon("file/giao.jpg");
		Icon ic2 = new ImageIcon("file/111.png");
		jLp.setBounds(220, 20, 200, 100);
		jLp.setIcon(ic);
		jLp2.setBounds(400, 300, 100, 100);
		jLp2.setIcon(ic2);
		
		JRadioButton jr1 = new JRadioButton("开发工程师");
		JRadioButton jr2 = new JRadioButton("测试工程师");
		JRadioButton jr3 = new JRadioButton("算法工程师");
		
		JCheckBox cb1 = new JCheckBox("熟练掌握java基础知识",true);
		JCheckBox cb2 = new JCheckBox("熟悉面向对象编程思想，熟练MVC设计模式",true);
		JCheckBox cb3 = new JCheckBox("熟练Struts+Hibernate，SSH2框架和MVC三层架构开发模式",true);
		JCheckBox cb4 = new JCheckBox("熟练使用Jsp，HTML，JavaScript，Jquery，Ajax，Css等",true);
		JCheckBox cb5 = new JCheckBox("了解设计模式，代码重构和项目过程管理，能够编写文档",true);
		JCheckBox cb6 = new JCheckBox("熟练Mysql数据库的操作,熟悉Oracle和SqlServer数据库",true);
		
		cb1.setBounds(40, 120, 500, 20);
		cb2.setBounds(40, 140, 500, 20);
		cb3.setBounds(40, 160, 500, 20);
		cb4.setBounds(40, 180, 500, 20);
		cb5.setBounds(40, 200, 500, 20);
		cb6.setBounds(40, 220, 500, 20);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jr1);
		bg.add(jr2);
		bg.add(jr3);
		jr1.setBounds(40, 40, 100, 20);
		jr2.setBounds(40, 60, 100, 20);
		jr3.setBounds(40, 80, 100, 20);
		jpl.add(jr1);
		jpl.add(jr2);
		jpl.add(jr3);
		jpl.add(cb1);
		jpl.add(cb2);
		jpl.add(cb3);
		jpl.add(cb4);
		jpl.add(cb5);
		jpl.add(cb6);
	}
}
