package maxSumOfSubArray;
/**
 * 时间复杂度为O(n^2)
 * @author Phoenix-Z
 *
 */
public class Solution2 {

	public static int maxSubSum(int[] nums) {
		int maxSum = 0;
		for (int i = 0; i < nums.length; i++) {
			int nowSum = 0;
			
			for (int j = i; j < nums.length; j++) {
				nowSum += nums[j];
				
				if(nowSum > maxSum) {
					maxSum = nowSum;
				}
			}
		}
		return maxSum;
	}
	
}
