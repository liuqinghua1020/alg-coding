import java.util.ArrayList;

public class SlideWindow {
	/**
	 * 主要是维护一个双向队列，从队头可以取出最大的值的下标，从队尾插入小于最大值的下标
	 * @param arr
	 * @param n
	 * @param w
	 * @return
	 */
	public int[] slide(int[] arr, int n, int w) {
		
		int count=1;
		ArrayList<Integer>  queue = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i<n;i++){
			int num = arr[i];
			if(queue.isEmpty()){
				 queue.add(i);
			}else{
				while(!queue.isEmpty() && arr[queue.get(queue.size()-1)] < num ){
					 queue.remove(queue.size()-1);
				}
				queue.add(i);
			}
			if(i >= w-1){
				  int start = i - w + 1;
				  while(queue.get(0) < start){
					   queue.remove(0);
				  }
				  result.add(queue.get(0));
			}
			
		}
		
		int[] r = new int[result.size()];
		for(int i=0;i<result.size();i++){
			r[i] = arr[result.get(i)];
		}
		
		return r;
	}
	
	public static void main(String[] args) {
		SlideWindow sw = new SlideWindow();
		int[] A = {4,3,5,4,3,3,6,7};
		int n = A.length;
		int w = 3;
		int[] result = sw.slide(A, n, w);
		for(int r:result){
			System.out.print(" " + r + " ");
		}
	}

}
