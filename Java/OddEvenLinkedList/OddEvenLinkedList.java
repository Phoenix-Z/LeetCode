/**
 * (1ms)
 * 这个方法是首先找到链表的尾节点tail，与此同时便可以知道链表的长度了，然后在从链表头开始，将偶数位置的节点移至tail的后面即可。
 * @author Phoenix-Z
 *
 */
public class OddEvenLinkedList {

	public static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode tail = head;
		int len = 1;
		while (tail.next != null) {
			tail = tail.next;
			len++;
		}
		ListNode now = head;
		int i = 0;
		while (i < len / 2) {
			tail.next = now.next;
			tail = tail.next;
			now.next = now.next.next;
			tail.next = null;
			now = now.next;
			i++;
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
		while(now != null) {
			System.out.println(now.val);
			now = now.next;
		}
		ListNode newHead = oddEvenList(head);
		now = newHead;
		while(now != null) {
			System.out.println(now.val);
			now = now.next;
		}
	}
}
