/**
 * (0ms)
 * 迭代的做法：
 * 与递归的做法差不多，就是取下原链表的表头节点，然后添加到新链表的表头。
 * @author Phoenix-Z
 *
 */
public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;
	    while (head != null) {
	    	//取下原链表的表头
	        ListNode next = head.next;
	        //添加到新链表的表头
	        head.next = newHead;
	        //更新新链表的表头
	        newHead = head;
	        //更新原链表的表头
	        head = next;
	    }
	    return newHead;
    }
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}