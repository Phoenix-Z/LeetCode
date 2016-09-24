/**
 * (1ms)
 * 沿着链表删除重复的元素，使用递归的方法，逐一判断是否为重复的，在原路返回。
 * @author Phoenix-Z
 *
 */
public class RemoveDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
		//空链表
		if(head == null)
			return head;
		//遍历到了链表的尽头
		if(head.next == null)
			return head;
		//如果当前节点的值等于下一个节点的值，就将该节点删除
		if(head.next.val == head.val)
		{
			//删除重复节点
			head.next = head.next.next;
			//注意这里还是对当前节点操作，以防有连续三个以上的重复
			return deleteDuplicates(head);
		}
		//如果当前节点与后续节点不相同，则向前遍历
		head.next = deleteDuplicates(head.next);
		return head;
    }
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}