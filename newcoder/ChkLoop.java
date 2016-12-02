
/**
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，请返回所求值。
 * @author liuqinghua
 *
 */
public class ChkLoop {
	/**
	 * 思路：两个指针，一个快指针，一个慢指针，快指针每次经过两个节点，慢指针每次经过一个节点，如果有环，快指针和慢指针一定会相遇的。
	 * 对于java来说，指针相遇 意味着 直接对象的引用相等。
	 * 
	 * 接着，快指针重新回到 head节点，并开始一个节点一个节点得走，直到再次和慢指针相遇，此时相遇的节点就是环的入口
	 * @param head
	 * @param adjust
	 * @return
	 */
	public int chkLoop(ListNode head, int adjust) {
		ListNode fast = head;
		ListNode slow = head;
		boolean isLoop = false;
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				isLoop = true;
				break;
			}
		}
		if(!isLoop){
			return -1;
		}
		fast = head;
		while(fast != slow){
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast.val;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l4;
		
		ChkLoop cl = new ChkLoop();
		System.out.println(cl.chkLoop(l1, 0));
	}
}
