import java.util.ArrayList;
import java.util.List;
/**
 * (6ms)
 * 这一类的题目都是套路，以下链接有相关问题的总结。
 * https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
 * @author Phoenix-Z
 *
 */
public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		helper(ans, new ArrayList<>(), used, nums);
		return ans;
    }
	
	public void helper(List<List<Integer>> ans, List<Integer> now, boolean[] used, int[] nums) {
		int i;
		for(i = 0; i < used.length; i++) {
			if(!used[i]) {
				break;
			}
		}
		if(i == used.length) {
			// 需要注意的是这里一定要拷贝now中的数据，否则添加到ans中的只是一个引用
			ans.add(new ArrayList<>(now));
			return;
		}
		for(i = 0; i < nums.length; i++) {
			if(!used[i]) {
				used[i] = true;
				now.add(nums[i]);
				helper(ans, now, used, nums);
				now.remove(now.size() - 1);
				used[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Permutations test = new Permutations();
		int[] nums = {1, 2, 3};
		System.out.println(test.permute(nums));
	}
}
