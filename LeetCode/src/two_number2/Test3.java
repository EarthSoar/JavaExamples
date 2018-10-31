package two_number2;

import java.util.HashMap;
import java.util.Map;

/**
 *	Two Sum II - Input array is sorted
 *	
 */
class Solution{
//    public int[] twoSum(int[] numbers, int target) {
//    	for(int i = 0;i < numbers.length;i++){
//    		//я╟ур(target - numbers[i])
//    		int t = binarySearch(numbers,i + 1,numbers.length - 1,(target - numbers[i]));
//    		if(t > 0){
//    			return new int[]{i + 1,t + 1};
//    		}
//    	}
//		return null;
//    }
//    public int binarySearch(int []arr ,int low,int high,int key){
//    	while(low <= high){
//    		int mid = (low + high) / 2;
//    		if(arr[mid] < key){
//    			low = mid + 1;
//    		}else if(arr[mid] > key){
//    			high = mid - 1;
//    		}else{
//    			return mid;
//    		}
//    	}
//    	return -1;
//    }
	public int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i);
	    }
	    return result;
	}
    
}
public class Test {
	public static void main(String[] args) {
		int[] arr = {4,2,3,4};
		int[] ret = new Solution().twoSum(arr,8);
		for (int i : ret) {
			System.out.println(i);
		}
	}
}
