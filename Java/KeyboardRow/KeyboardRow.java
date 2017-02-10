import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * (6ms)
 * 这个方法使用的是正则表达式。当然还有效率更高的算法，但是代码的简洁性以及可读性远不如正则表达式。
 * @author Phoenix-Z
 *
 */
public class KeyboardRow {

	public static String[] findWords(String[] words) {
		Pattern pattern = Pattern.compile("^(?i)([qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*)$");
		List<String> ans = new ArrayList<>();
		for(String word : words) {
			if(pattern.matcher(word).matches()) {
				ans.add(word);
			}
		}
		// 这里将list转换成String数组大方法值得学习记住
		return ans.toArray(new String[ans.size()]);
    }
	
	public static void main(String[] args) {
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		System.out.println(Arrays.toString(findWords(words)));
	}
}
