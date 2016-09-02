/**
 * 基本思路：异或（两个相同元素异或结果是0，任何元素与0异或仍是其自身）
 * 因此，如果所有元素一起异或，那么结果就是只出现一次的那个元素
 * 这个方法很精妙，只遍历了一次数组，时间复杂度为O(n),
 * 而且只使用了一个整型变量，空间复杂度为O(1)
 * @author phoenix-z
 *
 */
public class Solution2 {

	public int singleNumber(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		//@param ans 只出现一次的那个结果
		int ans = nums[0];
		for(int i = 1; i < nums.length; i++)
		{
			ans = ans ^ nums[i];
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] nums = {1,1,-1,0,0};
		System.out.println(new Solution().singleNumber(nums));
	}

}

