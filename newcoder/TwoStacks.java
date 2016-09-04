import java.util.ArrayList;
import java.util.Stack;

public class TwoStacks {
	
	public ArrayList<Integer> twoStacksSort(int[] numbers) {
		 Stack<Integer> stack = new Stack<Integer>();
		 Stack<Integer> tmpStack = new Stack<Integer>();
		 
		 for(int num:numbers){
			  stack.push(num);
		 }
		 
		 while(!stack.empty()){
			  Integer num = stack.pop();
			  if(tmpStack.empty() || tmpStack.peek() < num){
				   tmpStack.push(num);
			  }else{
				  int count=0;
				  while(!tmpStack.empty() && tmpStack.peek() > num){
					   stack.push(tmpStack.pop());
					   count++;
				  }
				  tmpStack.push(num);
				  while(!stack.empty() && count>0){
					   tmpStack.push(stack.pop());
					    count --;
				  }
			  }
		 }
		 
		 ArrayList<Integer> results = new ArrayList<Integer>();
		 while(!tmpStack.empty()){
			  results.add(tmpStack.pop());
		 }
		 
		 return results;
	}

	public static void main(String[] args) {
		TwoStacks ts = new TwoStacks();
		int[] A = {1,5,3,4,2};
		ArrayList<Integer> results = ts.twoStacksSort(A);
		for(Integer num : results){
			System.out.print(" " + num + " ");
		}
	}

}
