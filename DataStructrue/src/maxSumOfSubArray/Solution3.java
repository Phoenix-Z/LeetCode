package maxSumOfSubArray;

/**
 * 时间复杂度为O(nlogn)
 * 这个方法采用的是分治的思想，把一个数组分成左右两个部分，那么最大子序列和可能出现在三个部分，要么在左半部分，
 * 要么在右半部分，要么横跨左右两个部分。对于第三个情况，先分别求出包含分界数字的左半部分和右半部分的最大和，然后
 * 相加即可。
 * @author Phoenix-Z
 *
 */

public class Solution3 {

	public static int maxSubSum(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}
	
	public static int helper(int[] nums, int left, int right) {
		if(left == right)
			return nums[left] > 0 ? nums[left] : 0;
		int mid = (left + right) / 2;
		int maxLeftSum = helper(nums, left, mid);
		int maxRightSum = helper(nums, mid + 1, right);
		int maxLeftBoardSum = 0, leftBoardSum = 0;
		for(int i = mid; i >= left; i--) {
			leftBoardSum += nums[i];
			if(leftBoardSum > maxLeftBoardSum)
				maxLeftBoardSum = leftBoardSum;
		}
		int maxRightBoardSum = 0, rightBoardSum = 0;
		for(int i = mid + 1; i <= right; i++) {
			rightBoardSum += nums[i];
			if(rightBoardSum > maxRightBoardSum)
				maxRightBoardSum = rightBoardSum;
		}
		return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBoardSum + maxRightBoardSum);
	}
	
}
