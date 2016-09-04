package alg;

public class Solution11 {

	//Gas Station
	//方法是对的，但是 Time Limit Exceeded
	//要转动态规划
	//e.g : Input: [4], [5]  Output:1
	/*public int canCompleteCircuit(int[] gas, int[] cost) {
		int length = gas.length;
		int result = -1; 
		for(int index = 0; index< length; index++){
			int ret = 0;
			int start = index;
			for( ; start<length ; start++){
				ret= ret + gas[start] - cost[start];
				if(ret < 0) break;
			}
			
			result = start;
		}
        return result;
    }*/
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		
		return -1;
    }
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] gas = {1,2,3,4};
		int[] cost = {1,2,3,4};
		
		Solution11 solution11 = new Solution11();
		int result = solution11.canCompleteCircuit(gas, cost);
		System.out.println(result);
	}

}
