package alg;

import java.util.List;

//Sort List
public class Solution27 {
	  /**
	   * 思路: 归并算法
	   * @param head
	   * @return
	   */
	  public ListNode sortList(ListNode head) {
		     
		      if(head == null || head.next == null) return head;
		      
		      /**
		       * 找出中间节点
		       */
		      ListNode  fast = head; //走到尾，则其变成了 尾节点
		      ListNode slow = head;//此时slow为中间节点
		      
		      while(fast != null && fast.next != null && fast.next.next != null){
		    	   fast = fast.next.next;
		    	   slow = slow.next;
		      }
		      ListNode left = head;
		      ListNode right = slow.next;
		      slow.next = null;
		      
		      
		      ListNode l = this.sortList(left);
		      ListNode r = this.sortList(right);
		      
		      ListNode sortHead = this.mergeSort(l,  r);
       
	          return sortHead;
	    }
	 
	  /**
	   *  合并左右两个已经排好序的列表
	   */
	private ListNode mergeSort(ListNode left, ListNode right) {
		    ListNode head = new ListNode(-1); //哨兵元素
		    ListNode node = head;
			while(left != null && right != null){
				 if(left.val < right.val){
					 node.next = left;
					  left = left.next;
				 }else{
					 node.next = right;
					 right = right.next;
				 }
				 
				 node= node.next;
			}
			
			
			while(left != null){
				  node.next = left;
				  left = left.next;
				  node = node.next;
			}
			
			while(right != null){
				  node.next = right;
				  right = right.next;
				  node = node.next;
			}
			
			return head.next;
	}

	public static void main(String[] args) {
		 ListNode n1 = new ListNode(5); 
		 ListNode n2 = new ListNode(4); 
		 ListNode n3 = new ListNode(3); 
		 ListNode n4 = new ListNode(2); 
		 //ListNode n5 = new ListNode(1); 
	 
		 n1.next = n2;
		 n2.next = n3;
		 n3.next = n4;
		 //n4.next = n5;
		 Solution27 solution = new Solution27();
		 ListNode n = solution.sortList(n1);
		 
		 while(n != null){
			 System.out.print( " " + n.val + " ");
			 n = n.next;
		 }
	}

}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
