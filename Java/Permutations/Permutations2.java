import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * (14ms)
 * 这是一个迭代的做法，想法独特，虽然不如递归的来的方便。但也是一个比较好的思路，参考以下链接：
 * https://discuss.leetcode.com/topic/6377/my-ac-simple-iterative-java-python-solution
 * @author Phoenix-Z
 *
 */
public class Permutations2 {

	public static List<List<Integer>> permute(int[] nums) {
	    List<List<Integer>> ans = new LinkedList<>();
	    if(nums == null || nums.length == 0)
	    	return ans;
	    ans.add(new LinkedList<>(Arrays.asList(nums[0])));
	    for(int i = 1; i < nums.length; i++) {
	    	int size = ans.size();
	    	while(0 < size--) {
	    		LinkedList<Integer> now = (LinkedList<Integer>) ans.remove(0);
	    		for(int j = 0; j <= now.size(); j++) {
	    			now.add(j, nums[i]);
	    			ans.add(new LinkedList<>(now));
	    			now.remove(j);
	    		}
	    	}
	    }
	    return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(permute(nums));
	}
}
