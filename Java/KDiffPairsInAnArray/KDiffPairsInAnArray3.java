import java.util.HashMap;
import java.util.Map;
/**
 * (44ms)
 * 看起来是O(n)的算法，但毕竟Map的存取并不是O(1)，所以性能没有想象的那么好。
 * @author Phoenix-Z
 *
 */
public class KDiffPairsInAnArray3 {

	public static int findPairs(int[] nums, int k) {
		if(nums == null || nums.length < 2 || k < 0) {
			return 0;
		}
		Map<Integer, Integer> numsCount = new HashMap<Integer, Integer>();
		for(int num : nums) {
			numsCount.put(num, numsCount.getOrDefault(num, 0) + 1);
		}
		int count = 0;
		for(Map.Entry<Integer, Integer> entry : numsCount.entrySet()) {
			if(k == 0) {
				if(entry.getValue() >= 2) {
					count++;
				}
			} else {
				if(numsCount.containsKey(entry.getKey() + k)) {
					count++;
				}
			}
		}
		return count;
	}
	
}
