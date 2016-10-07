/**
 * (0ms)
 * 这个方法没有使用额外的空间，突破口就在于从后往前填入数组元素。
 * @author Phoenix-Z
 *
 */
public class MergeTwoSortedArray2 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		/*
		 * i : 表示指向原始的nums1数组
		 * j : 表示指向原始的nums2数组
		 * k ： 表示指向合并后的nums1数组
		 */
		int i=m-1, j=n-1, k=m+n-1;
		
		while (i>-1 && j>-1) {
			nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
		}
		
		while (j>-1) {
			nums1[k--] = nums2[j--];
		}
    }
	
}