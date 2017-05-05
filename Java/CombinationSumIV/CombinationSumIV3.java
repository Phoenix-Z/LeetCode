import java.util.Arrays;

/**
 * (1ms)
 * 这里是用数组来代替Map，从而在效率上有所改进。
 * Created by Phoenix-Z on 2017/5/5.
 */
public class CombinationSumIV3 {

    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        if(dp == null) {
            dp = new int[target + 1];
            Arrays.fill(dp, -1);
            dp[0] = 1;
        }
        if(dp[target] != -1)
            return dp[target];
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(target >= nums[i])
                ans += combinationSum4(nums, target - nums[i]);
        }
        dp[target] = ans;
        return ans;
    }

}
