/**
 * (16ms)
 * 这是一道动态规划的题目，maxCur用来判断是将当前数字添加到子数组之后的和更大，还是以该数组为开头的和更大，
 * 而maxSum是用来找出最大的maxCur。
 * 时间复杂度为O(n),空间复杂度为O(1).
 * @author Phoenix-Z
 *
 */
public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		int maxCur = nums[0];
		int maxSum = maxCur;
		for(int i = 1; i < nums.length; i++) {
			maxCur = Math.max(maxCur + nums[i], nums[i]);
			maxSum = Math.max(maxSum, maxCur);
		}
		return maxSum;
    }
	
}