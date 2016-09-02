import java.util.Arrays;
/*
 * 对数组排序，出现两次的数字一定是相邻的两个数
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
