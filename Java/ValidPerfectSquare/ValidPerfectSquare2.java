/**
 * (1ms)
 * 这个方法是一个数学的方法，如果一个数是平方数，那么它是1+3+5+7+...的和：
 * 1 = 1
 * 4 = 1 + 3
 * 9 = 1 + 3 + 5
 * 16 = 1 + 3 + 5 + 7
 * 25 = 1 + 3 + 5 + 7 + 9
 * 36 = 1 + 3 + 5 + 7 + 9 + 11
 * ...
 * so 1+3+...+(2n-1) = (2n-1 + 1)n/2 = nn
 * 时间复杂度为O(sqrt(n))
 * @author Phoenix-Z
 *
 */
public class ValidPerfectSquare2 {

	public static boolean isPerfectSquare(int num) {
		int i = 1;
		while(num > 0) {
			num -= i;
			i += 2;
		}
		return num == 0;
    }
	
}