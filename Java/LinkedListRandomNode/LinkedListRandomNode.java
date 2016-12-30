import java.util.Random;
/**
 * (121ms)
 * 这个方法虽然AC了，但是明显不是所需要的答案。这里首先从0到整型最大值之间随机选取一个数字，然后遍历链表，
 * 如果能够找到该随机数对应的节点(即该随机数小于链表长度)，就返回这个节点的值。如果随机数大于链表的长度，由于
 * 此时已经知道链表的长度，再从0到链表长度随机一个数字，找到这个数字对应的节点。
 * @author Phoenix-Z
 *
 */
public class LinkedListRandomNode {

	private ListNode list = null;
	Random random = new Random();

	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public LinkedListRandomNode(ListNode head) {
		list = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		int pos = random.nextInt(Integer.MAX_VALUE);
		ListNode head = list;
		int len = 0;
		while(pos-- > 0 && head != null) {
			head = head.next;
			len++;
		}
		if(pos != 0) {
			pos = random.nextInt(len);
			head = list;
			while(pos-- > 0 && head != null) {
				head = head.next;
			}
		}
		return head.val;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		LinkedListRandomNode solution = new LinkedListRandomNode(head);
		System.out.println(solution.getRandom())
		;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}