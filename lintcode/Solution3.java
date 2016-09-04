package alg;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//367 表达树构造
public class Solution3 {
	class ExpressionTreeNode {
	      public String symbol;
	      public ExpressionTreeNode left, right;
	      public ExpressionTreeNode(String symbol) {
	          this.symbol = symbol;
	         this.left = this.right = null;
	      }
    }
	
	private Map<String, Integer> operator = new HashMap<String, Integer>();
    {
    	operator.put("(", 0);
    	operator.put("+", 1);
    	operator.put("-", 1);
    	operator.put("*", 2);
    	operator.put("/", 2);
    }
	
	/**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        Stack<ExpressionTreeNode> stack1 = new Stack<ExpressionTreeNode>(); //数字栈
        Stack<String> stack2 = new Stack<String>(); //符号栈
        
        for(String expr : expression){
        	if(this.isNum(expr)){
        		//数字，直接创建节点，插入stack1中 
        		ExpressionTreeNode node = new ExpressionTreeNode(expr);
        		stack1.push(node);
        		
        	}else if("(".equals(expr)){ //剩下就只有左右括号的是事情了
        		
        		stack2.push(expr);
        		
        		
        	}else if(")".equals(expr)){//弹出所有{之后的符号
        		
        		String opr = null;
        		while((opr = stack2.pop()) != "("){
        			
        			ExpressionTreeNode right = stack1.pop();
    				ExpressionTreeNode left = stack1.pop();
    				
    				ExpressionTreeNode node = new ExpressionTreeNode(opr);
    				node.left = left;
    				node.right = right;
    				
    				stack1.push(node);
        			
        		}

        	}else if(this.isOperator(expr)){ 
        		//符号的话
        		if(stack2.isEmpty()){
        			stack2.push(expr);
        		}else{
        			String expr2 = stack2.peek();
        			
        			if(!"(".equals(expr2)){
	        			//System.out.println(expr);
	        			//System.out.println(expr2);
	        			Integer lev1 = operator.get(expr);
	        			Integer lev2 = operator.get(expr2);
	        			if(lev1 <= lev2){
	        				ExpressionTreeNode node = new ExpressionTreeNode(expr2);
	        				
	        				ExpressionTreeNode right = stack1.pop();
	        				ExpressionTreeNode left = stack1.pop();
	        				
	        				node.left = left;
	        				node.right = right;
	        				
	        				stack1.push(node);
	        				stack2.pop();
	        			}
        			}
        			
        			stack2.push(expr);
        			
        			
        		}
        		
        		
        	}
        }
        
        //遍历完之后 符号栈中应该还有 符号，接着完成即可
        while(!stack2.isEmpty()){
        	String opr = stack2.pop();
        	
        	ExpressionTreeNode right = stack1.pop();
			ExpressionTreeNode left = stack1.pop();
			
			ExpressionTreeNode node = new ExpressionTreeNode(opr);
			node.left = left;
			node.right = right;
			
			stack1.push(node);
        }
        
    	
    	return stack1.peek();
    }
    
    public boolean isNum(String str){ //是否数字
       Pattern pattern = Pattern.compile("-{0,1}[0-9]+"); 
	   Matcher isNum = pattern.matcher(str);
	   if( !isNum.matches() ){
	       return false; 
	   } 
	   return true; 
    }
    
    
    private boolean isOperator(String str){//是否运算符
          Integer flag = null;
          flag = operator.get(str);
          return flag!=null;
     } 
    
    public void itNode(ExpressionTreeNode root){
    	if(root == null ) return;
    	System.out.print(" " +  root.symbol + " ");
    	this.itNode(root.left);
    	this.itNode(root.right);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution3 solution3 = new Solution3();
		/*String a = "-";
		System.out.println(solution6.isNum(a));*/
		
		String[]  expressions = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
		ExpressionTreeNode root = solution3.build(expressions);
		//solution3.itNode(root);
		System.out.println(root.symbol);
	}
}

