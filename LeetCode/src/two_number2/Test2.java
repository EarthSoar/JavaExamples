package two_number2;

class Solution1{
    public int[] twoSum(int[] numbers, int target) {
    	int low = 0;
    	int high = numbers.length - 1;
    	while(numbers[low] + numbers[high] != target){
    		if((numbers[low] + numbers[high]) > target){
    			high--;
    		}else{
    			low++;
    		}
    	}
		return new int[]{low + 1,high + 1};
    }
}
public class Test2 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,4,9,56,90};
		int[] ret = new Solution1().twoSum(arr,91);
		for (int i : ret) {
			System.out.println(i);
		}
	}
}
