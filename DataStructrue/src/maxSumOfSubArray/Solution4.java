package maxSumOfSubArray;

/**
 * ʱ�临�Ӷ�ΪO(n)��
 * ��������ǻ���һ����ʵ�����ĳ�����Ǹ�������ô�����һ���������������е���㣬��Ϊ�κΰ����������Ϊ����������
 * ������ͨ���������һ������Ϊ���õ��Ľ������Ƶģ��κθ���������Ҳ�����������������е�ǰ׺��
 * @author Phoenix-Z
 *
 */

public class Solution4 {

	public static int maxSubSum(int[] nums) {
		int maxSum = 0, nowSum = 0;
		for(int num : nums) {
			nowSum += num;
			if(nowSum > maxSum) 
				maxSum = nowSum;
			else if (nowSum < 0)
				nowSum = 0;
		}
		return maxSum;
	}
	
}
