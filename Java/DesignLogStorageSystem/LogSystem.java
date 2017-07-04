import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (183ms)
 * Created by Phoenix-Z on 2017/7/4.
 */
public class LogSystem {

    private Map<Integer, String> records = null;
    private Map<String, Integer> granularity = null;

    public LogSystem() {
        records = new HashMap<>();
        granularity = new HashMap<>();
        granularity.put("Year", 0);
        granularity.put("Month", 1);
        granularity.put("Day", 2);
        granularity.put("Hour", 3);
        granularity.put("Minute", 4);
        granularity.put("Second", 5);
    }

    public void put(int id, String timestamp) {
        records.put(id, timestamp);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        s = changeBound(s, gra, false);
        e = changeBound(e, gra, true);
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, String> entry : records.entrySet()) {
            String time = entry.getValue();
            if(time.compareTo(s) >= 0 && time.compareTo(e) < 0)
                ans.add(entry.getKey());
        }
        return ans;
    }

    private String changeBound(String origin, String gra, boolean isEndString) {
        String[] parts = origin.split(":");
        int pos = granularity.get(gra);
        for(int i = pos + 1; i < parts.length; i++) {
            parts[i] = "00";
        }
        if(isEndString) {
            int newVal = Integer.parseInt(parts[pos]) + 1;
            if (newVal < 10)
                parts[pos] = "0" + newVal;
            else
                parts[pos] = "" + newVal;
        }
        return String.join(":", parts);
    }

    public static void main(String[] args) {
        LogSystem obj = new LogSystem();
        obj.put(1,"2017:01:01:23:59:59");
        obj.put(2,"2017:01:01:22:59:59");
        obj.put(3,"2016:01:01:00:00:00");
        System.out.println(obj.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00",  "Year"));
        System.out.println(obj.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00",  "Hour"));
    }
}
