import java.util.HashMap;
import java.util.Map;
/**
 * (345ms)
 * 这个方法的思路很朴素，就是将四个数组分成两组，然后分别对两组数组进行以下操作：迭代两个数组中的数字，将两个
 * 数字的和放到一个Map中，键是两个数字的和，由于不需要记录具体位置，所以值就可以设置为和为键的位置的个数，
 * 最后计算结果即可。
 * @author Phoenix-Z
 *
 */
public class FourSumII {

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> AB = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
        	for(int j = 0; j < B.length; j++) {
        		int sum = A[i] + B[j];
        		AB.put(sum, AB.getOrDefault(sum, 0) + 1);
        	}
        }
        Map<Integer, Integer> CD = new HashMap<>();
        for(int i = 0; i < C.length; i++) {
        	for(int j = 0; j < D.length; j++) {
        		int sum = C[i] + D[j];
        		CD.put(sum, CD.getOrDefault(sum, 0) + 1);
        	}
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : AB.entrySet()) {
        	count += entry.getValue() * CD.getOrDefault(-entry.getKey(), 0);
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[] A = { 1, 2};
		int[] B = {-2,-1};
		int[] C = {-1, 2};
		int[] D = { 0, 2};
		System.out.println(fourSumCount(A, B, C, D));
	}
}
