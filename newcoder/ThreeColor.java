
public class ThreeColor {
	
	/**
	 *  找到 第一个中间元素即可
	 * @param A
	 * @param n
	 * @return
	 */
	public int[] sortThreeColor(int[] A, int n) {
		  int min = A[0];
		  int max = A[0];
		  int middle = 0;
		  
		  
		  for(int i=1; i<n; i++){
			   if(min > A[i]){
				    min = A[i];
			   }
			   if(max<A[i]){
				   max = A[i];
			   }
		  }
		  
		  this.partition(A, n,min, max);
		  
		  return A;
	}
	
	private void partition(int[] A, int length, int min, int max){
		    int z0 = -1;
		    int z1 = length;
		    
		    for(int i=0; i<z1;){
		    	if(A[i]==min){
		    		  this.swap(A, ++z0,  i++);
		    	}else if(A[i] == max){
		    		this.swap(A, i, --z1);
		    	}else{
		    		i++;
		    	}
		    }
			return;
	}
	
	private void swap(int[] A, int left, int right){
		  int tmp = A[left];
		  A[left] = A[right];
		  A[right] = tmp;
	}
	
	
	public static void main(String[] args) {
		ThreeColor tc = new ThreeColor();
		//int[] A = {0,1,1,0,2,2};
		//int[] A = {1,2,0,2};
		int[] A = {2,2,0,1,0,1,1,1};
		int[] B = tc.sortThreeColor(A,A.length);
		for(int b:B){
			System.out.print(" " + b + " ");
		}
	}

}
