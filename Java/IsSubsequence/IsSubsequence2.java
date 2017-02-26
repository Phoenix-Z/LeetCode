/**
 * (46ms)
 * 这个方法使用的是双指针技术，很简单而且容易理解的做法。
 * @author Phoenix-Z
 *
 */
public class IsSubsequence2 {

	public static boolean isSubsequence(String s, String t) {
		if(s.length() == 0) {
			return true;
		}
		int posOfS = 0, posOfT = 0;
		while(posOfT < t.length()) {
			if(s.charAt(posOfS) == t.charAt(posOfT)) {
				posOfS++;
				if(posOfS == s.length()) {
					return true;
				}
			}
			posOfT++;
		}
        return false;
    }
	
	public static void main(String[] args) {
		String s = "abc", t = "asdbgdc";
		System.out.println(isSubsequence(s, t));
	}
}
