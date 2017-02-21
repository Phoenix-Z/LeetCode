import java.util.Arrays;
/**
 * (7ms)
 * 这道题的核心要点在于在沿某一条对角线遍历时，横纵坐标之和是一个定值。
 * @author Phoenix-Z
 *
 */
public class DiagonalTraverse {

	public static int[] findDiagonalOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return new int[]{};
		}
		int m = matrix.length, n = matrix[0].length;
		int[] ans = new int[m * n];
		int k = 0;
		for(int sum = 0; sum < m + n -1; sum++) {
			int i, j;
			if(sum % 2 == 0) {
				i = Math.min(sum, m - 1);
				j = sum - i;
				while(i >= 0 && j < n) {
					ans[k++] = matrix[i--][j++];
				}
			} else {
				j = Math.min(sum, n - 1);
				i = sum - j;
				while(i < m && j >= 0) {
					ans[k++] = matrix[i++][j--];
				}
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }};
		System.out.println(Arrays.toString(findDiagonalOrder(matrix)));
	}
}