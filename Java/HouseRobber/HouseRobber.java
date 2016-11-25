/**
 * (1ms)
 * 这是一道动态规划的题目，odd表示盗取奇数序号(从1开始)的店家，even表示盗取偶数序号(从2开始)的店家，
 * 在遍历数组的过程中会比较盗取当前遍历的店家的收益大还是不盗取的收益大，使用两个变量就规避了盗取相邻
 * 店家的问题。
 * @author Phoenix-Z
 *
 */
public class HouseRobber {

	public int rob(int[] nums) {
		int odd = 0;
		int even = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(i % 2 == 0) {
				odd = Math.max(odd + nums[i], even);
			} else {
				even = Math.max(odd, even + nums[i]);
			}
		}
		
		return Math.max(odd, even);
	}
	
}