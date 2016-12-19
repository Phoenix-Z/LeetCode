import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * (18ms)
 * 这个方法就是利用相对较多的空间来实现算法，这里面写了三种实现，都是利用了额外的数据结构，当然这道题目最快的
 * 做法是使用位运算，在方法二中可以看到。
 * @author Phoenix-Z
 *
 */
public class SingleNumberIII {

	//18ms
	/*
	 * 这个方法最朴素，先遍历数组，统计每个数字出现的次数并将结果放到map中，然后再遍历map找出出现
	 * 次数为1的数字，显然效率很低。
	 */
	public int[] singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int[] ans = new int[2];
		int i =0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				ans[i++] = entry.getKey();
			}
		}
		return ans;
    }
	
	//9ms
	/*
	 * 这个方法是对上面的方法的优化，因为数字只可能出现一次或者两次，那么如果map中有数字对应的键，就说明
	 * 这是该数字出现的第二次，那么就不是我们需要的数字，可以直接将该数字删除。如果map中没有该数字，说明
	 * 这是该数字第一次出现，将其放置到map中。
	 */
	public int[] singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums) {
			//这里应用了map删除操作的返回值，如果返回的是null，说明map中没有该数字，否则有之
			if(map.remove(num) == null)
			    map.put(num, 1);
		}
		int[] ans = new int[2];
		int i = 0;
		//使用删除操作的另一个好处，就是map中只用我们需要的数字，而且我们不在乎值是什么，所以直接
		//获取键所对应的set即可
		for(int num : map.keySet()) {
		    ans[i++] = num;
		}
		return ans;
    }
	
	//11ms
	/*
	 * 这里的基本思路同上面第二个方法基本一致，不过考虑到我们不在乎值是多少，只关心键，所以使用一个
	 * set就可以满足需求。
	 */
	public int[] singleNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>();
		for(int num : nums) {
			if(!set.remove(num)) {
		        set.add(num);
		    }
		}
		int[] ans = new int[2];
		int i = 0;
		for(int num : set) {
		    ans[i++] = num;
		}
		return ans;
    }
}