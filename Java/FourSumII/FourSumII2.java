import java.util.HashMap;
import java.util.Map;
/**
 * (159ms)
 * 这个方法的思路和方法一是一致的，只不过在对第二组数组进行的操作的同时就计算结果，减少了一个Map的使用，
 * 同时减少了一次迭代，效率提高了许多。
 * @author Phoenix-Z
 *
 */
public class FourSumII2 {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i] + D[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		int res = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				res += map.getOrDefault(-1 * (A[i] + B[j]), 0);
			}
		}

		return res;
	}

}
