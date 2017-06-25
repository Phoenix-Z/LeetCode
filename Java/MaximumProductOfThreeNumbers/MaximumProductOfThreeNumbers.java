import java.util.Arrays;

/**
 * (38ms)
 * 这个方法的时间复杂度为O(nlogn)。
 * Created by Phoenix-Z on 2017/6/25.
 */
public class MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int indexOfFirstPositiveNum = 0;
        int len = nums.length;
        while (indexOfFirstPositiveNum < len && nums[indexOfFirstPositiveNum] < 0) {
            indexOfFirstPositiveNum++;
        }
        int product = nums[len - 1] * nums[len -2] * nums[len - 3];
        if(indexOfFirstPositiveNum >= 2 && indexOfFirstPositiveNum < len) {
            product = Math.max(product, nums[0] * nums[1] * nums[len - 1]);
        }
        return product;
    }

}
