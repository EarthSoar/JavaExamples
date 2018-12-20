package linkedlist;

import java.util.Arrays;

/**
 * Given a string S and a character C, return an array of integers representing
 * the shortest distance from the character C in the string.
 * 
 *	Input: S = "loveleetcode", C = 'e'
 *	Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
public class Ex821 {
	static class Solution {
	    public int[] shortestToChar(String S, char C) {
	    	int length = S.length();
	    	int[] res = new int[length];
	    	int cur = Integer.MIN_VALUE / 2;
	    	//从左往右遍历,找距离左边的目标字符的距离
	    	for(int i = 0; i < length; i++) {
	    		if(C == S.charAt(i)) {
	    			cur = i;
	    		}
	    		res[i] = i - cur;
	    	}
	    	cur = Integer.MAX_VALUE / 2;
	    	//从右往左遍历,找出距离右边目标字符的距离,和左边距离比较得出最小的距离
	    	for(int i = length - 1; i >= 0; i--) {
	    		if(C == S.charAt(i)) {
	    			cur = i;
	    		}
	    		res[i] = Math.min(res[i], cur - i);
	    	}
			return res;
	    }
	}
	public static void main(String[] args) {
		int[] res = new Solution().shortestToChar("loveleetcode", 'e');
		System.out.println(Arrays.toString(res));
	}
}
