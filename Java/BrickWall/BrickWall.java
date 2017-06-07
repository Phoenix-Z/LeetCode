import java.util.*;

/**
 * (33ms)
 * Created by Phoenix-Z on 2017/6/7.
 */
public class BrickWall {

    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> count = new HashMap<>();
        for(List<Integer> row : wall) {
            int now = 0;
            for(int i = 0; i < row.size() - 1; i++) {
                now += row.get(i);
                count.put(now, count.getOrDefault(now, 0) + 1);
            }
        }
        int maxAppear = 0;
        for(int value : count.values()) {
            if(value > maxAppear)
                maxAppear = value;
        }
        return wall.size() - maxAppear;
    }

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        Integer[][] widths = {{1,2,2,1}, {3,1,2}, {1,3,2}, {2,4}, {3,1,2}, {1,3,1,1}};
        for(int i = 0; i < widths.length; i++) {
            wall.add(new ArrayList<>(Arrays.asList(widths[i])));
        }
        System.out.println(leastBricks(wall));
    }
}
