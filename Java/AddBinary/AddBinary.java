/**
 * (4ms)
 * 这道题目跟大数加法很类似，只不过是二进制加法。carry表示来自低位的进位。
 * @author Phoenix-Z
 *
 */
public class AddBinary {

	public String addBinary(String a, String b) {
		StringBuilder sum = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1;
		boolean carry = false;
		while(i >= 0 && j >= 0)
		{
			if(carry) {
				if(a.charAt(i) == '1' && b.charAt(j) == '1') {
					sum.append(1);
				} else if(a.charAt(i) == '0' && b.charAt(j) == '0') {
					sum.append(1);
					carry = false;
				} else {
					sum.append(0);
				}
			} else {
				if(a.charAt(i) == '1' && b.charAt(j) == '1') {
					sum.append(0);
					carry = true;
				} else if(a.charAt(i) == '0' && b.charAt(j) == '0') {
					sum.append(0);
				} else {
					sum.append(1);
				}
			}
			i--;
			j--;
		}
		while(i >= 0) {
			if(carry) {
				if(a.charAt(i) == '1') {
					sum.append(0);
				} else {
					sum.append(1);
					carry = false;
				}
			} else {
				sum.append(a.charAt(i));
			}
			i--;
		}
		
		while(j >= 0) {
			if(carry) {
				if(b.charAt(j) == '1') {
					sum.append(0);
				} else {
					sum.append(1);
					carry = false;
				}
			} else {
				sum.append(b.charAt(j));
			}
			j--;
		}
		if(carry) {
			sum.append(1);
		}
		return sum.reverse().toString();
    }
	
	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("0", "1"));
	}
}