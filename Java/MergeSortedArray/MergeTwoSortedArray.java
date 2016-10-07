import java.util.ArrayList;
import java.util.List;

/**
 * (2ms)
 * 借助一个ArrayList来合并两个有序数组。
 * @author Phoenix-Z
 *
 */
public class MergeTwoSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		List<Integer> list = new ArrayList<>(m + n);
		int i = 0, j = 0;
		while(i < m && j < n)
		{
			if(nums1[i] < nums2[j]) {
				list.add(nums1[i++]);
			}
			else {
				list.add(nums2[j++]);
			}
		}
		while (i < m) {
			list.add(nums1[i++]);
		}
		while (j < n) {
			list.add(nums2[j++]);
		}
		i = 0;
		for(Integer num : list)
		{
			nums1[i++] = num;
		}
	}
	
}