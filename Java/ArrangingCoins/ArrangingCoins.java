/**
 * (43ms)
 * 这里使用的是等差数列的求和公式，反过来求台阶的层数，需要时刻注意int型整数的越界问题。
 * 另外下面给出了一个优化方案，等差数列求和公式是这样的：sum = (x + 1) * x / 2
 * 这可以看成是一个一元二次方程，求根x，利用求根公式，就可以求出x = (-1 + sqrt(8 * n + 1)) / 2
 * @author Phoenix-Z
 *
 */
public class ArrangingCoins {

	public int arrangeCoins(int n) {
		int ans = (int)Math.sqrt((double)n * 2);
		if(ans % 2 == 0)
		{
			if(ans / 2 * (ans + 1) > n)
			{
				return ans - 1;
			}
		} else {
			if((ans + 1) / 2 * ans > n)
			{
				return ans - 1;
			}
		}
		return ans;
		/*
		 * 以下是优化：
		 * return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
		 */
    }
	
	public static void main(String[] args) {
//		System.out.println(new ArrangingCoins().arrangeCoins(2147483647));
//		System.out.println(new ArrangingCoins().arrangeCoins(1804289383));
		System.out.println(new ArrangingCoins().arrangeCoins(8));
	}
}