import java.util.Arrays;
/**
 * (30ms)
 * 这个方法算是对上一个方法的优化，依然是对数组先排序，然后遍历数组，对每个数字nums[i]二分查找nums[i]+k，这样一来时间复杂度
 * 就是O(nlogn)了。
 * @author Phoenix-Z
 *
 */
public class KDiffPairsInAnArray2 {

	public static int findPairs(int[] nums, int k) {
		int count = 0;
		Arrays.sort(nums);
        if(nums == null || nums.length < 2 || nums[nums.length - 1] - nums[0] < k) {
            return count;
        }
        for(int i = 0; i < nums.length - 1; i++) {
        	if(i > 0 && nums[i] == nums[i - 1]) 
        		continue;
        	if(Arrays.binarySearch(nums, i + 1, nums.length, nums[i] + k) >= 0)
        		count++;
        }
		return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 1, 4, 1, 5};
		System.out.println(findPairs(nums, 2));
	}
	
}
