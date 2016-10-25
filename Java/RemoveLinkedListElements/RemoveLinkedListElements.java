package com.phoenix.ex203;

/**
 * (1ms)
 * 这题要求删除给定值对应的节点。使用双指针技术。
 * @author Phoenix-Z
 *
 */
public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		//生成一个傀儡节点，然后指向头结点，是为了避免需要删除头结点时的特殊讨论
		ListNode start = new ListNode(0);
		start.next = head;
		//pre指向now的前一个节点
		ListNode pre = start;
		//now指向当前遍历的节点
		ListNode now = head;
		while(now != null) 
		{
			if(now.val == val) 
			{
				//如果需要删除节点，将pre的next指向now的next
				pre.next = now.next;
				//更新now
				now = pre.next;
			} else {
				//不需要删除节点时，pre和now均向前前进一步
				pre = now;
				now = now.next;
			}
		}
		return start.next;
    }
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}