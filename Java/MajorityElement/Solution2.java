import java.util.Arrays;

/**
 * (4ms)
 * 方法二：
 * 这个方法是先将数组排序，然后考虑到如果一个元素出现了[n/2]次以上，
 * 那么它在排序后的数组nums.length/2的位置上一定有这个数字。
 * 所以整个的时间复杂度为O(nlogn)(排序的时间复杂度)
 * @author Phoenix-Z
 *
 */
public class Solution2 {

	public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
	
}