
/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 * @author liuqinghua
 *
 */
public class RandomListNodeSolution {
	
	/**
	 * 处理思路：
	 *  1.第一遍遍历的时候，每一个当前节点的后面接上 其 clone的节点。
	 *  2.第二遍遍历的时候，处理clone节点的random 问题
	 *  3.第三遍遍历的时候，处理clone节点的 next指针，并返回即可
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead){
		if(pHead == null) return null;
		if(pHead.next == null){
			RandomListNode cloneNode = new RandomListNode(pHead.label);
			return cloneNode;
		}
		
		//1.第一遍遍历
		RandomListNode cur = pHead;
		RandomListNode preNext = cur.next;
		while(cur != null){
			RandomListNode cloneNode = new RandomListNode(cur.label);
			cur.next = cloneNode;
			cloneNode.next = preNext;
			cur = preNext;
			if(cur != null){
				preNext = cur.next;
			}
		}
		
		//2.第二遍遍历，搞定 每一个clone节点的random指针
		cur = pHead;
		while(cur != null){
			RandomListNode cloneCur = cur.next;
			
			RandomListNode random = cur.random;
			
			if(random != null){
				cloneCur.random = random.next;
			}
			
			cur = cloneCur.next;
		}
		
		//3.第三遍遍历，搞定 每一个clone节点的next指针,并返回
		cur = pHead;
		RandomListNode cloneHead = cur.next;
		RandomListNode cloneCur = cloneHead;
		while(cur != null && cloneCur != null){
			RandomListNode next = cloneCur.next;
			if(next != null){
				cur.next = next;
				cloneCur.next = next.next;
			}
			cur = next;
			cloneCur = cloneCur.next;
		}
		
        return cloneHead;
    }

	public static void main(String[] args) {
		RandomListNode r1 = new RandomListNode(1);
		RandomListNode r2 = new RandomListNode(2);
		RandomListNode r3 = new RandomListNode(3);
		RandomListNode r4 = new RandomListNode(4);
		RandomListNode r5 = new RandomListNode(5);
		
		r1.next = r2;
		r2.next = r3;
		r3.next = r4;
		r4.next = r5;
		
		r1.random = r3;
		r2.random = r5;
		r4.random = r2;
		
		RandomListNodeSolution rns = new RandomListNodeSolution();
		RandomListNode result = rns.Clone(r1);
		
		while(result != null){
			System.out.println("#######################");
			System.out.println("node label " + result.label);
			
			RandomListNode nextNode = result.next;
			if(nextNode != null){
				System.out.println("node next label " + nextNode.label);
			}else{
				System.out.println("node next is null");
			}
			
			RandomListNode randomNode = result.random;
			if(randomNode != null){
				System.out.println("node random label " + randomNode.label);
			}else{
				System.out.println("node random is null");
			}
			
			System.out.println("#######################");
			
			result = result.next;
		}
	}

}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
