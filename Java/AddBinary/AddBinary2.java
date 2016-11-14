/**
 * (4ms) 
 * 基本思路是一样的，但是代码简洁易理解，学习一下。
 * @author Phoenix-Z
 *
 */
public class AddBinary2 {

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			// 这里使用取余获取和，使用整除获取进位很优美，不需要判断很多次
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}

}
