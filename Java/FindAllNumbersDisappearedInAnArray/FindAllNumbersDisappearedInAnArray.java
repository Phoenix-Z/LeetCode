import java.util.ArrayList;
import java.util.List;
/**
 * (13ms)
 * 这个方法是很容易理解的，就是使用了一个boolean型的数组来标记数字是否出现过，时间复杂度是O(n)，空间复杂度
 * 也是O(n)。
 * @author Phoenix-Z
 *
 */
public class FindAllNumbersDisappearedInAnArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		boolean[] exist = new boolean[nums.length + 1];
		for(int num : nums) {
			exist[num] = true;
		}
		for(int i = 1; i <= nums.length; i++) {
			if(!exist[i])
				ans.add(i);
		}
		return ans;
    }
	
}