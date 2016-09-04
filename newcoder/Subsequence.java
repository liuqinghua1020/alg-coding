
public class Subsequence {
	
	 public int shortestSubsequence(int[] A, int n) {
		  //从左往右关注遍历过的最大值比当前值大的最右边的情况
		 int  max = A[0];
		 int rightMin = 0;
		 for(int i=1;i<n;i++){
			 if(max>A[i]){
				 rightMin = i;
			 }else if(A[i] > max){
				 max = A[i];
			 }
		 }
		 
		//从右往左关注遍历过的最小值比当前值小的最左边的情况
		 int min = A[n-1];
		 int leftMax = n-1;
		 for(int i=n-2;i>=0;i--){
			 if(min<A[i]){
				 leftMax = i;
			 }else if(min>A[i]){
				 min = A[i];
			 }
		 }
		 
		 int interval = rightMin - leftMax+1;
		 if(interval < 0) return 0;
		 return interval;
		 
	 }
	 
	public static void main(String[] args) {
		Subsequence sq = new Subsequence();
		int[] A = {1,4,6,5,9,10};
		//int[] A= {1,2,10,1,8,9};
		System.out.println(sq.shortestSubsequence(A, A.length));
	}

}
