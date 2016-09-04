import java.util.HashMap;
import java.util.Map;

/**
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
测试样例：
[1,3,4,5,7],[1,2,3,4,0],2
返回：{1,2,3,4,5,7}
 * @author liuqinghua
 * 思路：首先根据 给定的东西构造 单向链表，然后在根据插入元素的情况，将单向链表构造成环形链表
 */
public class InsertValue {
	
	 public ListNode insert(int[] A, int[] nxt, int val) {
	        if(A== null || A.length == 0){
	            ListNode t= new ListNode(val);
	            return t;
	            
	        }
	        
	        
	        
	    ListNode head = new ListNode(A[0]);
	    ListNode r=head;
	    ListNode p;
	    for(int i=0;i<nxt.length-1;i++)
	    {
	        p=new ListNode(A[nxt[i]]);
	        r.next=p;
	        r=p;
	    }

	        
	        
	        
	        
	        
	        ListNode pos = head;
	        ListNode pas = head.next;
	        while(pas!=null){
	            if(val >=pos.val&&val<= pas.val)
	                break;
	            pos =pas;
	            pas = pas.next;
	        }
	        ListNode t= new ListNode(val);
	        t.next =pas;
	        pos.next=t;
	        if(val<head.val)
	            return t;
	        else
	            return head;
	            
    }

	public static void main(String[] args) {
		InsertValue iv = new InsertValue();
		int[] A = {1,3,4,5,7};
		int[] nxt = {1,2,3,4,0};
		int val = 0;
		ListNode ln = iv.insert(A, nxt, val);
		ListNode l = ln;
		do{
			System.out.print(" " + l.val + " ");
			l = l.next;
		}while(!l.equals(ln));
	}

}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
if(valNode.val < first.val){

}

int length = A.length;
int i=0;
while(i<length){
	 if(first.val < val && first.next.val > val ){
		 valNode.next = first.next;
		 first.next = valNode;
		 break;
	 }
	 first = first.next;
	 i++;
}

if(i == length){
	 ListNode node = new ListNode(val);
	 node.next = tail.next;
	 tail.next = node;
}
**/