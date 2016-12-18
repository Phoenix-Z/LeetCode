/**
 * (2ms)
 * 这道题目最容易想到的方法是先求出数组中所有数字的乘积，然后再除以每个位置上的数字即可。当然这种方法对于
 * 数组中恰好有一个0的情况不太适用。另外容易想到的算法是O(n^2)的时间复杂度，两层循环可以完成任务，当然提交
 * 后会超时。
 * 最好的方法如下所示，首先将第一个位置的乘积置为1，然后第i个位置的乘积为前i - 1个数字的乘积，那么对于最后
 * 一个位置的乘积来说，就是所需的。然后再使用一个新变量back，它是在从后向前遍历时不断更新的，它表示的是对于
 * 第i个位置而言，back是从i + 1往后所有数字的乘积。从而可以理解，在第一遍遍历时获取的是前i-1个数字的乘积，
 * 第二次遍历获取的是后面所有数字的乘积，这两个数字的乘积，就是除自己之外所有数字的乘积。
 * @author Phoenix-Z
 *
 */
public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int[] ans = new int[nums.length];
		ans[0] = 1;
		for(int i = 1; i < nums.length; i++) {
			ans[i] = ans[i - 1] * nums[i - 1];
		}
		int back = 1;
		for(int i = nums.length - 1; i >= 0; i--) {
			ans[i] *= back;
			back *= nums[i];
		}
		return ans;
    }
	
}
