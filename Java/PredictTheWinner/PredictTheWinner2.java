package com.phoenix.ex486;

/**
 * (6ms)
 * 这是对方法的优化，它增加了cache来存储中间值，用空间换取时间，可以看到性能的提高还是很明显的。
 * @author Phoenix-Z
 *
 */
public class PredictTheWinner2 {

	public boolean PredictTheWinner(int[] nums) {
		return helper(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= 0;
	}

	private int helper(int[] nums, int left, int right, Integer[][] mem) {
		if (mem[left][right] == null)
			mem[left][right] = left == right ? nums[right] : 
				Math.max(nums[right] - helper(nums, left, right - 1, mem), 
						nums[left] - helper(nums, left + 1, right, mem));
		return mem[left][right];
	}

}
