/**
 * 超时
 * 这个方法虽然超时了，但是我依然觉得有些地方很有趣。这个方法的时间复杂度是O(n)，
 * 就是实现了一个阶乘。但是为了防止数字超过整型的范围，需要在超过某一个阈值的时候，只保留最后的几位
 * 至于这个阈值应该多大，不得而知，而且，当n非常大的时候，依然存在越界的危险，所以不推荐使用这个方法
 * @author Phoenix-Z
 *
 */
public class TrailingZeroes {

	public int trailingZeroes(int n) {
		int count = 0;
		int product = 1;
		for(int i = 2; i <= n; i++)
		{
			product *= i;
			while(product > 10 && product % 10 == 0)
			{
				count++;
				product /= 10;
			}
			product %= 100000;
		}
        return count;
    }
	
	public static void main(String[] args) {
		System.out.println(new TrailingZeroes().trailingZeroes(100));
	}
}
