import java.util.*;

/**
 * (8ms)
 * 这个代码就是对第一段代码的改进，通过一个Map存储中间值，从而避免了大量的重复计算。
 * Created by Phoenix-Z on 2017/4/27.
 */
public class CombinationSumIV2 {

    public int combinationSum4(int[] nums, int target) {
        int ans = helper(nums, target, new HashMap<>());
        return ans;
    }

    private int helper(int[] nums, int target, HashMap<Integer, Integer> sum) {
        if(target == 0)
            return 1;
        if(sum.containsKey(target))
            return sum.get(target);
        int now = 0;
        for(int i = 0; i < nums.length; i++) {
            if(target >= nums[i])
                now += helper(nums, target - nums[i], sum);
        }
        sum.put(target, now);
        return now;
    }

    public static void main(String[] args) {
        CombinationSumIV2 test = new CombinationSumIV2();
        System.out.println(test.combinationSum4(new int[]{1, 2, 3}, 32));
    }
}
