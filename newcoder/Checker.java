
public class Checker {

	public static void main(String[] args) {
		 //int[] array = {1,2,3,4,5,5,6};
		 int[] array = {1,2,3,4,5,6};
		 Checker checker = new Checker();
		 System.out.println(checker.checkDuplicate(array, array.length));
	}
	
	 public boolean checkDuplicate(int[] a, int n) {
		   a = heapSort(a, n);
		   for(int i=0; i<n-1; i++){
			    if(a[i] == a[i+1]){
			    	  return true;
			    }
		   }
		   return false;
	 }
	 
	 public int[] heapSort(int[] A, int n) {
	        // write code here
	        for(int i=n/2; i>=0; i--){
	            heapAdjust(A,i,n);
	        }
	         
	        for(int i=n-1;i>0;i--){
	            swap(A,0,i);
	            heapAdjust(A,0,i);
	        }
	        return A;
	    }
	     
	    void heapAdjust(int[] A,int index,int length){
	        int childLeft;
	        int temp = A[index];
	        for( ;index*2+1 < length;index = childLeft){
	            childLeft = index*2+1;
	            if(childLeft !=length-1 && A[childLeft] < A[childLeft+1]){
	                 childLeft++;
	            }
	            if(temp > A[childLeft]){
	                break;
	                 
	            }               
	            else {
	                A[index] = A[childLeft];
	                index = childLeft;
	            }          
	        }
	         A[index] = temp;
	         
	    }
	     
	    void  swap(int[] A,int m,int n){
	        int temp = A[m];
	        A[m] = A[n];
	        A[n] = temp;
	    }
}
