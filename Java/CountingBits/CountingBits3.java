/**
 * (2ms)
 * 这个方法更加直接，它先右移一位，就可以像n-1位有效位一样处理，再加上右移出去的那一位是0或者1，
 * 就是最后的答案，使用位运算，效率也有所提升。
 * @author Phoenix-Z
 *
 */
public class CountingBits3 {

	public int[] countBits(int num) {
		int[] count = new int[num + 1];
		for (int i = 1; i <= num; i++)
			count[i] = count[i >> 1] + (i & 1);
		return count;
	}

}