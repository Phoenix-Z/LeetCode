import java.util.*;

/**
 * (62ms)
 * 这个算法是先对所有时间进行排序，然后找出最小时间差。
 * Created by Phoenix-Z on 2017/5/14.
 */
public class MinimumTimeDifference {

    class Time {
        int hour, minute;

        public Time(String hour, String minute) {
            this.hour = Integer.parseInt(hour);
            this.minute = Integer.parseInt(minute);
        }
    }

    public int findMinDifference(List<String> timePoints) {
        List<Time> times = new ArrayList<>();
        for(String time : timePoints) {
            String[] parts = time.split(":");
            times.add(new Time(parts[0], parts[1]));
        }

        Collections.sort(times, new Comparator<Time>() {
            @Override
            public int compare(Time s1, Time s2) {
                if(s1.hour == s2.hour) {
                    return s1.minute - s2.minute;
                }
                return s1.hour - s2.hour;
            }
        });
        int minDiff = 10000;
        for(int i = 0; i < times.size() - 1; i++) {
            minDiff = Math.min(minDiff, getMinutes(times.get(i), times.get(i + 1)));
        }
        times.get(0).hour += 24;
        return Math.min(minDiff, getMinutes(times.get(times.size() - 1), times.get(0)));
    }

    private int getMinutes(Time t1, Time t2) {
        int res = 0;
        if(t2.minute >= t1.minute) {
            res += (t2.hour - t1.hour) * 60 + (t2.minute - t1.minute);
        } else {
            res += (t2.hour - t1.hour - 1) * 60 + (t2.minute + 60 - t1.minute);
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>(Arrays.asList(new String[]{"23:59", "00:00"}));
        MinimumTimeDifference test = new MinimumTimeDifference();
        System.out.println(test.findMinDifference(timePoints));
    }
}
