import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
/**
 * (61ms)
 * 这个方法是用LinkedList存储这两个链表上的数字，再进行加法计算时，使用了LinkedList可以获取双向迭代器的特
 * 点(即使用listIterator方法得到一个ListIterator对象)，并使用previous方法从后往前迭代。这里的大数加法
 * 操作更加简洁，同样适用于方法二。
 * @author Phoenix-Z
 *
 */
public class AddTwoNumbersII3 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(1);
        List<Integer> num1 = new LinkedList<>();
        List<Integer> num2 = new LinkedList<>();
        while(l1 != null) {
        	num1.add(l1.val);
        	l1 = l1.next;
        }
        while(l2 != null) {
        	num2.add(l2.val);
        	l2 = l2.next;
        }
        ListIterator<Integer> it1 = num1.listIterator(num1.size());
        ListIterator<Integer> it2 = num2.listIterator(num2.size());
        
        boolean addOne = false;
        while(it1.hasPrevious() || it2.hasPrevious()) {
        	int sum = it1.hasPrevious() ? it1.previous() : 0;
        	sum = it2.hasPrevious() ? sum + it2.previous(): sum;
        	if(addOne)
        		sum++;
        	ListNode node = new ListNode(sum % 10);
        	node.next = res.next;
        	res.next = node;
        	addOne = sum >= 10 ? true : false;
        }
        return addOne ? res :res.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode ans = new AddTwoNumbersII3().addTwoNumbers(l1, l2);
		while(ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
}
