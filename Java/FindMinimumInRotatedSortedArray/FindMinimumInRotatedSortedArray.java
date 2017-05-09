/**
 * (1ms)
 * 时间复杂度为O(log n)
 * Created by Phoenix-Z on 2017/5/8.
 */
public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int leftMost = nums[0], rightMost = nums[nums.length - 1];
        // 就是升序序列，直接返回第一个元素即可
        if(leftMost < rightMost)
            return leftMost;
        // 如果不是升序序列，那么最小值一定是从第二个数字和最后一个数字之间任一个数字
        int left = 1, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < rightMost) {
                right = mid;
            }
            if(nums[mid] > leftMost) {
                left = mid + 1;
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0};
        System.out.println(findMin(nums));
    }
}
