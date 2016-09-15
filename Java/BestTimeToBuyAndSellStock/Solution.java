/**
 * (2ms)
 * 方法一：
 * change变量可以帮我们找到最小的那个元素，而maxProfit可以帮助找到最大利润
 * 时间复杂度为O(n)，空间复杂度为O(1)
 * 以下解释很详细
 * https://discuss.leetcode.com/topic/40721/very-simple-java-solution-with-detail-explanation-1ms-beats-96
 * @author Phoenix-Z
 *
 */
public class Solution {

	public int maxProfit(int[] prices) {
		int maxProfit = 0, startIndex = 0;
		
        for(int i=1; i<prices.length; i++){
        	//startIndex指向的就是当前遇到的最小的元素
        	int change = prices[i]-prices[startIndex];
        	
        	//如果change小于0，这说明当前i指向的元素小于startIndex指向的元素
        	if(change<0){
        		startIndex = i;
        	}
        	//虽然当前最小值变了，但是当前最大利润却不一定会变，所以需要判断
        	else if(maxProfit < change) {
        		maxProfit = change;
        	}
        }
    	return maxProfit;
    }
	
	public static void main(String[] args) {
		int[] prices = {7, 6, 4, 3, 1};
		System.out.println(new Solution().maxProfit(prices));
	}
}
