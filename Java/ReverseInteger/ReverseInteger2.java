/**
 * (45ms)
 * 这个方法和上一个方法的效率差不多，但是这不用区分正数还是负数，有一定的参考价值。
 * @author Phoenix-Z
 *
 */
public class ReverseInteger2 {

	public int reverse(int x) {
        int ans = 0;
        // Deal with both positive and negative to avoid abs
        while (x != 0) { 
            if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) {
                return 0;
            }
            //在一次迭代中同时处理拆开和聚合，很优美
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;
    }
	
}
