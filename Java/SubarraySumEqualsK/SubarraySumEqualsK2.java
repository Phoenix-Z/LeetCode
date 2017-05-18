import java.util.HashMap;
import java.util.Map;

/**
 * (41ms)
 * 这个算法只需要遍历一遍数组。假设存在连续子数组的和sum[i,j]=k,那么它等于sum[0,j]-sum[0,i-1]，其中sum[0,i-1]可以用map
 * 存储起来，而sum[0,j]正好就是当前求得的和，从而可以求解。
 * Created by Phoenix-Z on 2017/5/16.
 */
public class SubarraySumEqualsK2 {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for(int num : nums) {
            sum += num;
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
