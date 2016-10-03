/**
 * (4ms)
 * 这是一个迭代的做法,这种方法的空间复杂度相比于递归的做法会小很多。
 * @author Phoenix-Z
 *
 */
public class SwapNodesInPairs2 {

	public ListNode swapPairs(ListNode head) {
		//空链表
		if (head == null) {
	        return null;
	    }
		//dummy(傀儡节点)实际上是在链表的最开始增加一个节点，方便操作，该节点的值可以随便赋值
	    ListNode dummy = new ListNode(0);
	    //dummy指向给定的链表
	    dummy.next = head;
	    //current指向需要交换一对节点的第一个节点的前一个节点
	    ListNode current = dummy;
	    while (current.next != null && current.next.next != null) {
	    	//需要交换的一对节点中的第一个节点
	        ListNode first = current.next;
	        //需要交换的一对节点中的第二个节点
	        ListNode second = current.next.next;
	        first.next = second.next;
	        current.next = second;
	        current.next.next = first;
	        //更新current的指向，可以看到他的步长为2
	        current = current.next.next;
	    }
	    //注意需要返回的是傀儡节点后面的链表
	    return dummy.next;
	}
	
}