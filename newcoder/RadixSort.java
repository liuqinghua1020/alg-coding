import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//基数排序
public class RadixSort {
	
	  public int[] radixSort(int[] A, int n) {
		  
		  Map<Integer, List<Integer>> radix = new HashMap<Integer, List<Integer>>();
		  List<Integer> list = new ArrayList<Integer>();
		  
		  int max = A[0];
		  for(int i=0; i< n; i++){
			    if(max < A[i]){
			    	max = A[i];
			    }
		  }
		  
		  int digit = 0;
		  while(max !=0 ){
			  digit ++;
			   max = max/10;
		  }
		  
		    for(int d=1;d<=digit;d++){
			    for(int i=0; i<n;i++){
			    	     int sig = (int)Math.pow(10, d);
			    	     int preSig = (int)Math.pow(10, d-1);
			    	     
			    	     int  dg = A[i] % sig;
			    	     if(preSig != 1){
			    	    	 int sign = A[i]%preSig;
			    	    	 dg = (dg - sign) / preSig;
			    	     }
			    	     
			    	     List<Integer>  mapValues = radix.get(dg);
			    	     if(mapValues == null){
			    	    	 mapValues = new ArrayList<Integer>(n);
			    	    	 radix.put(dg, mapValues);
			    	     }
			    	     mapValues.add(A[i]);     
			    }
			    
			    for(int i=0; i<=9; i++){
			    	   List<Integer> al = radix.get(i);
			    	   if(al != null){
				    	   for(Integer a:al){
				    		      list.add(a);
				    	   }
				    	   al.clear();
			    	   }
			    }
			    
			    for(int i=0; i<n;i++){
			    	  A[i] = list.get(i);
			    }
			    list.clear();
		  }
		  return A;
	  }

	public static void main(String[] args) {
		int [] a = {1,22,999,12,56};
		//int [] a = {22,12};
		RadixSort cst = new RadixSort();
		int[] b = cst.radixSort(a, a.length);
		for(int c:b){
			System.out.print(" " + c + " ");
		}
	}

}
