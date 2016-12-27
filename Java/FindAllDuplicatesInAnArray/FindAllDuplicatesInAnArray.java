import java.util.ArrayList;
import java.util.List;
/**
 * (15ms)
 * 这道题目与ex448. Find All Numbers Disappeared in an Array很像，这里是要求找出出现两次的数字，
 * 采用同样的标记方式，即出现过一次的数字对应位置的数字变成负数，如果遇到是负数的位置，那么该位置对应的数字
 * 一定出现过一次，本次发现就是第二次，所以直接将该位置对应的数字添加进结果集中即可。
 * 时间复杂度为O(n),空间复杂度为O(1)。
 * @author Phoenix-Z
 *
 */
public class FindAllDuplicatesInAnArray {

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if(nums[index] < 0) {
				ans.add(index + 1);
			}
			nums[index] *= -1;
		}
		return ans;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 1};
		System.out.println(new FindAllDuplicatesInAnArray().findDuplicates(nums));
	}
}