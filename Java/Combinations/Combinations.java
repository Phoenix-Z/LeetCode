import java.util.ArrayList;
import java.util.List;
/**
 * (42ms)
 * 这是个递归的做法，多加了一个prev参数，表示之前添加的数字是几。
 * @author Phoenix-Z
 *
 */
public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		helper(ans, new ArrayList<>(), n, k, 0);
		return ans;
    }
	
	public void helper(List<List<Integer>> ans, List<Integer> now, int n, int k, int prev) {
		if(now.size() == k) {
			ans.add(new ArrayList<>(now));
			return;
		}
		for(int i = prev + 1; i <= n; i++) {
			now.add(i);
			helper(ans, now, n, k, i);
			now.remove(now.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		Combinations test = new Combinations();
		System.out.println(test.combine(4, 2));
	}
}
