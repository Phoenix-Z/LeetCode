import java.util.HashSet;
import java.util.Set;

/**
 * (7ms)
 * 判断链表是否有循环，可以将已经遍历过的节点添加到一个set中，
 * 如果该节点已经出现过了，则添加失败，则意味着出现了循环。
 * @author Phoenix-Z
 *
 */
public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while(head != null)
		{
			if(!set.add(head))
			    return true;
			head = head.next;
		}
		return false;
    }
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}