/**
 * (17ms)
 * Created by Phoenix-Z on 2017/6/18.
 */
public class MaximumDistanceInArrays2 {

    public static int maxDistance(int[][] arrays) {
        int res = 0;
        int min = arrays[0][0], max = arrays[0][arrays.length - 1];
        for(int i = 1; i < arrays.length; i++) {
            res = Math.max(res, Math.max(max - arrays[i][0], arrays[i][arrays[i].length - 1] - min));
            min = Math.min(min, arrays[i][0]);
            max = Math.max(max, arrays[i][arrays[i].length - 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1, 5}, {3, 4}};
        System.out.println(maxDistance(arrays));
    }
}
