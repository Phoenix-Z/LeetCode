import java.util.ArrayList;
import java.util.List;

/**
 * (4ms)
 * 这就是一个宽度优先搜索，但是判断条件写的不够简洁，可以参看方法二的改进。
 * @author Phoenix-Z
 *
 */
public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<>();
		generateHelper("", 0, n, ans);
		return ans;
    }
	
	public void generateHelper(String nowStr, int lenOfLeft, int totalLen, List<String> ans) {
		if(nowStr.length() == totalLen * 2) {
			ans.add(nowStr);
		}
		if(lenOfLeft < totalLen) {
			generateHelper(nowStr + "(", lenOfLeft + 1, totalLen, ans);
			if(nowStr.length() - lenOfLeft < lenOfLeft) {
				generateHelper(nowStr + ")", lenOfLeft, totalLen, ans);
			}
		} else {
			while(nowStr.length() < totalLen * 2) {
				nowStr += ")";
			}
			ans.add(nowStr);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new GenerateParentheses().generateParenthesis(3));
	}
}
