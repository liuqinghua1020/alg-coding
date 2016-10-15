import java.util.List;
import java.util.Stack;

/**
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。调整后为，3->2->1->6->5->4->7->8->null。因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。

 * @author liuqinghua
 *
 */
public class KInverse {
	
	/**
	 * 思路: 利用栈，每k个元素 保存在 栈中，弹出，然后下一组 继续
	 * (链表逆序的问题，应该考虑 stack的使用)
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode inverse(ListNode head, int k) {
        // write code here
		if(head == null || k<= 1) return head;
		int length = 0;
		ListNode p = head;
		while(p != null){
			length ++;
			p = p.next;
		}
		if(length < k) return head;
		
		//设立一个哨兵元素
		ListNode first = new ListNode(-1);
		first.next = head;
		
		int index = 0;
		ListNode p1 = first; 
		ListNode p2 = first;
		ListNode cur = p1.next;
		
		Stack<ListNode> stack = new Stack<ListNode>();
		
		while(cur != null){
			index = 0;
			while(cur != null && index<k){
				stack.push(cur);
				cur = cur.next;
				index ++;
			}
			if(index == k){
				ListNode last = stack.peek();
				p2 = last.next;
				 
				 
				while(!stack.isEmpty()){
					ListNode ln = stack.pop();
					p1.next = ln;
					p1 = ln;
				}
				p1.next = p2;
				cur = p2;
			}
		}
		
		return first.next;
    }

	public static void main(String[] args) {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		ListNode p6 = new ListNode(6);
		ListNode p7 = new ListNode(7);
		ListNode p8 = new ListNode(8);
		
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		p6.next = p7;
		p7.next = p8;
		
		
		KInverse ks = new KInverse();
		ListNode lists = ks.inverse(p1, 4);
		while(lists != null){
			System.out.print(" " + lists.val + " ");
			lists = lists.next;
		}
	}

}
