/**
 * (18ms)
 * @author Phoenix-Z
 *
 */
public class ReverseWordsInAStringIII {

	public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        for(String piece : s.split(" ")) {
            StringBuilder now = new StringBuilder(piece);
            ans.append(now.reverse()).append(' ');
        }
        return ans.deleteCharAt(ans.length() - 1).toString();
    }
	
}