/**
 * (0ms)
 * 递归的做法：
 * 这个方法较易理解，每次从链表上取下一个节点，改变他的指向。
 * @author Phoenix-Z
 *
 */
public class ReverseLinkedList2 {

	public ListNode reverseList(ListNode head) {
	    return reverseListInt(head, null);
	}

	private ListNode reverseListInt(ListNode head, ListNode newHead) {
	    if (head == null)
	        return newHead;
	    //取下head节点
	    ListNode next = head.next;
	    //添加到新链表的表头
	    head.next = newHead;
	    return reverseListInt(next, head);
	}
	
}