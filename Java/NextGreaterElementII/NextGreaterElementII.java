import java.util.Arrays;
/**
 * (超时)
 * 该算法的时间复杂度为O(n^2).
 * @author Phoenix-Z
 *
 */
public class NextGreaterElementII {

	public static int[] nextGreaterElements(int[] nums) {
		int[] ans = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			int j = (i + 1) % nums.length;
			while(true) {
				if(nums[j] > nums[i]) {
					ans[i] = nums[j];
					break;
				}
				if(j == i) {
					ans[i] = -1;
					break;
				}
				j = (j + 1) % nums.length;
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		int[] nums = {5, 4, 3, 2, 1};
		System.out.println(Arrays.toString(nextGreaterElements(nums)));
	}
}
