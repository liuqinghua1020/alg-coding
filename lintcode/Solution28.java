package alg;

//First Missing Positive
public class Solution28 {
	public int firstMissingPositive(int A[]) { 
		if(A == null || A.length == 0){
			return 1;
		}
		int pos = 0;
		int n = A.length;
 
		while(pos < n){
			if(A[pos] > 0 && A[pos] < n && A[pos] != A[A[pos]-1] && A[pos]-1 >= 0){
				 this.swap(A, pos, A[pos]-1);
			}else{
				pos++;
			}
		}
		
		int i = 0;
		for(; i<n; i++){
			if(A[i]-1 != i){
				return i+1;
			}
		}
		
		return  i+1;
	}

	private void swap(int[] A, int a, int b){
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  Solution28 solution = new Solution28();
		  
		  int[] A1 = {1,2,0};
		  System.out.println(solution.firstMissingPositive(A1));
		  
		  
		  int[] A2 = {3,4,-1,1};
		  System.out.println(solution.firstMissingPositive(A2));
		  
		  int[] A3 = {1};
		  System.out.println(solution.firstMissingPositive(A3));
		  
		  int[] A4 = {-1,4,2,1,9,10};
		  System.out.println(solution.firstMissingPositive(A4));
		  
	}
}
