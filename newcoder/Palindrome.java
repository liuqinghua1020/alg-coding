/**
 * 请编写一个函数，检查链表是否为回文。
	给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
	测试样例：
	{1,2,3,2,1}
	返回：true
	{1,2,3,2,3}
	返回：false
 * @author liuqinghua
 *
 */
public class Palindrome {
     /**
      *  三种方式
      * 1. 全部压入栈中，以此弹出和原链表做比较
      * 2. 快慢指针，快指针到底，慢指针则在中心，此时根据链表中有多少数据，中心节点和栈中节点是否需要做比较，慢指针和栈中元素做比较
      * 3. 遍历过程中将后半部分的指针逆序，再做一次比较
      * @param pHead
      * @return
      */
	 public boolean isPalindrome(ListNode pHead) {
		 	if(pHead == null || pHead.next == null){
		 		return true;
		 	}
		 	ListNode another = null;
		 	try{
			 	int length = this.listLength(pHead);
			 	int mid = length / 2;
			 	int index = 1;
			 	ListNode midNode = pHead;
			 	while(midNode != null && index<mid){
			 		midNode = midNode.next;
			 		index ++;
			 	}
			 	
			 	if(midNode == null) return false;
			 	
			 	another = reverse(midNode.next);
			 	
			 	ListNode head = pHead;
			 	ListNode tail = another;
			 	
			 	while(tail != null){
			 		if(head.val != tail.val){
			 			return false;
			 		}
			 		head = head.next;
			 		tail = tail.next;
			 	}
			 	
			 	return true;
		 	}finally{
		 		reverse(another);
		 	}
	 }
	 
	 
	 public int listLength(ListNode node){
		 int length = 0;
		 while(node != null){
			 node = node.next;
			 length ++;
		 }
		 
		 return length;
	 }
	 
	 /**
	  * 将以 node开头的指针做逆序
	  * @param node
	  * @return 返回逆序后的头结点
	  */
	 public ListNode reverse(ListNode node){
		 if(node == null){
			 return null;
		 }
		 ListNode cur = node;
		 ListNode pre = null;
		 while(cur != null){
			 ListNode next = cur.next;
			 cur.next = pre;
			 pre = cur;
			 cur = next;
		 }
		 
		 return pre;
	 }

	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(1);
		
		n1.next = n2;
		n2.next = n3;
		/*n3.next = n4;
		n4.next = n5;
		n5.next = n6;*/
		
		
		
		System.out.println(p.isPalindrome(n1));
	}

}
