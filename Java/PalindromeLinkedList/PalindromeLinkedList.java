import java.util.ArrayList;
import java.util.List;
/**
 * (6ms)
 * 这个解法是将链表中的值都取出来，然后当做数组形式的回文处理。
 * 时间复杂度是O(n)，但是空间复杂度也是O(n)。
 * @author Phoenix-Z
 *
 */
public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		List<Integer> values = new ArrayList<>(); 
		while(head != null)
		{
			values.add(head.val);
			head = head.next;
		}
		//使用两个指针，一个向后扫描，一个向前扫描。
		int i = 0, j = values.size() - 1;
		while(i < j) 
		{
			if(!values.get(i++).equals(values.get(j--)))
			{
				return false;
			}
		}
        return true;
    }
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}