import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * (69ms)
 * 这个方法想的过于复杂了，还是使用双指针更容易些。
 * @author Phoenix-Z
 *
 */
public class IsSubsequence {

	public static boolean isSubsequence(String s, String t) {
		if(s.length() == 0) {
            return true;
        }
		List<List<Integer>> pos = new ArrayList<>();
		for(int i = 0; i < 26; i++) {
			pos.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < t.length(); i++) {
			pos.get(t.charAt(i) - 'a').add(i);
		}
		List<Integer> now = pos.get(s.charAt(0) - 'a');
		for(int i = 1; i < s.length(); i++) {
			if(now.size() == 0) {
				return false;
			}
			List<Integer> tmp = pos.get(s.charAt(i) - 'a');
			int index = Collections.binarySearch(tmp, now.get(0));
			if(index >= 0) {
				now = tmp.subList(index + 1, tmp.size());
			} else {
				now = tmp.subList(~index, tmp.size());
			}
		}
		if(now.size() == 0) {
			return false;
		}
		return true;
    }
	
	public static void main(String[] args) {
		String s = "axc", t = "ahbgdc";
		System.out.println(isSubsequence(s, t));
	}
}
