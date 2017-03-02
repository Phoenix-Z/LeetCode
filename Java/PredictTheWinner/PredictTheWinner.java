package com.phoenix.ex486;

/**
 * (66ms)
 * 这个方法非常精妙，可以这样理解这个问题，要判断player1的分数是否比player2高，就是前者的分数减去后者之后，是否还大于等于0.
 * 这样对于player1选取某一个数字时，使用正号，player2选取数字时，使用负号，最后将结果相加即可。
 * 使用left和right代表选取数字时的索引，如果left等于right，那么就只剩下这一个数字，返回即可。
 * nums[left] - helper(nums, left + 1, right)表示当前玩家选取剩下数组的第一个数字。
 * nums[right] - helper(nums, left, right - 1)表示当前玩家选取剩下数组的最后一个数字。
 * @author Phoenix-Z
 *
 */
public class PredictTheWinner {

	public static boolean predictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1) >= 0;
    }
    private static int helper(int[] nums, int left, int right){        
        return left == right ? nums[left] : Math.max(nums[right] - helper(nums, left, right - 1), 
        		nums[left] - helper(nums, left + 1, right));
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 5, 233, 7};
		System.out.println(predictTheWinner(nums));
	}
}
