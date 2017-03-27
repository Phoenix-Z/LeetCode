package maxSumOfSubArray;
/**
 * 时间复杂度为O(n^3)
 * @author Phoenix-Z
 *
 */
public class Solution1 {

	public static int maxSubSum(int[] nums) {
		int maxSum = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int nowSum = 0;
				
				for (int k = i; k < j; k++) {
					nowSum += nums[k];
				}
				
				if(nowSum > maxSum) {
					maxSum = nowSum;
				}
			}
		}
		return maxSum;
	}
	
}
