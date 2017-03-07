import java.util.Arrays;
/**
 * (133ms)
 * 这个方法是先对数组排序，然后在遍历排序后的数组，找到使得差等于k的一对数字，从时间复杂度来看，应该是O(n^2)的算法。
 * @author Phoenix-Z
 *
 */
public class KDiffPairsInAnArray {

	public static int findPairs(int[] nums, int k) {
		int count = 0;
		Arrays.sort(nums);
        if(nums == null || nums.length < 2 || nums[nums.length - 1] - nums[0] < k) {
            return count;
        }
		int now = nums[0];
		int i = 1;
		while(i < nums.length) {
			if(nums[i] - now == k) {
				count++;
				break;
			}
			i++;
		}
		for(i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i - 1]) 
				continue;
			int j = i + 1;
			while(j < nums.length) {
				if(nums[j] - nums[i] == k) {
					count++;
					break;
				}
				j++;
			}
		}
		return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 3, 1, 5, 4};
		System.out.println(findPairs(nums, 0));
	}
}
