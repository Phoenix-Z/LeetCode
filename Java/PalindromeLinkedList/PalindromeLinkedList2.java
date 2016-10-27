/**
 * (1ms)
 * 这个解法就是把链表的前半部分先逆置，然后再逐个比较。判断是否到达链表的一半的方法很巧妙。
 * 这里逆转链表是使用迭代的方式。
 * @author Phoenix-Z
 *
 */
public class PalindromeLinkedList2 {

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		//slow指针每次走一步，fast指针每次走两步，
		//如果fast走到了链表的尾部，那么slow就走到了链表的一半
		//rev指向逆置后的前半部分链表的头结点
		ListNode rev = null, slow = head, fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			if (rev == null) {
				rev = slow;
				slow = slow.next;
			} else {
				//这部分是逆置链表的核心代码
				ListNode temp = slow;
				slow = slow.next;
				temp.next = rev;
				rev = temp;
			}
		}

		//链表长度为奇数时，跳过最中间的节点
		if (fast != null)
			slow = slow.next;

		//比较逆置后的前半个链表和后半个链表的值是否相等
		while (slow != null) {
			if (slow.val != rev.val)
				return false;
			slow = slow.next;
			rev = rev.next;
		}

		return true;
	}

}