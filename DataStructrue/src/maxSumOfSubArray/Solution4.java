package maxSumOfSubArray;

/**
 * 时间复杂度为O(n)。
 * 这个方法是基于一个事实，如果某个数是负数，那么这个数一定不是最大和子序列的起点，因为任何包含这个数作为起点的子序列
 * 都可以通过数组的下一个数作为起点得到改进。类似的，任何负的子序列也不可能是最优子序列的前缀。
 * @author Phoenix-Z
 *
 */

public class Solution4 {

	public static int maxSubSum(int[] nums) {
		int maxSum = 0, nowSum = 0;
		for(int num : nums) {
			nowSum += num;
			if(nowSum > maxSum) 
				maxSum = nowSum;
			else if (nowSum < 0)
				nowSum = 0;
		}
		return maxSum;
	}
	
}
