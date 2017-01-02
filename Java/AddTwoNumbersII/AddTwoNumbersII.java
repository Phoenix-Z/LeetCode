import java.math.BigInteger;
/**
 * (88ms)
 * 这个做法是先分别遍历两个链表，找到他们对应的数字，然后计算两个数字的和，最后分割成新链表。由于数字可能很大，
 * 所以这个方法使用了BigInteger类，并使用了其中的方法，不过效率较低。
 * @author Phoenix-Z
 *
 */
public class AddTwoNumbersII {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        BigInteger num1 = new BigInteger("0");
        BigInteger num2 = new BigInteger("0");
        while(l1 != null) {
        	num1 = num1.multiply(BigInteger.TEN).add(new BigInteger(""+l1.val));
        	l1 = l1.next;
        }
        while(l2 != null) {
        	num2 = num2.multiply(BigInteger.TEN).add(new BigInteger(""+l2.val));
        	l2 = l2.next;
        }
        //System.out.println("num1: " + num1 + ", num2: " + num2);
        BigInteger res = num1.add(num2);
        while(!res.equals(BigInteger.ZERO)) {
        	ListNode node = new ListNode(res.mod(BigInteger.TEN).intValue());
        	node.next = ans.next;
        	ans.next = node;
        	res = res.divide(BigInteger.TEN);
        }
        return res.equals(BigInteger.ZERO) ? ans : ans.next;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode ans = new AddTwoNumbersII().addTwoNumbers(l1, l2);
		while(ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
}

class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
}