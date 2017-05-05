/**
 * (超时)
 * 这段代码就是最简单的递归做法，容易理解，但是很多中间值重复计算了。
 * Created by Phoenix-Z on 2017/5/5.
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationSum4(nums, target - nums[i]);
            }
        }
        return res;
    }

}
