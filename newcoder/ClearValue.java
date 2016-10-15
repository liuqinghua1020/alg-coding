
/**
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
测试样例：
{1,2,3,4,3,2,1},2
{1,3,4,3,1}
 * @author liuqinghua
 *
 */
public class ClearValue {
	
	/**
	 * 链表的值删除操作，一般是多设置几个指针进行 删除的现场的保留
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode clear(ListNode head, int val) {
       
		if(head == null) return null;
		
		ListNode first = new ListNode(-1);
		
		ListNode pre = first;
		ListNode cur = head;
		pre.next = cur;
		
		ListNode post = cur.next;
		
		
		while(cur != null){
			if(cur.val == val){
				pre.next = post;
				cur = post;
				if(cur != null){
					post = cur.next;
				}
			}else{
				pre = cur;
				cur = cur.next;
				if(cur != null){
					post = cur.next;
				}
			}
			 
		}
		
		return first.next;
    }

	public static void main(String[] args) {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(3);
		ListNode p6 = new ListNode(2);
		ListNode p7 = new ListNode(1);
		
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		p6.next = p7;
		
		ClearValue cv = new ClearValue();
		ListNode lists = cv.clear(p1, 2);
		while(lists != null){
			System.out.print(" " + lists.val + " ");
			lists = lists.next;
		}
	}

}
