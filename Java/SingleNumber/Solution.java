import java.util.Arrays;
/**
 * 基本思路：先将所有元素排序，那么相同的元素必定相邻，而且只需要考虑
 * 从0开始的偶数个元素和相邻的元素是否相同，相同则出现了两次，否则只出现一次
 * 整个算法的时间复杂度为排序算法的时间复杂度，即最好为O(nlogn)
 * 空间复杂度为O(1)
 * @author phoenix-z
 *
 */
public class Solution {
	  public int singleNumber(int[] nums) {
		  if(nums.length == 1)
			  return nums[0];
		  Arrays.sort(nums);
		  for(int i = 0; i < nums.length - 1; i += 2)
		  {
			  if(nums[i] != nums[i + 1])
			  {
				  return nums[i];
			  }
		  }
		  return nums[nums.length - 1];
	  }
	  
	  public static void main(String[] args) {
		int[] nums = {1,1,-1,0,0};
		System.out.println(new Solution().singleNumber(nums));
	}
}
