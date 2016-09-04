package alg;

public class Solution4 {
	
	public String largestNumber(int[] nums) {
        
         
         int zeroCount = 0;
         for(int num : nums){
        	 if(num == 0) zeroCount ++;
         }
         if(zeroCount == nums.length){
        	 return "0";
         }
         
         StringBuffer sb = new StringBuffer();
         int length = nums.length;
         int arrLength = length;
         for(int i=0; i < length; i++){
        	 int max = 0; //每次找当前数组中最大的数值
        	 
        	 for(int j=0; j < arrLength; j++){
        		 if(this.compare2Num(nums[j], nums[max]) > 0){
        			 max = j;
        		 }
        	 }
        	 
        	 if(max != arrLength - 1){
	        	 int tmp = nums[arrLength - 1];
	        	 nums[arrLength - 1] = nums[max];
	        	 nums[max] = tmp;
        	 }
        	 
        	 sb.append(nums[arrLength - 1] + "");
        	 arrLength --;
         }
 
        
		 return sb.toString();
    }
	
	private int compare2Num(int num1, int num2){
		String str1 = num1 + "" + num2;
		String str2 = num2 + "" + num1;
		
		for(int i=0; i<str1.length(); i++){
			if(str1.charAt(i) > str2.charAt(i)) return 1;
			if(str1.charAt(i) < str2.charAt(i)) return -1;
		}
		
		return 0;
	}
	
	/*//找到这种规则下比较方法
	private int compare2Num(int num1, int num2){
		
		char[] str1 = String.valueOf(num1).toCharArray();
		char[] str2 = String.valueOf(num2).toCharArray();
		int i = 0;
		for(; i<str1.length && i<str2.length; i++){
			if(str1[i] > str2[i]) return 1;
			if(str1[i] < str2[i]) return -1;
		}
		
		int head = 0;
		while(i < str1.length){
			if(str1[head] > str1[i]) return -1;
			else if(str1[head] < str1[i]) return 1;
			i++;
			head ++;
		}
		
		while(i < str2.length ){
			if(str2[head] > str2[i]) return 1;
			else if(str2[head] < str2[i]) return -1;
			i++;
		}
		
		return 0;
	}*/

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution4 solution4 = new Solution4();
		
		/*int num1 = 9;
		int num2 = 5;
		int num3 = 45;
		int num4 = 4;
		int num5 = 43;
		int num6 = 446;
		int num7 = 442;
		int num8 = 44;
		
		System.out.println(solution4.compare2Num(num1, num2));
		System.out.println(solution4.compare2Num(num2, num3));
		System.out.println(solution4.compare2Num(num4, num3));
		System.out.println(solution4.compare2Num(num4, num5));
		System.out.println(solution4.compare2Num(num4, num6));
		System.out.println(solution4.compare2Num(num4, num7));
		System.out.println(solution4.compare2Num(num7, num8));*/
		
		/*int num1 = 824;
		int num2 = 8249;
		System.out.println(solution4.compare2Num(num1, num2));*/
		
		
		/*int[] nums = {3, 30, 34, 5, 9};
		String word = solution4.largestNumber(nums);
		System.out.println(word);
		
		int[] nums2 = {0,0,0};
		String word2 = solution4.largestNumber(nums2);
		System.out.println(word2);
		*/
		int[] nums3 = {121,12};
		String word3 = solution4.largestNumber(nums3);
		System.out.println(word3);
	}

}
