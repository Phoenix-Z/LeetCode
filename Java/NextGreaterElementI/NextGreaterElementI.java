import java.util.Arrays;
/**
 * (11ms)
 * 这就是一个O(n*m)的算法。
 * @author Phoenix-Z
 *
 */
public class NextGreaterElementI {

	public static int[] nextGreaterElement(int[] findNums, int[] nums) {
		int[] greater = new int[findNums.length];
		for(int i = 0; i < findNums.length; i++) {
			int j = 0;
			while(nums[j] != findNums[i]) {
				j++;
			}
			for(j = j + 1; j < nums.length; j++) {
				if(nums[j] > findNums[i]) {
					greater[i] = nums[j];
					break;
				}
			}
			if(j == nums.length) {
				greater[i] = -1;
			}
		}
		return greater;
    }

	public static void main(String[] args) {
		int[] findNums = {4, 1, 2};
		int[] nums = {1, 3, 4, 2};
		System.out.println(Arrays.toString(nextGreaterElement(findNums, nums)));
	}
	
}
