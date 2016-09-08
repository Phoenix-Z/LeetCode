/**
 * (22ms)
 * 方法二：
 * 打表的方法就不说了，这里提供一个有趣的做法
 * 先将num转化成二进制字符串形式，然后使用正则表达式来进行判断
 * 因为任何4的幂次的数，它的二进制形式一定是一个1后面跟上偶数个0
 * 比如：4 - 100， 16 - 10000
 * 所以有如下做法
 * @author Phoenix-Z
 *
 */
public class Solution2 {
	
	/*
	 * Any number that is a power of 4 will have 1 followed by even number of 0's
	 * in it's binary representation.
	 * Egs : 4 - 100
	 * 16 - 10000
	 */
	public boolean isPowerOfFour2(int num) {
		return Integer.toBinaryString(num).matches("1(00)*");
	}
	
}
