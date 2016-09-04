import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
此方法证明是错误的，但是具备一定参考价值
 * @author liuqinghua
 *
 */
public class IdenticalTree2 {
	
	 public boolean chkIdentical(TreeNode A, TreeNode B) {
		 //分成两步，1.序列化二叉树（同做先序排列） 2.第二个是否未第一个的子序列
		 List<Integer> a = new ArrayList<Integer>();
		 List<Integer> b = new ArrayList<Integer>();
		 
		 //序列化二叉树（同做先序排列）
		 this.serialize(A, a);
		 this.serialize(B, b);
		 
		 //2.第二个是否未第一个的子序列
		 boolean result = this.isSub(b, a);
		 
		 return result;
	    }
	 
	public void serialize(TreeNode a, List<Integer> list) {
		if(a == null) return;
		list.add(a.val);
		this.serialize(a.left, list);
		this.serialize(a.right, list);
	}
	
	public boolean isSub(List<Integer> b, List<Integer> a) {
		 if(b.size() > a.size()) return false;
		 int j=0;
		 int m = -1;
		 int n = -1;
		 for(int i=0;i<a.size();i++){
			  int k= i;
			  for(; j<b.size();){
				    m = a.get(k);
				    n = b.get(j);
				    if(m == n){
				    	 k++;
				    	 j++;
				    }else{
				    	j = 0;
				    	break;
				    }
			  }
		 }
		 
		 if(j != b.size()){
			  return false;
		 }
		 return true;
	}

	public static void main(String[] args) {
		IdenticalTree2 it = new IdenticalTree2();
		List<Integer> a = Arrays.asList(1,2, 3,4,5,6,7,8,9);
		List<Integer> b = Arrays.asList(5,6,8);
		System.out.println(it.isSub(b, a));
	}

}
