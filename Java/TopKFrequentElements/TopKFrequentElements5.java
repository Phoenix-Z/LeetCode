import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * (29ms)
 * 依然同方法二一样，先使用map统计元素出现的次数，然后使用TreeMap，以出现的次数为键，由于多个数字可能出现
 * 的次数相同，所以值为一个list。由于TreeMap默认从小到大排序，所以只要不断从TreeMap的后端获取Entry，再
 * 通过Entry获取value,将其添加到结果集中即可。
 * @author Phoenix-Z
 *
 */
public class TopKFrequentElements5 {

	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        //使用TreeMap对次数排序
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
           int freq = map.get(num);
           if(!freqMap.containsKey(freq)){
               freqMap.put(freq, new LinkedList<>());
           }
           freqMap.get(freq).add(num);
        }
        
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
	
}