import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * (20ms)
 * 这个方法主要参考以下的链接：
 * https://discuss.leetcode.com/topic/12537/a-short-recursive-java-solution-based-on-c-n-k-c-n-1-k-1-c-n-1-k
 * 它使用的是二项式定理的一个性质：C(n,k)=C(n-1,k-1)+C(n-1,k)。
 * @author Phoenix-Z
 *
 */
public class Combinations2 {

	public static List<List<Integer>> combine(int n, int k) {
		if (k > n || k == 0)
			return new LinkedList<>();
		List<List<Integer>> ans = combine(n - 1, k - 1);
		if (ans.size() == 0)
			ans.add(new LinkedList<>(Arrays.asList(n)));
		else {
			for(List<Integer> now : ans) {
				now.add(n);
			}
		}
		ans.addAll(combine(n - 1, k));
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(combine(4, 2));
	}
}
