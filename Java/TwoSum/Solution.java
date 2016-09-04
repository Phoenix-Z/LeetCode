import java.util.Arrays;
/**
 * (41ms)
 * 方法一：
 * 遍历所有二元组合，直至找到结果终止循环，若没有找到返回默认值{-1, -1}
 * 这种做法简单易想，时间复杂度为O(n^2)
 * @author Phoenix-Z
 *
 */
public class Solution {

	public int[] twoSum(int[] nums, int target) {
		int[] ans = {-1, -1};
		int len = nums.length;
		label:
		for(int i = 0; i < len - 1; i++)
		{
			for(int j = i + 1; j < len; j++)
			{
				if(nums[i] + nums[j] == target)
				{
					ans[0] = i;
					ans[1] = j;
					//若找到，则跳出两层循环
					break label;
				}
			}
		}
		return ans;
    }
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));
	}
}