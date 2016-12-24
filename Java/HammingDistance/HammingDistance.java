/**
 * (17ms)
 * 求汉明距离首先考虑就是使用异或操作，至于统计有多少个bit是1，可以选择使用移位操作迭代32次，但是这里
 * 使用java内置API——bitcount方法，代码会更加简洁些。
 * @author Phoenix-Z
 *
 */
public class HammingDistance {

	public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
	
}