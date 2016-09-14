import java.util.HashMap;
import java.util.Map;

/**
 * (24ms)
 * 方法一：
 * 借助于HashMap，遍历数组，将出现的数字即其出现的次数放入到map中，
 * 然后在遍历map中的数组中，找到值最大的那个键，即为majority元素。
 * 由于题目假定了一定存在出现次数大于等于[n/2]的元素，因此只要找到楚翔次数最多的元素即可。
 * @author Phoenix-Z
 *
 */

public class Solution {

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		
		//借助HashMap记录出现的整数以及其出现的次数
		for(int num : nums)
		{
			int count = map.getOrDefault(num, 0) + 1;
			map.put(num, count);
		}
		
		int majority = nums[0];
		int count = 0;
		
		//遍历Map找到出现次数最多的元素
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