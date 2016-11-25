/**
 * (0ms)
 * 这个解法本质上与之前那个解法是一样的，也是使用动态规划，不过这个方法不区分盗取的是奇数还是偶数
 * 序号的店家，而是依据上一个状态和当前状态来实现不盗取相邻的店家。
 * @author Phoenix-Z
 *
 */
public class HouseRobber2 {

	public int rob(int[] nums) {
		//prevNo表示没盗上一家，prevYes表示盗了上一家
		int prevNo = 0;
		int prevYes = 0;
		for (int n : nums) {
			int temp = prevNo;
			//新的prevNo就是不盗取当前这一家，应该选取盗取或不盗取上一家的收益的最大值
			prevNo = Math.max(prevNo, prevYes);
			//新的prevYes就是盗取当前这一家，它一定是不盗取上一家(旧的prevNo)加上当前这一家的钱
			prevYes = n + temp;
		}
		//返回这两个值的较大值即可
		return Math.max(prevNo, prevYes);
	}

}