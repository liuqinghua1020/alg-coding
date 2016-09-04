import java.util.Stack;

public class StackReverse {
	
	public int[] reverseStack(int[] A, int n) {
		 Stack<Integer> stack = new Stack<Integer>();
		 for(int i:A){
			  stack.push(i);
		 }
		 if(!stack.empty()){
			 int[] result = new int[n];
			 
			 reverse(stack, result, n, 0);
			 
			 return result;
		 }
		 
		 return null;
	}
	
	public void reverse(Stack<Integer> stack, int[] result, int  n, int i){
		   if(i >= n){
			    return;
		   }else{
			   reverse(stack, result, n, i+1);
			   result[n-1-i] = stack.pop();
		   }
		   return;
	}
	

	public static void main(String[] args) {
		 int[] A = {4,3,2,1};
		 
		 StackReverse sr = new StackReverse();
		 int[] result = sr.reverseStack(A, A.length);
		 for(int i:result){
			 System.out.print(" " + i + " ");
		 }
	}

}
