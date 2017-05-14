/**
 * (31ms)
 * 这个解法很精妙，这里用了beg和end两个变量来表示需要排序的子数组，即nums[beg, end]。如果beg和end都小于0，则表示原数组已经有序。
 * 时间复杂度为O(n)，空间复杂度为O(1)
 * Created by Phoenix-Z on 2017/5/14.
 */
public class ShortestUnsortedContinuousSubarray2 {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, beg = -1, end = -2, min = nums[n - 1], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            if (nums[i] < max)
                end = i;
            if (nums[n - 1 - i] > min)
                beg = n - 1 - i;
        }
        return end - beg + 1;
    }

}
