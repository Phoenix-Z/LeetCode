/**
 * (686ms)
 * 这是一个递归的做法，对于java而言可以通过，对于Python而言则会超时，说明该算法并不是最优算法。
 * @author Phoenix-Z
 *
 */
public class TargetSum {

	public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, 0, S);
    }
	
	public int helper(int[] nums, int now, int S) {
		if(now == nums.length) {
			if(S == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		return helper(nums, now + 1, S - nums[now]) + helper(nums, now + 1, S + nums[now]);
	}
	
	public static void main(String[] args) {
		System.out.println(new TargetSum().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
	}
}
