import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwoStack {
	
	 public int[] twoStack(int[] ope, int n) {
		 Stack<Integer> pushStack = new Stack<Integer>();
		 Stack<Integer> popStack = new Stack<Integer>();
		 
		 List<Integer> result = new ArrayList<Integer>();
		 
		 for(int i=0;i<n;i++){
			  int ele = ope[i];
			  if(ele > 0){
				   this.push(ele, pushStack, popStack);
			  }else if(ele == 0){
				  Integer re = this.pop(pushStack, popStack);
				  result.add(re);
			  }
		 }
		 
		 int[] res = new int[result.size()];
		 for(int i=0; i<result.size();i++){
			 res[i] = result.get(i);
		 }
		 return res;
	  }
	 
	 private void push(int ele, Stack<Integer> pushStack, Stack<Integer> popStack){
		   if(pushStack.empty() && !popStack.empty()){
			      while(!popStack.empty()){
			    	   pushStack.push(popStack.pop());
			      }
		   }
		   
		   pushStack.push(ele);
	 }
	 
	 private Integer pop(Stack<Integer> pushStack, Stack<Integer> popStack){
		 if(popStack.empty() && !pushStack.empty()){
		      while(!pushStack.empty()){
		    	  popStack.push(pushStack.pop());
		      }
	    }
		return popStack.pop();
	 }

	public static void main(String[] args) {
		int[] array = {1,2,3,0,4,0};
		
		TwoStack ts = new TwoStack();
		int[] result = ts.twoStack(array,array.length);
		for(int i:result){
			System.out.print(" " + i + " ");
		}
	}

}
