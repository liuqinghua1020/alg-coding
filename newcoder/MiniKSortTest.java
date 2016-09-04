/**
 * 建立大小为K的小顶堆，减除最小元素后，压入下一个元素
 * @author shinelon
 *
 */
public class MiniKSortTest {
	
	public static void main(String[] args){
		MiniKSortTest mst = new MiniKSortTest();
		
		 int[] array = {2,1,4,3,6,5,8,7,10,9};
		// int[] array = {2,1,4,3};
		 int n = array.length;
		 int k = 3;
		 
		 int[] A = mst.sortElement(array, n ,k);
		 for(int a:A){
			 System.out.print(" " + a + " ");
		 }
	}
	
	public int[] sortElement(int[] A, int n, int k) {
		int numCount = k;
		for(int i=0;i<n;i++){
			if(n-i < k){
				numCount = n-i;
			}
			heapSort(A, i, numCount);
		}
		return A;
    }
	
	/**
	 * @param A
	 * @param index  index 表示起始元素索引号（包含）
	 * @param n 表示最后的元素索引号+1
	 */
	 public void heapSort(int[] A, int index, int n) {
	        for(int i=n/2; i>=0; i--){
	            heapAdjust(A,i,n, index);
	        }
	    }
	    
	  /**
	   * 
	   * @param A
	   * @param index 基本初始从零开始
	   * @param length
	   * @param internal
	   */
	    void heapAdjust(int[] A,int index,int length, int internal){
	        int childLeft;
	        int temp =  this.getEleInArray(A, index, internal);
	        for( ;index*2+1 < length;index = childLeft){
	            childLeft = index*2+1;
	            if(childLeft <length-1 && this.getEleInArray(A, childLeft, internal) > this.getEleInArray(A, childLeft+1, internal)){
	                 childLeft++;
	            }
	            if(temp < this.getEleInArray(A, childLeft, internal)){
	                break;
	                 
	            }               
	            else {
	                this.setEleInArray(A, index, internal,  this.getEleInArray(A, childLeft, internal));
	                index = childLeft;
	            }          
	        }
	         this.setEleInArray(A, index, internal,  temp);
	    }
	     
		  public int getEleInArray(int[] A, int index, int internal){
			  int realIndex = index + internal;
			   if(realIndex < 0 || realIndex >= A.length ){
				      return Integer.MIN_VALUE;
			   }
			   return A[realIndex];
		  }
		  
		  public void setEleInArray(int[] A, int index, int internal, int value){
			  int realIndex = index + internal;
			   if(realIndex < 0 || realIndex >= A.length ){
				     return;
			   }
			    A[realIndex] = value;
		  }
		  
	    void  swap(int[] A,int m,int n){
	        int temp = A[m];
	        A[m] = A[n];
	        A[n] = temp;
	    }
}
