
public class CalcSortTest {
	
	public int[] countingSort(int[] A, int n) {
		int[] B = new int[n];
		
		int max = A[0];
		for(int i=0; i< n; i++){
			if(max<A[i]){
				max = A[i];
			}
		}
		
		int[] C = new int[max+1];
		
		for(int i=0; i< max+1; i++){
			 C[i] = 0;
		}
		
		for(int i=0; i< n; i++){
			  C[A[i]] ++;
		}
		
		for(int i=0; i< max;i++ ){
			  C[i+1] = C[i+1] + C[i];
		}
		
		
	    for(int i=0; i<n;i++){
	    	  B[C[A[i]]-1] = A[i];
	    	  C[A[i]] --;
	    }
	    
		return B;
	}
	public static void main(String[] args) {
			int [] a = {2,2,3,3,1};
			
			CalcSortTest cst = new CalcSortTest();
			int[] b = cst.countingSort(a, a.length);
			for(int c:b){
				System.out.print(" " + c + " ");
			}
	}

}
