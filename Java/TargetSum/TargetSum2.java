/**
 * (15ms)
 * 这个解法可以首先参考以下discuss中的分析：
 * https://discuss.leetcode.com/topic/76243/java-15-ms-c-3-ms-o-ns-iterative-dp-solution-using-subset-sum-with-explanation
 * 首先可以将问题简化成找出nums的一个子集，使得sum(nums) = (target + sum(nums)) / 2,而且可以剪枝提高效率。
 * 从而这个题目就是一个子集和问题，使用动态规划解决，可以参考以下链接：
 * https://zh.wikipedia.org/wiki/%E5%AD%90%E9%9B%86%E5%92%8C%E5%95%8F%E9%A1%8C
 * dp[i]是指从nums选取若干个数，它们的和是i的种数。这里使用的是回溯法。
 * @author Phoenix-Z
 *
 */
public class TargetSum2 {

	public int findTargetSumWays(int[] nums, int target) {
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		return sum < target || (target + sum) % 2 != 0 ? 0 : knapsack(nums, (target + sum) / 2);
    }
	
	public int knapsack(int[] nums, int sum) {
		int[] dp = new int[sum + 1];
		// 由于nums中的数字都是正数，所以和为0的可能只有一种，即不选取任何数字
		dp[0] = 1;
		for(int num : nums) {
			// 如果num大于sum，不会执行以下循环，这就是说不选取num
			for(int i = sum; i >= num; i--) {
				dp[i] += dp[i - num];
			}
		}
		return dp[sum];
	}
	
	public static void main(String[] args) {
		System.out.println(new TargetSum2().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
	}
}
