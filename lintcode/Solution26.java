package alg;
//House Robber II 
public class Solution26 {
    
	public int rob(int[] nums) {
		   if(nums == null || nums.length == 0)  return 0;
	          
	       if(nums.length == 1) return nums[0];
	       if(nums.length == 2) return Math.max(nums[0], nums[1]);
		   return  Math.max(this.myrob(nums, 0, nums.length-2), this.myrob(nums, 1, nums.length-1));
	}
	
	/**
	 * 
	 * @param nums  elements
	 * @param s   start pos
	 * @param e  end pos
	 * @return
	 */
	private int myrob(int[] nums, int s, int e){	          
	          int n = e - s + 1;
	          
	          int[] maxV = new int[n];
	          
	          maxV[0] = nums[s];
	          maxV[1] = Math.max(nums[s], nums[s+1]);
	    	
	    	 for(int i=2; i<n; i++){
	    		   maxV[i] = Math.max(maxV[i-2] + nums[s+i],  maxV[i-1]);
	    	 }
	    	 
	    	 return maxV[n-1];
	}
	public static void main(String[] args) {
		
	}

}
