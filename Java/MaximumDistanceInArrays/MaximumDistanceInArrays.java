/**
 * (13ms)
 * Created by Phoenix-Z on 2017/6/18.
 */
public class MaximumDistanceInArrays {

    public static int maxDistance(int[][] arrays) {
        int[][] mins = {{Integer.MAX_VALUE, -1}, {Integer.MAX_VALUE, -1}}, 
                maxs = {{Integer.MIN_VALUE, -1}, {Integer.MAX_VALUE, -1}};
        for (int i = 0; i < arrays.length; i++) {
            if(arrays[i][0] < mins[0][0]) {
                mins[1][0] = mins[0][0];
                mins[1][1] = mins[0][1];
                mins[0][0] = arrays[i][0];
                mins[0][1] = i;
            } else if(arrays[i][0] < mins[1][0]) {
                mins[1][0] = arrays[i][0];
                mins[1][1] = i;
            }
            int last = arrays[i].length - 1;
            if(arrays[i][last] > maxs[0][0]) {
                maxs[1][0] = maxs[0][0];
                maxs[1][1] = maxs[0][1];
                maxs[0][0] = arrays[i][last];
                maxs[0][1] = i;
            } else if(arrays[i][last] > maxs[1][0]) {
                maxs[1][0] = arrays[i][last];
                maxs[1][1] = i;
            }
        }
        if(mins[0][1] == maxs[0][1]) {
            return Math.max(maxs[0][0] - mins[1][0], maxs[1][0] - mins[0][0]);
        } else {
            return maxs[0][0] - mins[0][0];
        }
    }

    public static void main(String[] args) {
        int[][] arrays = {{1, 5}, {3, 4}};
        System.out.println(maxDistance(arrays));
    }
}
