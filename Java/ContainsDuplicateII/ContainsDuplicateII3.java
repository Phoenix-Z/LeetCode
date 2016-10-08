import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * (2ms)
 * 很神奇的是这是一个O(n^2)的算法，然而前两个算法看上去是O(n)的算法，但是效率却不如这个方法高，
 * 看来Java自己提供的方法效率并不高。
 * @author Phoenix-Z
 *
 */
public class ContainsDuplicateII3 {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		//将原始数组复制出来进行排序
        int[] sorted = nums.clone();  //int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        
        //duplicate存储重复出现的数字
        List<Integer> duplicate = new ArrayList<>();
        for (int i = 0; i < sorted.length - 1; i++) {
        	if (sorted[i] == sorted[i + 1] && !duplicate.contains(sorted[i])) {
        		duplicate.add(sorted[i]);
        	}
        }

        //查找是否存在间距小于k的两个相等的元素
        for (int v : duplicate) {
        	//pre表示v上一次出现的位置
        	int pre = -1;
        	//找出v第一次出现的位置
        	for (int i = 0; i < nums.length; i++) {
        		if (nums[i] == v) {
        			pre = i;
        			break;
        		}	
        	}
        	for (int i = pre + 1; i < nums.length; i++) {
        		if (nums[i] == v) {
        			if (i - pre<= k) {
        				return true;
        			}
        			//如果相同的两个数字间距大于k，就更新上一次出现的位置
        			pre = i;
        		}
        	}
        }
        return false;
    }

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 6, 5, 4, 3, 2, 3};
		System.out.println(new ContainsDuplicateII3().containsNearbyDuplicate(nums, 2));
	}
}