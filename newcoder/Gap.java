
public class Gap {
	public int maxGap(int[] A, int n) {
        // write code here
		
		//1.一次遍历找到最大值和最小值
		int max = A[0];
		int min = A[0];
		for(int i=1;i<n;i++){
			if(A[i]>max){
				max = A[i];
			}
			if(A[i]<min){
				min = A[i];
			}
		}
		
		if(min == max) return 0;
		
		boolean[] hasNum =new boolean[n+1];
		int[]maxs=new int[n+1];
        int[] mins=new int[n+1];
        for(int i=0;i<n;i++){
            int bid=bucket(A[i],n,min,max);//计算每一个数值 看其归于那一个桶
            //将桶中的最大值和当前要插入的值比较，看其可以取代最大值还是最小值
            maxs[bid]=hasNum[bid]?Math.max(maxs[bid],A[i]):A[i];
            mins[bid]=hasNum[bid]?Math.min(mins[bid],A[i]):A[i];
            hasNum[bid]=true;
        }
        
        int res=0;
        int lastMax=0;
        int i=0;
        while(i<=n){
            if(hasNum[i++]){
                lastMax = maxs[i-1];
                break;
            }
        }
        for(;i<=n;i++){
            if(hasNum[i]){
                res=Math.max(res,mins[i]-lastMax);
                lastMax=maxs[i];
            }
        }
        return res;
    }
	
	/**
	 * 针对每一个数值，计算出它会归于那一个桶
	 * @param num
	 * @param length
	 * @param min
	 * @param max
	 * @return
	 */
	 public int bucket(long num,long length,long min,long max){
	        return (int)((num-min)*length/(max-min));
	    }
	public static void main(String[] args) {
		
	}

}
