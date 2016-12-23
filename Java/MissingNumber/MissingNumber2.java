import java.util.Arrays;
/**
 * (13ms)
 * 时间复杂度O(nlogn),空间复杂度O(1)
 * 这个方法也很简单，先对所有数字排序，如果nums某一位置上的数字与该位置不匹配，自然就缺少那个索引对应的数字。
 * @author Phoenix-Z
 *
 */
public class MissingNumber2 {
	
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != i)
				return i;
		}
		return nums.length;
    }
	
}