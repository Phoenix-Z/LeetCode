import java.util.HashMap;
import java.util.Map;

/**
 * (11ms)
 * 这个解法使用HashMap来存储数组中出现的数字及其上次出现的位置，
 * 如果当前位置减去上次出现的位置(利用put操作的返回值)小于k，就返回true，
 * 如果遍历完之后没有返回true，则不存在，所以返回false。
 * @author Phoenix-Z
 *
 */
public class ContainsDuplicateII {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		//键为出现的整数，值为上次出现的位置
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
        	if(map.get(nums[i]) != null)
        	{
        		if(i - map.put(nums[i], i) <= k)
        		{
        			return true;
        		}
        	} else {
				map.put(nums[i], i);
			}
        }
		
		return false;
    }
	
}