import java.util.Arrays;
/**
 * (6ms)
 * 这就是一个二分搜索的问题。
 * @author Phoenix-Z
 *
 */
public class SearchInsertPosition {

	public static int searchInsert(int[] nums, int target) {
		int index = Arrays.binarySearch(nums, target);
		if(index < 0) 
			return ~index;
		return index;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int[] targets = {5,2,7,0};
		for(int target : targets) {
			System.out.println(searchInsert(nums, target));
		}
	}
}