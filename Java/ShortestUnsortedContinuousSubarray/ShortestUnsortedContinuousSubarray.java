import java.util.Arrays;

/**
 * (36ms)
 * 这个解法很简单，就是clone出一个新数组，然后对其排序，然后对比nums和排序好的数组即可。
 * 时间复杂度为O(nlogn)，空间复杂度为O(n)
 * Created by Phoenix-Z on 2017/5/14.
 */
public class ShortestUnsortedContinuousSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int left = 0, right = nums.length - 1;
        while(left < nums.length) {
            if(nums[left] != sortedNums[left])
                break;
            left++;
        }
        while(right >= 0) {
            if(nums[right] != sortedNums[right])
                break;
            right--;
        }
        if(left < right)
            return right - left + 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(findUnsortedSubarray(nums));
    }

}
