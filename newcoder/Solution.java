import java.util.Stack;

public class Solution {
	
	public Stack<Integer> elements = new Stack<Integer>();
	public Stack<Integer> minElements = new Stack<Integer>();

    public void push(int node) {
        elements.push(node);
        if(minElements.size() == 0){
        	minElements.push(node);
        }else{
        	int topMin = minElements.peek();
        	if(topMin < node){
        		minElements.push(topMin);
        	}else{
        		minElements.push(node);
        	}
        }
    }
    
    public void pop() {
         if(elements.size() == 0){
        	 return;
         }else{
        	  elements.pop();
        	  minElements.pop();
         }
    }
    
    public int top() {
         return elements.peek();
    }
    
    public int min() {
    	return minElements.peek();
    }

	public static void main(String[] args) {
		System.out.println(1<-1);
	}

}
