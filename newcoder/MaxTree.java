import java.util.*;

public class MaxTree {
	/**
	 * 官方参考方法： 利用stack 保存以前的记录，其实 它在一次遍历中 既 搞定了 A[i] 为某一个j(0<j<i)的右侧第一个最大值（且比左边小的情况，
	 * 又定义了 A[i] 的左边的最大值(右边的情况等遍历到 一个大于i的下标的时候计算)）
	 * public int[] buildMaxTree(int[] A, int n) {
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[i] = -1;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<n; i++){
            while(!stack.empty() && A[stack.peek()]<A[i]){
                if(res[stack.peek()] == -1 || A[res[stack.peek()]] > A[i]){
                    res[stack.peek()] = i;
                }
                stack.pop();
            }
            if(!stack.empty()){
                res[i] = stack.peek();
            }
            stack.push(i);  
        }
        return res;
    }
	 * @param A
	 * @param n
	 * @return
	 */
    public int[] buildMaxTree(int[] A, int n) {
    	//left[i]表示A[i]左边第一个比之大的数字的下标
    	int[] left = new int[n];
    	//right[i]表示A[i]右边第一个比之大的数字的下标
    	int[] right = new int[n];
    	
    	Arrays.fill(left, -1);
    	Arrays.fill(right, -1);
    	
    	for(int i=0;i<n;i++){
    		int lmax = i;
    		int rmax = i;
    		for(int j=i;j>=0;j--){
    			if(A[j] > A[i] && A[j] > A[lmax]){
    				 lmax = j;
    				 break;
    			}
    		}
    		for(int j=i;j<n;j++){
    			if(A[j] > A[i] && A[j] > A[rmax]){
    				rmax = j;
    				break;
    			}
    		}
    		
    		if(lmax != i){
    			left[i] = lmax;
    		}
    		
    		if(rmax != i){
    			right[i] = rmax;
    		}
    	}
    	
    	
    	
    	int[] pre = new int[n]; //指向A[i]的父节点
    	Arrays.fill(pre, -1);
    	for(int i=0;i<n;i++){
    		
    		if(left[i] == -1 && right[i] == -1){
    			continue;
    		}
    		
    		if(left[i] == -1){
    			pre[i] = right[i];
    			continue;
    		}
    		
    		if(right[i] == -1){
    			pre[i] = left[i];
    			continue;
    		}
    		
    		if(A[left[i]] > A[right[i]]){
    			pre[i] = right[i];
    		}else{
    			pre[i] = left[i];
    		}
    	}
    	
    	return pre;
    }
    
    public static void main(String[] args){
    	MaxTree mt = new MaxTree();
    	int[] A = {3,1,4,2};
    	int[] result = mt.buildMaxTree(A, A.length);
    	for(int re:result){
    		System.out.print(" " + re + " ");
    	}
    }
}
