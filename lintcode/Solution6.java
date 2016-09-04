package alg;

// leetcode Search Insert Position
public class Solution6 {
	
	public int searchInsert(int[] nums, int target) {
		int length = nums.length;
        int i=0, j = length-1;
        while(i <= j){
        	int mid =  (i + j) / 2;
        	if(nums[mid] == target) return mid;
        	if(nums[mid] > target) 
        		j = mid - 1;
        	if(nums[mid] < target)
        		i = mid + 1;
        }
        
        int index = 0;
        if(j >= 0) index = j;
        
        if(nums[index] > target){
        	return index==0? 0 : index;
        }
        
        if(nums[index] < target){
        	return index+1;
        }
        
		return 0;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution6 solution6 = new Solution6();
		
		int[] nums1 = {1,3,5,6};
		System.out.println(solution6.searchInsert(nums1, 5));
		
		int[] nums2 = {1,3,5,6};
		System.out.println(solution6.searchInsert(nums2, 2));
		
		int[] nums3 = {1,3,5,6};
		System.out.println(solution6.searchInsert(nums3, 7));
		
		int[] nums4 = {1,3,5,6};
		System.out.println(solution6.searchInsert(nums4, 0));
		
		int[] nums5 = {1,3};
		System.out.println(solution6.searchInsert(nums5, 2));
		
		int[] nums6 = {1,3};
		System.out.println(solution6.searchInsert(nums6, 3));
		
		int[] nums7 = {1, 3, 5};
		System.out.println(solution6.searchInsert(nums7, 4));
	}

}
