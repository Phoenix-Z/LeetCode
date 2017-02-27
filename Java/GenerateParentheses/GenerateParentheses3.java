import java.util.ArrayList;
import java.util.List;
/**
 * (3ms)
 * 这个方法使用StringBuilder代替String来提高性能，在这道题上体现的不明显，而且需要注意一些地方的坑。
 * @author Phoenix-Z
 *
 */
public class GenerateParentheses3 {

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		helper(res, new StringBuilder(), 0, 0, n);
		return res;
	}

	private void helper(List<String> res, StringBuilder sb, int open, int close, int n) {
		if (open == n && close == n) {
			res.add(sb.toString());
			return;
		}

		if (open < n) {
			sb.append("(");
			helper(res, sb, open + 1, close, n);
			// 这里需要将这一层递归添加的字符删掉，而String则不用
			// 因为StringBuilder使用的只有一个对象，而String在每一层递归使用的不同的对象
			sb.setLength(sb.length() - 1);
		}
		if (close < open) {
			sb.append(")");
			helper(res, sb, open, close + 1, n);
			sb.setLength(sb.length() - 1);
		}
	}

}
