import java.util.ArrayList;
import java.util.List;
/**
 * (17ms)
 * 这个方法的基本思想同方法一是一致的，即在第一次遍历数组时，标记已经出现的数字，这里采用的是将原始值变为负值
 * 的方式，这样的好处就是可以省去开boolean数组所消耗的空间。在第二次遍历数组时，如果发现数组位置的值是正数，
 * 就意味着该位置所对应的索引没有出现，添加进结果集中即可。
 * @author Phoenix-Z
 *
 */
public class FindAllNumbersDisappearedInAnArray2 {

	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
        	int index = Math.abs(nums[i]) - 1;
        	if(nums[index] > 0)
        	    nums[index] *= -1;
		}
        
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] > 0)
        		ans.add(i + 1);
        }
		return ans;
    }
	
}