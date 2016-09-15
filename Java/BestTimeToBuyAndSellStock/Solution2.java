/**
 * (3ms)
 * 方法二：
 * 拿[7,1,5,3,6,4]这个数组来说，我们可以将其相邻的两个数相减以获得一个新数组[-6,4,-2,3,-2]
 * 那么题意就可以转化为找到一个子数组，使其和最大，拿上面的例子来说，子数组应该是[4,-2,3],其和为5
 * 这就是Maximum subarray问题，可以使用Kadane's algorithm来解决
 * https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * 这实际上可看做是一个动态规划，时间复杂度为O(n)
 * @author Phoenix-Z
 *
 */
public class Solution2 {

	public int maxProfit(int[] prices) {
		//maxEndingHere变量是记录从数组第一个值加到当前位置时的值，如果加上当前值小于0，
		//maxEndingHere则变为0，以表示剔除负数前缀
		int maxEndingHere = 0;
		//maxSoFar就是记录当前最大值，以防maxEndingHere变小后丢失最大值
		int maxSoFar = 0;
		
		//注意这个循环实际针对的是两项之差构成的数组
		for(int i = 0; i < prices.length - 1; i++)
		{
			maxEndingHere = Math.max(0, maxEndingHere + prices[i + 1] - prices[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		
		return maxSoFar;
    }
	
	public static void main(String[] args) {
		int[] prices = {7, 6, 4, 3, 1};
		System.out.println(new Solution2().maxProfit(prices));
	}