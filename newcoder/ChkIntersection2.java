
/**
 * 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？相交的话返回true，不想交的话返回false。
给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。
 * @author liuqinghua
 *
 */
public class ChkIntersection2 {
	/**
	 * 思路：
	 *    首先判断两个节点是否有环，如果head1与head2均无环，则按照无环的处理；如果一个有环，一个无环，则返回false；
	 *    如果两个都有环，则按照有环的方式处理
	 * @param head1
	 * @param head2
	 * @param adjust0
	 * @param adjust1
	 * @return
	 */
	public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        ListNode e1 = cycleNode(head1);
        ListNode e2 = cycleNode(head2);
        if((e1 != null && e2 == null) || (e1 == null && e2 != null)) return false;
        if(e1 != null && e1 == e2) return true;
        ListNode t = e1.next;
        while(t != e1){
            if(t == e2) return true;
            t = t.next;
        }
        return false;
    }
    //获取入环节点
    private ListNode cycleNode(ListNode head){
        ListNode f = head,s = head;
        if(f.next != null){
            f = f.next.next;
            s = s.next;
        }else{
            return null;
        }
        while(f != null && f != s){
            f = f.next;
            s = s.next;
            if(f != null){
                f = f.next;
            }else{
                return null;
            }
        }
        f = head;
        while(f != s){
            f = f.next;
            s = s.next;
        }
        return f;
    }
}
