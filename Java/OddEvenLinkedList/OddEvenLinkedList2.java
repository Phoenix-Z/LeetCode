/**
 * (0ms)
 * 这个方法是使用两个新节点分别作为奇数位置和偶数位置节点新链表的头结点，然后将原链表分成两个独立的新链表，最后将even添加到odd
 * 之后即可。相比方法一，这里只需要遍历一次链表。
 * @author Phoenix-Z
 *
 */
public class OddEvenLinkedList2 {

	public static ListNode oddEvenList(ListNode head) {
		if (head != null) {
			ListNode odd = head, even = head.next, evenHead = even;
			while (even != null && even.next != null) {
				odd.next = odd.next.next;
				even.next = even.next.next;
				odd = odd.next;
				even = even.next;
			}
			odd.next = evenHead;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode now = head;
		for (int i = 2; i < 9; i++) {
			now.next = new ListNode(i);
			now = now.next;
		}
		now = head;
		while (now != null) {
			System.out.println(now.val);
			now = now.next;
		}
		ListNode newHead = oddEvenList(head);
		now = newHead;
		while (now != null) {
			System.out.println(now.val);
			now = now.next;
		}
	}
}
