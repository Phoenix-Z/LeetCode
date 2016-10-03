/**
 * (1ms)
 * 这个方法原创，首先判断n是奇数还是偶数，如果是奇数，那么1步的次数就应该是奇数
 * 如果是偶数，那么1步的次数应该是偶数。对于每个n，可以统计1的个数和2的个数，
 * 然后求排列组合就可以了。
 * 比如说对n=5来说，1的个数只能为1, 3, 5,然后分类讨论，最后将结果相加即可。
 * 当1的个数为1时，2的个数为2，那么排列的方式有C(3, 1) = 3，
 * 当1的个数为3时，2的个数为1，那么排列的方式有C(4, 1) = 4，
 * 当1的个数为5时，2的个数为0，那么排列的方式有C(5, 0) = 1，
 * 所以总共有8种。
 * 所以最后的问题归结于求C(n, k)(k <= n)
 * @author Phoenix-Z
 *
 */
public class ClimbingStairs {

	public int climbStairs(int n) {
		int ways = 0;
		int i = 0;
		while(i <= n / 2){
			//这里需要判断n是奇数还是偶数
			int numOfOne = (n % 2 == 0) ? 2 * i : 2 * i + 1;
			int numOfTwo = (n - numOfOne) / 2;
			ways += getBinary(numOfOne + numOfTwo, Math.min(numOfOne, numOfTwo));
			i++;
		}
		return ways;
	}
	//用于求解C(n, k)的方法
	public int getBinary(int n, int k)
	{
		int mum = 1;
		int son = 1;
		for(int i = k; i > 0; i--)
		{
			son *= (n + i - k);
			mum *= i;
			//由于乘法很容易就超过int的范围，所以每乘一次，都进行一次约分
			//gcd方法是用来求分母和分子的最大公约数，然后进行约分
			int gcd = gcd(son, mum);
			son /= gcd;
			mum /= gcd;
		}
		return son / mum;
	}
	//使用辗转相除法求最大公约数
	public int gcd(int a, int b)
	{
		if (b != 0) 
			return gcd(b, a % b); 
		else 
			return a; 
	}
	
	public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs(44));
	}
}