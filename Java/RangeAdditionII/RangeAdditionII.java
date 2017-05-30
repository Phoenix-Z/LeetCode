/**
 * (7ms)
 * Created by Phoenix-Z on 2017/5/29.
 */
public class RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops) {
        int minLen = m, minWidth = n;
        for (int i = 0; i < ops.length; i++) {
            if(ops[i][0] < minLen) {
                minLen = ops[i][0];
            }
            if(ops[i][1] < minWidth) {
                minWidth = ops[i][1];
            }
        }
        return minLen * minWidth;
    }

}
