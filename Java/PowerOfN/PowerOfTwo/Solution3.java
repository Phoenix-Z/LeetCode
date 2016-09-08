/**
 * (2ms)
 * 方法三：
 * 这种方法也效率极高，同时具有一定的扩展性，对于质数的幂次的判断很有效。
 * 基本思路是：
 * (1)在int数值范围内找到N的最高幂次,对于2而言，int范围是[-2^31,2^31-1]，
 * 所以最大为2^30;
 * (2)一个事实：2^30 % 2 ^ i == 0(i = 0, 1, 2, ..., 30)
 * 所以可以写出以下的判断语句(以下的使用的2^31,基本原理是一致的)
 * @author Phoenix-Z
 *
 */
public class Solution3 {
	public boolean isPowerOfTwo(int n) {
		long max = Integer.MAX_VALUE + 1;
		return (n > 0) && (max % n == 0);
	}
//	public static void main(String[] args) {
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println((int)Math.pow(2,31));
//	}
}