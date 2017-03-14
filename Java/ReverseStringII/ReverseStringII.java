/**
 * (13ms)
 * @author Phoenix-Z
 *
 */
public class ReverseStringII {

	public String reverseStr(String s, int k) {
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < s.length(); i += k) {
			int end = Math.min(i + k, s.length());	
			StringBuilder tmp = new StringBuilder(s.substring(i, end));
			if((i / k) % 2 == 0)
				tmp.reverse();
			ans.append(tmp);
		} 
		return ans.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(new ReverseStringII().reverseStr("abcdefg", 2));
	}
}
