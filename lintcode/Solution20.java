package alg;

import java.util.HashMap;
import java.util.Map;

//Two Sum
public class Solution20 {
     
    public int[] twoSum(int[] nums, int target) {
    	  int[] result = new int[2];
    	  
    	  Map<Integer, Integer> reIndex = new HashMap<Integer, Integer>();
    	  for(int i=0; i<nums.length;i++){
    		    reIndex.put(nums[i], i);
    	  }
    	  
    	  for(int i=0; i<nums.length; i++){
    		   int rest = target - nums[i];
    		   Integer restIndex = -1;
    		   if((restIndex = reIndex.get(rest)) != null  && i != restIndex){
    			      result[0] = i+1;
    			      result[1] = restIndex.intValue()+1;
    			      break;
    		   }
    	  }
          return result;
    }
	public static void main(String[] args) {
		Solution20 solution20 = new Solution20();
		int[] array = {3,2,4};
		int target = 6;
		int[] result = solution20.twoSum(array, target);
		
		System.out.println(result[0]  + "   " + result[1]);
	}

}
