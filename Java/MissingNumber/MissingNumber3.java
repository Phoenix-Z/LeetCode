/**
 * (1ms)
 * 时间复杂度O(n)，空间复杂度O(1)
 * 这里的方法是最好的，无论是时间复杂度还是空间复杂度。缺失的数字可以通过先求出0到n的sum，然后再减去nums
 * 数组中所有的数字，剩下来的就是缺失的数字。将加法操作和减法操作放在一个循环里，既可以节省代码，又可以
 * 避免溢出。
 * 其实这道题目是single number的变种，如果把nums中的数和0到n放在一起，那么就是要找出只出现一次的那个数字
 * 所以这里还可以使用异或来找到缺失的数字。
 * @author Phoenix-Z
 *
 */
public class MissingNumber3 {

	public int missingNumber(int[] nums) {
		int ans = nums.length;
		for(int i = 0; i < nums.length; i++) {
			ans += i;
			ans -= nums[i];
			// ans ^= i ^ nums[i];
		}
		return ans;
    }
	
}