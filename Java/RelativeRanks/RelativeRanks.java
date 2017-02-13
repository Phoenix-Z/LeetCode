import java.util.Arrays;

/**
 * (14ms)
 * 这是一个O(nlogn)的算法。
 * @author Phoenix-Z
 *
 */
public class RelativeRanks {

	public static String[] findRelativeRanks(int[] nums) {
		String[] ans = new String[nums.length];
		int[] sortedNums = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sortedNums);
		for(int i = 0; i < nums.length; i++) {
			int index = Arrays.binarySearch(sortedNums, nums[i]);
			if(index == nums.length - 1) {
				ans[i] = "Gold Medal";
			} else if (index == nums.length - 2) {
				ans[i] = "Silver Medal";
			} else if(index == nums.length - 3) {
				ans[i] = "Bronze Medal";
			} else {
				ans[i] = String.valueOf(nums.length - index);
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		int[] nums = {5, 4, 3, 2, 1};
		System.out.println(Arrays.toString(findRelativeRanks(nums)));
	}
	
}
