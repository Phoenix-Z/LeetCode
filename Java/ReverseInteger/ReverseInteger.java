/**
 * (38ms)
 * 这个解法就是先逐个的获取每一位上的数字，然后再充组成翻转的数字。
 * 需要注意的是有些数字一开始在int范围之内，但是翻转之后就不在int范围之内了，直接返回0。
 * @author Phoenix-Z
 *
 */
public class ReverseInteger {

	public int reverse(int x) {
		//对于int最小值而言，一旦将其乘以-1，就会越界，所以特殊处理
		if(x == Integer.MIN_VALUE)
            return 0;
		//digits存在整数每一位上的数字
        int[] digits = new int[10];
        //sign表示x是正是负
        int sign = x < 0 ? -1 : 1;
        x *= sign;
        int len = 0;
        //取得整数每一位上的数字
        while(x > 0)
        {
        	digits[len++] = x % 10;
        	x = x / 10;
        }
        //翻转数字
        for(int i = len - 1; i >= 0; i--)
        {
        	//判断数字是否越界，一旦越界直接返回0
        	if(len == 10 && Integer.MAX_VALUE - 2 * (int)Math.pow(10, 9) < x )
        	{
        		return 0;
        	}
        	x += digits[i] * (int)Math.pow(10, len - i - 1);
        }
        
        return x * sign;
     }
	
	public static void main(String[] args) {
		int[] nums = {123, -321, Integer.MIN_VALUE, Integer.MAX_VALUE};
		ReverseInteger test = new ReverseInteger();
		for(int num : nums)
		{
			System.out.println(test.reverse(num));
		}
	}
	
}
