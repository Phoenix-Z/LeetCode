/**
 * (2ms)
 * ����һ��
 * change�������԰������ҵ���С���Ǹ�Ԫ�أ���maxProfit���԰����ҵ��������
 * ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ΪO(1)
 * ���½��ͺ���ϸ
 * https://discuss.leetcode.com/topic/40721/very-simple-java-solution-with-detail-explanation-1ms-beats-96
 * @author Phoenix-Z
 *
 */
public class Solution {

	public int maxProfit(int[] prices) {
		int maxProfit = 0, startIndex = 0;
		
        for(int i=1; i<prices.length; i++){
        	//startIndexָ��ľ��ǵ�ǰ��������С��Ԫ��
        	int change = prices[i]-prices[startIndex];
        	
        	//���changeС��0����˵����ǰiָ���Ԫ��С��startIndexָ���Ԫ��
        	if(change<0){
        		startIndex = i;
        	}
        	//��Ȼ��ǰ��Сֵ���ˣ����ǵ�ǰ�������ȴ��һ����䣬������Ҫ�ж�
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
