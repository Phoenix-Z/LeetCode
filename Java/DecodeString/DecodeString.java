import java.util.Stack;
/**
 * (4ms)
 * 这个题目最基本的想法就是使用两个栈，一个存储重复的次数，另一个存储需要重复的字符串。唯一需要注意的是重复
 * 字符串的入栈形态及其时机。
 * @author Phoenix-Z
 *
 */
public class DecodeString {

	public static String decodeString(String s) {
		//使用StringBuilder以避免生成大量的String对象
		StringBuilder ans = new StringBuilder();
		//dup用来存储重复的次数
		Stack<Integer> dup = new Stack<>();
		//strs用来存储重复的字符串
		Stack<StringBuilder> strs = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				int count = 0;
				while(Character.isDigit(s.charAt(i))) {
					count = count * 10 + (s.charAt(i++) - '0');
				}
				dup.push(count);
				i--;
			} else if(s.charAt(i) == '[') {
				strs.push(ans);
				ans = new StringBuilder();
			} else if(s.charAt(i) == ']') {
				StringBuilder dupString = strs.pop();
				int dupCount = dup.pop();
				while(dupCount-- > 0) {
					dupString.append(ans);
				}
				ans = dupString;
			} else {
				ans.append(s.charAt(i));
			}
		}
		return ans.toString();
    }
	
	public static void main(String[] args) {
		String s = "3[a2[c]s]2[b]";
		System.out.println(decodeString(s));
	}
}