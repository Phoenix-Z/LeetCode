/**
 * (2ms)
 * 关于sqrt函数，可以参考博客 ： http://diducoder.com/sotry-about-sqrt.html
 * 这里使用的是牛顿法，求出根号x的近似值：首先随便猜一个近似值val，然后不断令val等于val和x/val的平均数，
 * 迭代个六七次后val的值就已经相当精确了。
 * @author Phoenix-Z
 *
 */
public class SqrtMethod3 {

	public static int mySqrt(int x) {
		if(x == 0 || x == 1) {
			return x;
		}
		int val = x - 1;
		while(val > x / val || (val + 1) <= x / (val + 1)) {
			val = (val + x / val) / 2;
		}
		return val;
    }
	
	public static void main(String[] args) {
		int[] nums = {2147483647, 0, 1, 2, 5, 9};
		for (int x : nums) {
			System.out.println(mySqrt(x));
		}
	}
}