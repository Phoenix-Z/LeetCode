/**
 * (8ms)
 * 这个方法就是统计每个整数32位上出现的1的个数，如果正好出现的次数是3的整数倍，
 * 那么这一位1一定属于出现3次的数字，否则属于出现一位的数字，
 * 这个算法的时间复杂度是O(32n)，即O(n)
 * @author Phoenix-Z
 *
 */
public class SingleNumberII {

	public int singleNumber(int[] nums) {
		int[] count = new int[32];
		for(int num : nums)
		{
			for(int i = 0; i < 32; i++)
			{
				if(((num >> i) & 1) == 1)
				{
					count[i]++;
				}
			}
		}
		int ans = count[31] % 3;
		for(int i = 30; i >= 0; i--)
		{
			count[i] %= 3;
			ans = (ans << 1) | count[i];
		}
		return ans;
    }
	
	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(new SingleNumberII().singleNumber(nums));
	}
}