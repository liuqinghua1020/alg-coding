package alg;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution16 {
	
	//Flatten Binary Tree to Linked List 
	
	//Time Limit Exceeded 
	
	/* if(root == null) return;
    this.flatten(root.right);
    this.flatten(root.left);
    
    TreeNode tmp = root.right;
    root.right = root.left;
    TreeNode lRight = root;
    while(lRight.right != null){
    	lRight = lRight.right;
    }
    
    lRight.right = tmp;*/
	public void flatten(TreeNode root) {
		 if(root == null) return;
		 Stack<TreeNode> s = new Stack<TreeNode>();
		 TreeNode cur = null;                      //当前结点 
		 TreeNode pre = null;                 //前一次访问的结点 
		 s.push(root);
	     while(!s.empty()){
	        cur=s.peek();
	        if((cur.left==null && cur.right==null)||(pre!=null && (pre==cur.left||pre==cur.right)))
	        {
	            this.adjust(cur);  //如果当前结点没有孩子结点或者孩子节点都已被访问过 
	            s.pop();
	            pre=cur; 
	        }
	        else
	        {
	            if(cur.right!= null)
	                s.push(cur.right);
	            if(cur.left!= null)    
	                s.push(cur.left);
	        }
	    }    
    }
	

	private void adjust(TreeNode cur) {
		TreeNode tmp = cur.right;
		cur.right = cur.left;
	    TreeNode lRight = cur;
	    while(lRight.right != null){
	    	lRight = lRight.right;
	    }
	    
	    lRight.right = tmp;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		
		t1.left = t2;
		t1.right = t5;
		t2.left = t3;
		t2.right = t4;
		t5.right = t6;
		
		Solution16 solution16 = new Solution16();
		solution16.flatten(t1);
		
		TreeNode t = t1;
		while(t != null){
			System.out.println(t.val);
			t = t.right;
		}
	}
	
	
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    
    public String toString(){
    	return val+"";
    }
}
