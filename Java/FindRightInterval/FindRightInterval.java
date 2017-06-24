import com.phoenix.Util.Interval;

import java.util.Map;
import java.util.TreeMap;

/**
 * (54ms)
 * Created by Phoenix-Z on 2017/5/27.
 */
public class FindRightInterval {

    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }
        int[] ans = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            ans[i] = entry == null ? -1 : entry.getValue();
        }
        return ans;
    }

}
