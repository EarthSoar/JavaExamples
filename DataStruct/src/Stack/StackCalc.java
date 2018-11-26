package Stack;

import java.io.FileInputStream;
import java.util.Scanner;


/**
 * @author 15626 用栈计算算数表达式的值 将符号和操作数分别存放压入两个栈中.
 */
public class StackCalc {
	public static void main(String[] args) throws Exception {
		MyStack2<String> ops = new MyStack2<String>();
		MyStack2<Double> vals = new MyStack2<Double>();

		Scanner sc = new Scanner(new FileInputStream("file/1.txt"));
		while (sc.hasNext()){
			//String s = StdIn.readString();
			String s = sc.next();
			if (s.equals("(")) {
				;
			} else if (s.equals("+")) {
				ops.push(s);
			} else if (s.equals("-")) {
				ops.push(s);
			} else if (s.equals("*")) {
				ops.push(s);
			} else if (s.equals("/")) {
				ops.push(s);
			} else if (s.equals("sqrt")) {
				ops.push(s);
			} else if (s.equals(")")) {
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+")) {
					v = vals.pop() + v;
				} else if (op.equals("-")) {
					v = vals.pop() - v;
				} else if (op.equals("*")) {
					v = vals.pop() * v;
				} else if (op.equals("/")) {
					v = vals.pop() / v;
				} else if (op.equals("sqrt")) {
					v = Math.sqrt(v);
				} 
				vals.push(v);
			} else {
				vals.push(Double.parseDouble(s));
			}
		}
		System.out.println(vals.pop());
		sc.close();
	}
}
