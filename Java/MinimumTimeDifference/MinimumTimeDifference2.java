import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (23ms)
 * Created by Phoenix-Z on 2017/5/14.
 */
public class MinimumTimeDifference2 {

    public int findMinDifference(List<String> timePoints) {
        boolean[] times = new boolean[24 * 60];
        for(String time : timePoints) {
            String[] parts = time.split(":");
            int minute = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            if(times[minute])
                return 0;
            times[minute] = true;
        }
        int min = 10000, left = -1, prev = -1;
        for(int i = 0; i < times.length; i++) {
            if(times[i]) {
                if(left == -1)
                    left = i;
                if(prev != -1) {
                    min = Math.min(min, i - prev);
                }
                prev = i;
            }
        }
        int right = times.length - 1;
        while(!times[right]) {
            right--;
        }
        return Math.min(min, left + 24 * 60 - right);
    }

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>(Arrays.asList(new String[]{"23:59", "00:00"}));
        MinimumTimeDifference2 test = new MinimumTimeDifference2();
        System.out.println(test.findMinDifference(timePoints));
    }
}
