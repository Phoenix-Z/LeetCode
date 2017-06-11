import java.util.Random;

/**
 * (307ms)
 * 蓄水池算法
 * Created by Phoenix-Z on 2017/6/10.
 */
public class RandomPickIndex {

    private int[] nums;
    private Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int ans = -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                if(random.nextInt(++count) == 0)
                    ans = i;
            }
        }
        return ans;
    }

}
