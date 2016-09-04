
/**
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
给定带删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
 * @author liuqinghua
 *
 */
public class Remove {
	/**
	 * 思路：将待删除节点的下一个节点的数值复制到当前节点，然后删除下一节点
	 * @param pNode
	 * @return
	 */
	public boolean removeNode(Node pNode) {
        // 特殊情况，如果是尾结点，删除操作不成功！
        if(pNode.next == null) {
            return false;
        }
        
        pNode.val = pNode.next.val;
        // 可以不用临时变量
        pNode.next = pNode.next.next;
        // 注意返回值必须写
        return true;
    }

	public static void main(String[] args) {
		
	}

}

class Node {
    int val;
    Node next = null;

    Node(int val) {
        this.val = val;
    }
}

