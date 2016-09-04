/**
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。(注意：子树必须是到达叶子节点的)
 * @author liuqinghua
 *
 */
public class IdenticalTree {
	/**
	 * 以A的每一个节点为根节点，判断是否同构于B
	 * @param A
	 * @param B
	 * @return
	 */
	public boolean chkIdentical(TreeNode A, TreeNode B) {
		if(A == null) return false;
		boolean result1 = isChkIdentical(A, B);
		
		boolean result2 = false, result3=false;
		if(A.left != null){
			result2 = this.chkIdentical(A.left, B);
		}
		
		if(A.right != null){
			result3 = this.chkIdentical(A.right, B);
		}
		return result1 ||result2 || result3 ;
	}
	
	
	public boolean isChkIdentical(TreeNode A, TreeNode B){
		if(A== null && B == null) return true;
		if(A == null && B != null) return false;
		if(A != null && B == null) return false;
		if(A.val != B.val) return false;
		
		boolean result1 = isChkIdentical(A.left, B.left);
		boolean result2 = isChkIdentical(A.right, B.right);
		
		return result1 && result2;
	}
	
	public static void main(String[] args){
		
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(5);
		TreeNode a6 = new TreeNode(6);
		TreeNode a7 = new TreeNode(7);
		
		a1.left = a2;
		a1.right = a3;
		a2.left = a4;
		a2.right = a5;
		a3.left = a6;
		a3.right = a7;
		
		TreeNode b1 = new TreeNode(7);
		TreeNode b2 = new TreeNode(6);
		TreeNode b3 = new TreeNode(7);
		
		
	/*	b1.left = b2;
		b1.right = b3;*/
		
		
		
		IdenticalTree it = new IdenticalTree();
		System.out.println(it.chkIdentical(a1, b1));
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
