/**
 * (2ms)
 * 这个解法和解法2基本是一样的，只不过把各个功能拆分开来了，而且逆置的是后半部分的链表。
 * @author Phoenix-Z
 *
 */
public class PalindromeLinkedList3 {

	//获取中间节点，也是采用的一个走一步，一个走两步的方法
	private ListNode findMiddle(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	//逆置链表
	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		//获取中间节点
		ListNode middle = findMiddle(head);
		//逆转后半部分，前半部分长度为长度的二分之一(向下取整)
		middle.next = reverse(middle.next);
		ListNode p1 = head;
		ListNode p2 = middle.next;
		while (p1 != null && p2 != null && p1.val == p2.val) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2 == null;
	}

}
