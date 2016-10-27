/**
 * (3ms)
 * 这个方法没有先求出两个链表的长度，非常的聪明。
 * 如果两个链表长度一样，那么直接遍历即可。
 * 如果长度不一样，那么走链表长度短的那个指针a先走完，那么将该指针（a）指向另一个链表，
 * 在该链表上的指针（b）继续走，那么a在链表B上多走了链表长度之差，
 * @author Phoenix-Z
 *
 */
public class IntersectionOfTwoLinkedLists2 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// 特殊处理，提高效率
		if (headA == null || headB == null)
			return null;

		ListNode a = headA;
		ListNode b = headB;

		// 如果两个链表有不一样的长度, 循环会在第二次迭代时终止
		while (a != b) {
			// 如果其中一个指针指向的链表已经走到链表尾，就指向另一个链表的表头
			//这样的话，等到另一个指针也走完原来的链表而指向另一个链表时，剩下的长度就是一样的
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}

		return a;
	}

}