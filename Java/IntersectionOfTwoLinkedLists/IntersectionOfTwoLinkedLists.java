/**
 * (2ms)
 * 找到两个链表的交点（假设两个链表无环），可以先分别遍历链表，知道两个链表的长度（len1，len2）之后，
 * 对于较长的链表，先走（|len1 - len2|）步，那么剩下的长度就相同了。这时使用两个指针同步向前比较，
 * 如果相同就返回该节点，如果走到链表末尾都没有相交的节点，就返回null。
 * @author Phoenix-Z
 *
 */
public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int len1 = 0, len2 = 0;
		ListNode startA = headA;
		ListNode startB = headB;
		//分别获取两个链表的长度
		while(startA != null) 
		{
			len1++;
			startA = startA.next;
		}
		while(startB != null)
		{
			len2++;
			startB = startB.next;
		}
		startA = headA;
		startB = headB;
		//调整遍历的节点的位置
		if(len1 < len2) {
			while(len2-- > len1)
			{
				startB = startB.next;
			}
		} else {
			while(len1-- > len2)
			{
				startA = startA.next;
			}
		}
		//遍历看是否存在相交的节点
		while(startA != null && startB !=null)
		{
			//如果存在就返回该节点
			if(startA == startB)
				return startA;
			startA = startA.next;
			startB = startB.next;
		}
		//不存在就返回null
		return null;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}