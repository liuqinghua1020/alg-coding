
/**
 * 现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。保证两个链表长度小于等于500。
 * @author liuqinghua
 *
 */
public class CheckIntersect {
	
	/**
	 * 思路：每一个链表遍历到尾节点，看尾节点是否相同即可
	 * @param headA
	 * @param headB
	 * @return
	 */
	public boolean chkIntersect(ListNode headA, ListNode headB) {
		ListNode nodeA = headA;
		ListNode nodeB = headB;
		while(nodeA != null && nodeA.next != null){
			nodeA = nodeA.next;
		}
		
		while(nodeB != null && nodeB.next != null){
			nodeB = nodeB.next;
		}
		
		return nodeA == nodeB;
	}
	
	public static void main(String[] args) {
		
	}

}
