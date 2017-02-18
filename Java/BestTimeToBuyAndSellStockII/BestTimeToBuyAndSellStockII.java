/**
 * (1ms)
 * 在遍历数组时，如果当前值比now值更高，就将两个数之差添加到profit上，now一直都更新为当前值，即可满足要求。
 * @author Phoenix-Z
 *
 */
public class BestTimeToBuyAndSellStockII {

	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) {
			return 0;
		}
		int profit = 0;
		int now = prices[0];
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] > now) {
				profit += prices[i] - now;
			}
			now  = prices[i];
		}
		return profit;
    }
	
}
