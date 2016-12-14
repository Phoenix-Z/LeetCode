import java.util.Arrays;

/**
 * (18ms)
 * 这个方法是利用二进制bit增长呈现一定的规律性，对于2的幂次而言，它们只有一位是1，所以这是规律的分界点。
 * 假设i = 2 ^ n + j,那么i的二进制表示中，第n位是1，而剩下的n - 1个低位遵循2 ^ (n - 1) + j的规律，
 * 所以递推公式就是count[i] = 1 + count[i - 2 ^ n];其中2 ^ n <= i < 2 ^ (n + 1).
 * 这个方法是采用java提供的数学函数来实现的，居然没有提供以2为底的log函数。。。总之效率很低。 
 * @author Phoenix-Z
 *
 */
public class CountingBits {

	public int[] countBits(int num) {
		int[] count = new int[num + 1];
		for(int i = 1; i <= num; i++) {
			count[i] = 1 + count[i - (int)Math.pow(2, (int)(Math.log(i) / Math.log(2)))];
		}
		return count;
    }
	
	public static void main(String[] args) {
		int num = 5;
		System.out.println(Arrays.toString(new CountingBits2().countBits(num)));
	}
}