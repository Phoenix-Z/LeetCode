import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * (51ms)
 * 这个方法非常简单粗暴，先把矩阵中的数组全部添加到一个list中，然后对它重新排序，最后返回第k个小的元素即可。
 * 空间复杂度是O(n^2),而添加元素的时间复杂度是O(n^2),排序的时间复杂度为O(n^2logn),所以最后的时间复杂度
 * 是O(n^2logn)。
 * @author Phoenix-Z
 *
 */
public class KthSmallestElementInASortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {
		List<Integer> nums = new ArrayList<>();
		for(int[] rows : matrix) {
			for(int num : rows) {
				nums.add(num);
			}
		}
		Collections.sort(nums);
		return nums.get(k - 1);
    }
	
}