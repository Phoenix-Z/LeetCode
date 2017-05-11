/**
 * （24ms）
 * 前两个方法都是自顶向下的，这个方法是自底向上的。
 * Created by Phoenix-Z on 2017/5/10.
 */
public class PartitionEqualSubsetSum3 {

    public boolean canPartition(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
            if(dp[volumn])
                return true;
        }
        return dp[volumn];
    }

}
