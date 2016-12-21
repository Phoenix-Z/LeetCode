import java.util.ArrayList;
import java.util.List;
/**
 * (13ms)
 * 这只是对方法二的一个优化，基本思路和方法二是一致的，只不过在统计次数时没有使用map，而是采用了和方法一
 * 一样的时间复杂度为O(n)的算法，通过对比最后的运行时间，可以看到map的效率确实比较差。
 * @author Phoenix-Z
 *
 */
public class TopKFrequentElements3 {

	public List<Integer> topKFrequent(int[] nums, int k) {
        List<List<Integer>> bucket = new ArrayList<>();
        for(int i = 0; i < nums.length + 1; i++) {
            bucket.add(new ArrayList<>());
        }
        //仅仅在下面这个部分与方法二不同
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int num :nums) {
			if(num > max) {
				max = num;
			}
			if(num < min) {
				min = num;
			}
		}
		int[] counts = new int[max - min + 1];
		for(int num : nums) {
			counts[num - min]++;
		}

		for (int i = 0; i < counts.length; i++) {
			bucket.get(counts[i]).add(i + min);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.size() - 1; pos >= 0 && res.size() < k; pos--) {
			res.addAll(bucket.get(pos));
		}
		return res;
    }
	
}