/**
 * (59ms)
 * 这个方法是先遍历两个链表，然后用字符串表示这两个数字，然后就使用之前写过的大数加法的算法，效率相对较高。
 * @author Phoenix-Z
 *
 */
public class AddTwoNumbersII2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        while(l1 != null) {
        	num1.append(l1.val);
        	l1 = l1.next;
        }
        while(l2 != null) {
        	num2.append(l2.val);
        	l2 = l2.next;
        }
        int i = num1.length() - 1, j = num2.length() - 1;
        boolean addOne = false;
        while(i >= 0 && j >= 0)
        {
        	int digit1 = num1.charAt(i--) - '0', digit2 = num2.charAt(j--) - '0';
        	if(digit1 + digit2 >= 10)
        	{
        		if(addOne)
        		{
        			ans.append(Integer.toString(digit1 + digit2 - 10 + 1));
        		} else {
        			ans.append(Integer.toString(digit1 + digit2 - 10));
        		}
        		addOne = true;
        	} else if(digit1 + digit2 == 9 && addOne) {
        		ans.append('0');
        		addOne = true;
        	} else if (addOne) {
				ans.append(Integer.toString(digit1 + digit2 + 1));
				addOne = false;
			} else {
				ans.append(Integer.toString(digit1 + digit2));
			}
        }
        while(i >= 0) {
        	int digit = num1.charAt(i--) - '0';
        	if(digit == 9 && addOne) {
        		ans.append('0');
        		addOne = true;
        	} else if(addOne) {
        		ans.append(Integer.toString(digit + 1));
        		addOne =false;
        	} else {
				ans.append(Integer.toString(digit));
			}
        }
        while(j >= 0) {
        	int digit = num2.charAt(j--) - '0';
        	if(digit == 9 && addOne) {
        		ans.append('0');
        		addOne = true;
        	} else if(addOne) {
        		ans.append(Integer.toString(digit + 1));
        		addOne =false;
        	} else {
				ans.append(Integer.toString(digit));
			}
        }
        if(addOne) {
        	ans.append('1');
        }
        ListNode node = res;
        for(i = 0; i < ans.length(); i++) {
        	node.next = new ListNode(ans.charAt(i) - '0');
        	node = node.next;
        }
        return res.next;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode ans = new AddTwoNumbersII2().addTwoNumbers(l1, l2);
		while(ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
}