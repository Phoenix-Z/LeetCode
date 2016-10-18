/**
 * (15ms)
 * 这个解法很机智，这也有点类似于滑动窗口的感觉，窗口大小为n，链表没结束就一直向前滑动，
 * 等到窗口一端接触到链表的尾部，那么窗口的另一端就是需要删除的元素，这个算法只需要遍历一遍链表。
 * 而且对于链表的头结点没有前一个节点的问题，这个解决方案事先创建了一个傀儡节点，这样就不需要特殊讨论，
 * 显得非常简洁。
 * @author Phoenix-Z
 *
 */
public class RemoveNthNodeFromEndOfList2 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		//start节点是一个傀儡节点，它表示头结点的前一个节点
		ListNode start = new ListNode(0);
		//slow是窗口的后端，fast是窗口的前端
		ListNode slow = start, fast = start;
		slow.next = head;
		//使窗口的前端前进，从而使得窗口大小为n
		for (int i = 1; i <= n + 1; i++) {
			fast = fast.next;
		}
		//当链表长度大于n，窗口向前滑动
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return start.next;
	}

}