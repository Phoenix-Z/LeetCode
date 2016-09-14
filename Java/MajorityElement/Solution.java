import java.util.HashMap;
import java.util.Map;

/**
 * (24ms)
 * ����һ��
 * ������HashMap���������飬�����ֵ����ּ�����ֵĴ������뵽map�У�
 * Ȼ���ڱ���map�е������У��ҵ�ֵ�����Ǹ�������ΪmajorityԪ�ء�
 * ������Ŀ�ٶ���һ�����ڳ��ִ������ڵ���[n/2]��Ԫ�أ����ֻҪ�ҵ������������Ԫ�ؼ��ɡ�
 * @author Phoenix-Z
 *
 */

public class Solution {

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		
		//����HashMap��¼���ֵ������Լ�����ֵĴ���
		for(int num : nums)
		{
			int count = map.getOrDefault(num, 0) + 1;
			map.put(num, count);
		}
		
		int majority = nums[0];
		int count = 0;
		
		//����Map�ҵ����ִ�������Ԫ��
		for(Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			if(entry.getValue() > count)
			{
				count = entry.getValue();
				majority = entry.getKey();
			}
		}
		return majority;
    }
	
}