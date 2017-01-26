/**
 * (2ms)
 * 这里使用的是二分法，先测试给定值的一半是否是平方根，如果这个数比预计的平方根大，就在这个数的左侧继续二分
 * 搜索，反之则在右侧进行二分搜索，直至找到平方根。
 * @author Phoenix-Z
 *
 */
public class SqrtMethod2 {

	public static int mySqrt(int x) {
		if(x == 0 || x == 1) {
			return x;
		}
		int left = 0, right = x;
		int ans = left + (right - left) / 2;
		// 这里为了防止溢出，没有采用ans * ans < x来进行判断
		while(ans > x / ans || (ans + 1) <= x / (ans + 1)) {
			if(ans > x / ans) {
				right = ans - 1;
			} else {
				left = ans + 1;
			}
			ans = left + (right - left) / 2;
		}
		return ans;
    }
	
	public static void main(String[] args) {
		int[] nums = {2147395599, 0, 1, 2, 5, 9};
		for (int x : nums) {
			System.out.println(mySqrt(x));
		}
	}
}