/**
 * (1ms)
 * 这个方法是从另一个角度来看的，要找到第k小的元素，可以二分地搜索一个值，如果比这个值小的有k-1个，且这个值
 * 在矩阵中，那么这个数就是我们要找的第k小的元素。这个算法效率很高，思路也很新颖。
 * @author Phoenix-Z
 *
 */
public class KthSmallestElementInASortedMatrix2 {

	public int kthSmallest(int[][] matrix, int k) {
		// [lo, hi)
		int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int count = 0, j = matrix[0].length - 1;
			for (int i = 0; i < matrix.length; i++) {
				while (j >= 0 && matrix[i][j] > mid)
					j--;
				count += (j + 1);
			}
			if (count < k)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,  5,  9},
				   {10, 11, 13},
				   {12, 13, 15}};
		KthSmallestElementInASortedMatrix2 test = new KthSmallestElementInASortedMatrix2();
		System.out.println(test.kthSmallest(matrix, 2));
	}
}