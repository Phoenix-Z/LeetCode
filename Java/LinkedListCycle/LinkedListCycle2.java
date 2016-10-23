/**
 * (1ms)
 * 这个方法非常机智，它是使用了双指针技术，walker一次前进一步，
 * 而runner一次前进两步，那么如果链表是循环的话，这两个指针会相遇。
 * @author Phoenix-Z
 *
 */
public class LinkedListCycle2 {

	public boolean hasCycle(ListNode head) {
        if(head==null) 
        	return false;
		ListNode walker = head;
		ListNode runner = head;
		//这个判断很重要，它决定了runner和Walker是否可以向前进
		while(runner.next!=null && runner.next.next!=null) {
			//如果runner可以前进一步，那么walker一定可以前进一步
			walker = walker.next;
			runner = runner.next.next;
			//如果walker和runner相遇，就说明有循环
			if(walker==runner) 
				return true;
		}
		return false;
    }
	
}