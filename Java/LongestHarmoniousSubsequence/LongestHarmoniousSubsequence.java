import java.util.HashMap;
import java.util.Map;

/**
 * (89ms)
 * Created by Phoenix-Z on 2017/5/22.
 */
public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        for(Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int now = Math.max(counter.getOrDefault(entry.getKey() + 1, 0),
                    counter.getOrDefault(entry.getKey() - 1, 0));
            longest = now != 0 ? Math.max(longest, now + entry.getValue()) : longest;
        }
        return longest;
    }

}
