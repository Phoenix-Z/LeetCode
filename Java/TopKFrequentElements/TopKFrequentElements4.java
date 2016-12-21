import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * (106ms)
 * 这个方法使用的是最大堆，在添加map条目到maxHeap中时，会根据值(即元素出现的次数)插入到堆里，最大值始终
 * 是堆顶元素，所以我们只要不断地将堆顶元素(堆顶元素是Map的条目，还需要使用getKey方法将实际需要的结果)添加
 * 到结果集中，直至结果集的大小等于k。
 * 由于这里使用了λ表达式，所以效率会相对较低。
 * @author Phoenix-Z
 *
 */
public class TopKFrequentElements4 {

	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        //使用优先权队列来实现最大堆
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                         new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
	
}