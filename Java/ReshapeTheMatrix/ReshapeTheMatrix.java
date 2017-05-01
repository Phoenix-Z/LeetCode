/**
 * (9ms)
 * Created by Phoenix-Z on 2017/5/1.
 */
public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length * nums[0].length != r *c)
            return nums;
        int[][] reshaped = new int[r][c];
        int i = 0, j = 0;
        for(int k = 0; k < r; k++) {
            for(int l = 0; l < c; l++) {
                reshaped[k][l] = nums[i][j];
                if(++j == nums[0].length) {
                    i++;
                    j = 0;
                }
            }
        }
        return reshaped;
    }

}
