import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * (27ms)
 * 这个方法是使用map来统计元素出现的次数，然后使用次数作为索引，每个次数对应于若干个数字（list），这有点
 * 像桶排序，最后按照次数从高到低，将次数对应的若干个数字添加到结果集中，直至结果集的容量等于k。
 * @author Phoenix-Z
 *
 */
public class TopKFrequentElements2 {

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<List<Integer>> bucket = new ArrayList<>();
        for(int i = 0; i < nums.length + 1; i++) {
            bucket.add(new ArrayList<>());
        }
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		//统计每个数字出现的次数
		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		//按照次数，将数字添加到次数对应的list中
		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			bucket.get(frequency).add(key);
		}

		List<Integer> res = new ArrayList<>();

		//将出现次数最多的k个元素添加到结果集中
		for (int pos = bucket.size() - 1; pos >= 0 && res.size() < k; pos--) {
			res.addAll(bucket.get(pos));
		}
		return res;
    }
	
}