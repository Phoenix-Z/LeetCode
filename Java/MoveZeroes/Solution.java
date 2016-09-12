/**
 * (0ms)
 * 这题的思路与remove element的方法二基本上是一致的，就是将非0值从头开始覆盖，然后再补0即可。
 * @author Phoenix-Z
 *
 */
public class Solution {
	public void moveZeroes(int[] nums) {
        int noZero = 0;
		for(int i = 0; i < nums.length; i++)
        {
        	if(nums[i] != 0)
        	{
        		nums[noZero++] = nums[i];
        	}
        }
		for(int i = noZero; i < nums.length; i++)
		{
			nums[i] = 0;
		}
		//System.out.println(Arrays.toString(nums));
    }
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		new Solution().moveZeroes(nums);
	}
}
