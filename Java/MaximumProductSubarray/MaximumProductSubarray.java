/**
 * (4ms)
 * 这个题目本质上与最大连续子数组和相似，不同在于需要维护一个最小值，一旦遇到负数，就有可能逆转。
 * Created by Phoenix-Z on 2017/6/25.
 */
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int nowMax = nums[0], nowMin = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                int tmp = nowMax;
                nowMax = nowMin;
                nowMin = tmp;
            }
            nowMax = Math.max(nowMax * nums[i], nums[i]);
            nowMin = Math.min(nowMin * nums[i], nums[i]);
            max = Math.max(nowMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2};
        System.out.println(maxProduct(nums));
    }

}
