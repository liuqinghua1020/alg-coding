package alg;

import java.util.ArrayList;
import java.util.List;

//Binary Tree Zigzag Level Order Traversal
public class Solution18 {
	
	/**
	 * 思路：树的层次遍历
	 * @param root
	 * @return
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(root == null) return results;
		
		 
		 List<Integer> result = new ArrayList<Integer>();
		 
		  List<TreeNode> queue = new ArrayList<TreeNode>();
		  int head = 0;
		  int index=head;
		  boolean left2Right = true;
		  int level = 0; // 如果 head==level,表明这一层的节点已经访问完
		  int  tail = 0;
		  queue.add(root);
		  while(!queue.isEmpty()){
			  if(head <= tail){
					  
					   TreeNode node = queue.get(index);
					   index ++;
					   
					   if(node.left != null){
						    queue.add(node.left);
						    tail ++;
					   }
					   if(node.right != null){
						   queue.add(node.right);
						   tail ++;
					   }
		
					   if(index-1 == level){ //表明遍历完一个层次的数值了，可以将其放到最终的结果中了，并重新设置下一个层次数组
						   //取从head开始到level的数值
						   result = this.getData(queue, head, level, left2Right);
						   
						   results.add(result);
						   
						   result = new ArrayList<Integer>();
						   
						   left2Right = !left2Right;
						   
						   this.removePreEle(queue, level);
						   head = 0;
						   tail = tail - level-1;
						   level = tail;
						   index = head;
					   }
			  }
		  }
          return results; 
    }

	private void removePreEle(List<TreeNode> queue, int level) {
		      int i = 0;
		      while(i<=level){
		    	     queue.remove(0);
		    	     i++;
		      }
	}

	private List<Integer> getData(List<TreeNode> queue, int head, int level, boolean left2Right) {
		      List<Integer> result = new ArrayList<Integer>();
		      if(left2Right){
		    	  	for(int i=head; i<=level;i++){
		    	  		    TreeNode node = queue.get(i);
		    	  		    Integer value = node.val;
		    	  		    result.add(value);
		    	  	}
		      }else{
		    	   for(int i=level; i>=head;i--){
		    		     TreeNode node = queue.get(i);
		    		     Integer  value = node.val;
		    		     result.add(value);
		    	   }
		      }
		      
		      return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			Solution18 solution18 = new Solution18();
			
		/*	TreeNode n1 = new TreeNode(3);
			TreeNode n2 = new TreeNode(9);
			TreeNode n3 = new TreeNode(20);
			TreeNode n4 = new TreeNode(1);
			TreeNode n5 = new TreeNode(2);
			TreeNode n6 = new TreeNode(15);
			TreeNode n7 = new TreeNode(7);
			
			n1.left = n2;
			n1.right = n3;
			
			n2.left = n4;
			n2.right=n5;
			
			n3.left = n6;
			n3.right = n7;*/
			
			TreeNode n1 = new TreeNode(1);
			TreeNode n2 = new TreeNode(2);
			TreeNode n3 = new TreeNode(3);
			
			n1.right = n2;
			n2.left = n3;
			
			List<List<Integer>> results = solution18.zigzagLevelOrder(n1);
			
			for(List<Integer> result:results){
				for(Integer val:result){
					System.out.print(" " + val + " ");
				}
				System.out.println();
			}
	}
	
}

 