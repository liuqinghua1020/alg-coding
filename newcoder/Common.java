import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuqinghua
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
测试样例：
{1,2,3,4,5,6,7},{2,4,6,8,10}
返回：[2.4.6]
 */
public class Common {
	 public int[] findCommonParts(ListNode headA, ListNode headB) {
	        
		 List<Integer> result = new ArrayList<Integer>();
		 
		 while(headA != null && headB != null){
			 if(headA.val < headB.val){
				 headA = headA.next;
			 }else if(headA.val > headB.val){
				 headB = headB.next;
			 }else{
				 result.add(headA.val);
				 headA = headA.next;
				 headB = headB.next;
			 }
		 }
		 
		 int[] res = new int[result.size()];
		 for(int i=0;i<result.size();i++){
			 res[i] = result.get(i);
		 }
		 return res;
	 }
	 
	 public static void main(String[] args){
		 Common com = new Common();
		 
		 ListNode h11 = new ListNode(1); 
		 ListNode h12 = new ListNode(2); 
		 ListNode h13 = new ListNode(3); 
		 ListNode h14 = new ListNode(4); 
		 ListNode h15 = new ListNode(5); 
		 ListNode h16 = new ListNode(6); 
		 ListNode h17 = new ListNode(7); 
		 
		 h11.next = h12;
		 h12.next = h13;
		 h13.next = h14;
		 h14.next = h15;
		 h15.next = h16;
		 h16.next = h17;
		 
		 ListNode h22 = new ListNode(2); 
		 ListNode h24 = new ListNode(4); 
		 ListNode h26 = new ListNode(6); 
		 ListNode h28 = new ListNode(8); 
		 ListNode h210 = new ListNode(10); 
		 
		 
		 h22.next = h24;
		 h24.next = h26;
		 h26.next = h28;
		 h28.next = h210;

		 int[] result = com.findCommonParts(h11, h22);
		 for(int re:result){
			 System.out.print(" " + re + " ");
		 }
	 }
	 
}
