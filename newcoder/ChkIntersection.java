
/**
 * 
 * @author liuqinghua
 * 何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交
 */
public class ChkIntersection {
	 
	 /**
	  * 思路： 
	  *   1. 首先判断各自链表的入环节点，如果是同一个，则进入步骤2，否则进入步骤3
	  *   2. 跟单项无环链表判断是否相交类似，终止条件是 到达相同的那个入环节点
	  *   3. 取head1的入环节点，开始遍历，如果其中会遇到head2的入环节点，则返回true；如果最终只是回到head1的入环节点，则返回false；
	  * @param head1
	  * @param head2
	  * @param adjust0
	  * @param adjust1
	  * @return
	  */
	public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1){ 
		ListNode enter1 = chkLoop(head1);
		ListNode enter2 = chkLoop(head2);
		
		if(enter1==null && enter2==null) return chkIntersectNoLoop(head1, head2);
		if(enter1==null || enter2==null) return false;
		
		return chkIntersectLoop(head1, head2);
    }
	
    
    	//判断两个无环单链表是否相交
	//先各自遍历一次，分别得到两个链表的长度差值diff，然后让长的链表先走diff步，之后再通过比较判断二者是否相交
	public boolean chkIntersectNoLoop(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return false;
        //得到两个链表的长度，并求得差值
        int lenA = 0;
        int lenB = 0;
        int diff = 0;
        ListNode cur = headA;
        while(cur!=null){
        	lenA++;
        	cur = cur.next;
        }
        cur = headB;
        while(cur!=null){
        	lenB++;
        	cur = cur.next;
        }
        diff = Math.abs(lenA-lenB);
        
        //长的链表先走
        while(diff-->0){
        	if(lenA>lenB) headA = headA.next;
        	else headB = headB.next;
        }
        //同时走
        while(headA!=null && headB!=null){
        	if(headA==headB) return true;
        	headA = headA.next;
        	headB = headB.next;
        }
        
        return false;
    }
	
	//判断两个有环单链表是否相交
	//通过比较两个链表的入环节点node1, node2, 考虑以下三种情况：
	//(1)node1==node2,入环前就已经相交
	//(2)node1!=node2 && node1在环内遇不到node2, 两者不相交
	//(3)node1!=node2 && node1在环内可以遇到node2，两者相交
	public boolean chkIntersectLoop(ListNode head1, ListNode head2) {
		ListNode enter1 = chkLoop(head1);
		ListNode enter2 = chkLoop(head2);
		
		if(enter1==enter2) return true;
		else{
			ListNode cur = enter1.next;
			while(cur!=enter1){
				if(cur == enter2) return true;
				cur = cur.next;
			}
			return false;
		}
    }
    
	//环的入口节点，无环则返回null
	public  ListNode chkLoop(ListNode head) {
		if(head==null || head.next==null) return null;
		
		ListNode slow = head;
		ListNode fast = head;
		while( fast!=null&& fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) break;
		}
		
		if(slow!=fast) return null;//无环
		
		fast = head;
		while(fast!=slow){
			fast = fast.next;
			slow = slow.next;
		}
		
        return fast;//环的入口
    }

}
