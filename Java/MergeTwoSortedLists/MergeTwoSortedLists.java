/**
 * (14ms)
 * 这是一个递归的做法，首先获取链表头数值较小的作为新的头结点，然后递归找到后继节点。
 * @author Phoenix-Z
 *
 */
public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//如果l1是空链表，就返回l2，此时l2可能是空的，也可能是非空的
        if(l1 == null)
        	return l2;
        //如果l2是空链表，就返回l1，此时l1是非空的
        if(l2 == null)
        	return l1;
        //新的头结点
        ListNode head = null;
        //以l1的头结点作为新的头结点
        if(l1.val < l2.val)
        {
        	head = l1;
        	head.next = mergeTwoLists(l1.next, l2);
        }
        //以l2的头结点作为新的头结点
        else {
			head = l2;
			head.next = mergeTwoLists(l1, l2.next);
		}
        
        return head;
    }
	
	public static void main(String[] args) {
		
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) 
	{ 
		val = x; 
	}
}