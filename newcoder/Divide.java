
/**
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
测试样例：
{1,4,2,5},3
{1,2,4,5}
 * @author liuqinghua
 *
 */
public class Divide {
	/**
	 * 有点类似于 插入排序，将 第一个 大于val的值标注起来（例如为 A），然后往右找到第一个比 val小的值，插入到A之前即可
	 * 注意; 需要自己构造一个 头节点
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode listDivide(ListNode head, int val) {
        if(head ==null || head.next == head) return head;
        
        ListNode first = new ListNode(-1);
        
        first.next = head;
        
        ListNode node = first;
        ListNode bigBefore = null;
        
        while(node != null && node.next != null){
        	if(node.next.val <= val){
        		if(bigBefore != null){
        			
        			ListNode tmp = node.next;
        			node.next = node.next.next;
        			
        			tmp.next = bigBefore.next;
        			bigBefore.next = tmp;
        			
        			bigBefore = bigBefore.next;
        					
        			continue;
        		}
        	}else if(node.next.val > val){
        		if(bigBefore == null){
        			bigBefore = node;
        		}
        	}
        	
        	node = node.next;
        }
        
		return first.next;
    }

	public static void main(String[] args) {
		Divide d = new Divide();
		/*ListNode l0 = new ListNode(-1);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		
		l0.next = l1;
		l1.next = l4;
		l4.next = l5;
		l5.next = l2;
		
		l0.next = l5;
		l5.next = l4;
		l4.next = l1;*/
		//1620,1134,861,563,1
		//ListNode l0 = new ListNode(-1);
		
		
		ListNode l1 = new ListNode(1620);
		ListNode l2 = new ListNode(1134);
		ListNode l3 = new ListNode(861);
		ListNode l4 = new ListNode(563);
		ListNode l5 = new ListNode(1);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		/*ListNode l1 = new ListNode(71);
		ListNode l2 = new ListNode(7);
		l1.next = l2;*/
		
		ListNode node = d.listDivide(l1, 1134);
		ListNode ln = node;
		while(ln != null){
			System.out.print(" " + ln.val + " ");
			ln = ln.next;
		}
	}

}


/**

	public ListNode listDivide(ListNode head, int val) {
        if(head ==null || head.next == head) return head;
        
        ListNode first = new ListNode(-1);
        
        first.next = head;
        
        ListNode node = first;
        ListNode bigBefore = null;
        
        while(node != null && node.next != null){
        	if(node.next.val < val){
        		if(bigBefore != null){
        			
        			ListNode tmp = node.next;
        			node.next = node.next.next;
        			
        			tmp.next = bigBefore.next;
        			bigBefore.next = tmp;
        			
        			bigBefore = bigBefore.next;
        					
        			
        		}
        	}else if(node.next.val > val){
        		if(bigBefore == null){
        			bigBefore = node;
        		}
        		
        		node = node.next;
        		
        	}else{
        		if(bigBefore == null){
        			bigBefore = node;
        			node = node.next;
        		}else{
        			ListNode tmp = node.next;
        			node.next = node.next.next;
        			
        			tmp.next = bigBefore.next;
        			bigBefore.next = tmp;
        			
        			bigBefore = bigBefore.next;
        		}
        	}
        	
        }
        
		return first.next;
    }
 * 
 */
