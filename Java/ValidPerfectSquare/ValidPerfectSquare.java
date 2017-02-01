/**
 * (0ms)
 * 这道题目就是实现一下sqrt函数。
 * @author Phoenix-Z
 *
 */
public class ValidPerfectSquare {

	public static boolean isPerfectSquare(int num) {
		long val = num;
		while(val * val > num) {
			val = (val + num / val) / 2;
		}
		return val * val == num;
    }
	
	public static void main(String[] args) {
		int[] nums = {16, 14, 25};
		for(int num : nums) {
			System.out.println(isPerfectSquare(num));
		}
	}
}