/**
 * (0ms)
 * 这就是一道排列组合的题目。当n等于0时，只有0是可行解，即f(0)=1,当n=1时，除了0之外我们可以从9个数字中
 * 选一个，为了一致性，也可以这么理解，选择除0外的9个数字充当第一位，那么还需要在除这个数字之外的所有数字
 * （包括0）选取0个数字，即C(9,0)。当n=i时，2<=i>=10选择除0外的9个数字充当第一位，那么还需要在除这个数字
 * 之外的9个数字（包括0）选取i - 1个数字，即C(9,i-1)。再对这i-1个数字进行全排列，然后累加求和即可。
 * 这里提前将求二项式和全排列的结果计算出来，并放置到数组中。
 * 当n大于10时，返回的值总是和n等于10的时候的结果一致。
 * @author Phoenix-Z
 *
 */
public class CountNumbersWithUniqueDigits {

	//C(9, i)  i = 0, 1, 2, ..., 9
	private static int[] C = {1, 9, 36, 84, 126, 126, 84, 36, 9, 1};
	//A(i, i) i = 0, 1, 2, ... ,9
	private static int[] A = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	
	public static int countNumbersWithUniqueDigits(int n) {
		int total = 1;
		for(int i = 0; i < n && i < 10; i++) {
			total += C[i] * A[i] * 9;
		}
		return total;
    }
	
	public static void main(String[] args) {
		System.out.println(countNumbersWithUniqueDigits(3));
	}
}