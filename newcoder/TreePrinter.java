import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuqinghua
 *
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class TreePrinter {
	
	/**
	 * 层次遍历
	 * @param root
	 * @return
	 */
	 public int[][] printTree(TreeNode root) {
		 List<TreeNode> list = new ArrayList<TreeNode>();
		 if(root == null){
			 return null;
		 }
		 
		 list.add(root);
		 int tail = 0;
		 List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		 List<Integer> levelResult = new ArrayList<Integer>();
		 while(!list.isEmpty()){
			  TreeNode node = list.remove(0);
			  levelResult.add(node.val);
			  tail --;
			  if(node.left != null){
				  list.add(node.left);
			  }
			  if(node.right != null){
				  list.add(node.right);
			  }
			  
			  if(tail == -1){ //一层结束
				  resultList.add(levelResult);
				  levelResult = new ArrayList<Integer>(); 
				  tail = list.size() - 1;
			  }
		 }
		 
		 int[][] result = new int[resultList.size()][];
		 int level = 0;
		 for(List<Integer> l:resultList){
			   result[level] = new int[l.size()];
			   for(int i=0;i<l.size();i++){
				     int val = l.get(i);
				     result[level][i] = val;
			   }
			   level ++;
		 }
		 return result;
	  }

	public static void main(String[] args) {
		TreeNode tn0 = new TreeNode(0);
		TreeNode tn1 = new TreeNode(1);
		TreeNode tn2 = new TreeNode(2);
		TreeNode tn3 = new TreeNode(3);
		TreeNode tn4 = new TreeNode(4);
		TreeNode tn5 = new TreeNode(5);
		TreeNode tn6 = new TreeNode(6);
		
		tn0.left = tn1;
		tn0.right = tn2;
		tn1.left = tn3;
		tn1.right = tn4;
		tn2.left = tn5;
		//tn2.right = tn6;
		
		TreePrinter tp = new TreePrinter();
		int[][] result = tp.printTree(tn0);
		for(int i =0; i<result.length; i++){
			 for(int j=0; j<result[i].length; j++){
				  System.out.print(" " + result[i][j] + " ");
			 }
			 System.out.println("");
		}
	}

}
