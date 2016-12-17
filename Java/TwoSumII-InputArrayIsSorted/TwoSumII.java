import java.util.HashMap;
import java.util.Map;
/**
 * (8ms)
 * 这个方法简单粗暴，首先将所有numbers中的数字以及他们出现的位置放置到一个map中，然后再依次遍历numbers
 * 数组，出国能够在map找到target减去当前遍历的值，就说明找到了这个配对。由于这道题目测试数据的特殊性，只有
 * 唯一解，这说明如果重复数字对结果有影响，那么这个数字只可能重复一次，所以虽然map在put时失去了这个重复数字
 * 出现的第一个位置，但是由于第二次遍历时先遇到的是第一次出现的重复数字，所以结果的正确性可以保证。
 * 另外，虽然表面上算法的时间复杂度是O(n)，但由于map在执行get操作时，虽然会比O(n)快一点，但是依然存在性能
 * 上的损耗。
 * @author Phoenix-Z
 *
 */
public class TwoSumII {

	public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for(int i = 0; i < numbers.length; i++) {
            Integer pos = map.get(target - numbers[i]);
            if(pos != null && !pos.equals(i)) {
                index[0] = i + 1;
                index[1] = map.get(target - numbers[i]) + 1;
                break;
            }
        }
        return index;
    }
	
}