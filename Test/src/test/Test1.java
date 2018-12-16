package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test1 extends JFrame implements MouseListener,MouseMotionListener{
	private static final long serialVersionUID = 1L;
	JFrame jf = new JFrame("画图");
	JPanel jp_1 = new JPanel();
	JPanel jp_2 = new JPanel();
	JPanel jp_3 = new JPanel();
	int x1, y1, x2, y2;
	int flag = 0;
	private JButton[] jb_shape = {new JButton("圆"),new JButton("椭圆"),new JButton("圆弧"),new JButton("字符串")};
	Color[] color = {Color.BLACK,new Color(169,169,169),
			         Color.RED,Color.ORANGE,Color.YELLOW,
			         Color.GREEN,new Color(0,191,255),
			         Color.BLUE,new Color(138,43,226)} ;
	public Test1() {
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(700, 600);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		//添加鼠标事件监听
		jf.addMouseListener(this);
		jf.addMouseMotionListener(this);
		//添加面板1
		jf.add(jp_1,BorderLayout.NORTH);
		for(int i = 0; i<jb_shape.length; i++) {
			jp_1.add(jb_shape[i]);
			jb_shape[i].addActionListener(al);
		}
		//添加面板2
		jf.add(jp_2,BorderLayout.CENTER);
		jp_2.setBackground(Color.WHITE);
		//添加面板3
		jf.add(jp_3,BorderLayout.SOUTH);
		for(int i = 0; i<color.length; i++) {
			JButton jb_color = new JButton();
			jp_3.add(jb_color);
			jb_color.setBackground(color[i]);
		}
		
	}
	public ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Graphics g = jf.getGraphics();
			if(e.getActionCommand().equals("圆")	){
				g.drawOval( Math.min(x1, x2),  Math.min(y1, y2),   Math.min(Math.abs(x1-x2), Math.abs(y1-y2)), Math.min(Math.abs(x1-x2), Math.abs(y1-y2)));
			}	
			if(e.getActionCommand().equals("椭圆")	){

				g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
				
			}
			if(e.getActionCommand().equals("圆弧")	){
				g.drawArc(x1, y1, x2, y2, (x1+y1), (x2+y2));
			}
			if(e.getActionCommand().equals("字符串")	){

				g.drawString("m", x1, y1);
			}
		}
		
	};

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
	}
	public static void main(String[] args) {
		new Test1();
	}
}

