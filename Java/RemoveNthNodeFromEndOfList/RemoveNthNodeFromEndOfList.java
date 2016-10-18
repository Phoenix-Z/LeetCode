/**
 * (16ms)
 * 这个方法首先先遍历一遍链表以获取链表的长度，然后根据链表的长度和n的值删除元素。
 * 需要注意的是删除链表中间的元素和删除头结点有些许不同。
 * @author Phoenix-Z
 *
 */
public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int len = 0;
        ListNode newHead = head;
        //获取链表长度
        while(newHead != null) 
        {
        	len++;
        	newHead = newHead.next;
        }
        int i = 0;
        newHead = head;
        //找到倒数第n个节点的前一个节点
        while(i < (len - n - 1))
        {
        	newHead = newHead.next;
        	i++;
        }
        //如果是删除头结点（因为头结点没有前一个节点），只需要重新指定头结点即可
        if(len == n)
        	head = newHead.next;
        //否则需要将被删除节点的前一个节点的next域指向被删除节点的后一个节点
        else
        	newHead.next = newHead.next.next;
        return head;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}