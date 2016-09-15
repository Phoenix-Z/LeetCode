/**
 * (3ms)
 * ��������
 * ��[7,1,5,3,6,4]���������˵�����ǿ��Խ������ڵ�����������Ի��һ��������[-6,4,-2,3,-2]
 * ��ô����Ϳ���ת��Ϊ�ҵ�һ�������飬ʹ�������������������˵��������Ӧ����[4,-2,3],���Ϊ5
 * �����Maximum subarray���⣬����ʹ��Kadane's algorithm�����
 * https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * ��ʵ���Ͽɿ�����һ����̬�滮��ʱ�临�Ӷ�ΪO(n)
 * @author Phoenix-Z
 *
 */
public class Solution2 {

	public int maxProfit(int[] prices) {
		//maxEndingHere�����Ǽ�¼�������һ��ֵ�ӵ���ǰλ��ʱ��ֵ��������ϵ�ǰֵС��0��
		//maxEndingHere���Ϊ0���Ա�ʾ�޳�����ǰ׺
		int maxEndingHere = 0;
		//maxSoFar���Ǽ�¼��ǰ���ֵ���Է�maxEndingHere��С��ʧ���ֵ
		int maxSoFar = 0;
		
		//ע�����ѭ��ʵ����Ե�������֮��ɵ�����
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