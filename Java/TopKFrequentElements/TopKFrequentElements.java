import java.util.ArrayList;
import java.util.List;
/**
 * (88ms)
 * 这个方法是最慢的一个(不过没有超时),首先是统计每个数字出现的次数，这里使用的是时间复杂度为O(n)的算法，
 * 先求出最大值和最小值，然后开一个max-min+1大小的数组，再遍历原始数组，统计数字出现的次数。
 * 至于找出出现次数最多的K个元素，我是先遍历counts数组，如果出现次数大于0，就将其放到list中，当然这个list
 * 是需要维护次序的，list按照从大到小排序，最后返回这个list的前k个元素即可。
 * 如果nums数组中有n个数字，m个不同的数字，这个算法的时间复杂度就是O(n * m)
 * @author Phoenix-Z
 *
 */
public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		//找到数组中的最大值和最小值
		for(int num :nums) {
			if(num > max) {
				max = num;
			}
			if(num < min) {
				min = num;
			}
		}
		//counts数组用来保存每个数字出现的次数
		int[] counts = new int[max - min + 1];
		for(int num : nums) {
			counts[num - min]++;
		}
		
		List<Integer> ans = new ArrayList<>();
		for(int i = 0; i < counts.length; i++) {
			if(counts[i] > 0) {
				int j = 0;
				//找到第一个小于当前count的数字，并将这个数字插入到list中
				while(j < ans.size() && counts[ans.get(j) - min] > counts[i]) {
					j++;
				}
				ans.add(j, i + min);
			}
		}
		return ans.subList(0, k);
    }
	
}