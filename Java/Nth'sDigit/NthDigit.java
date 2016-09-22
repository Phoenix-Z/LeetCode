/**
 * (5ms)
 * 这道题可以想做是一个分段函数，写出函数表达式，问题就不大了。
 * 对于1~9:长度为1，共9个数
 * 	  10~99：长度为2，共90个数
 * 	  100~999：长度为3，共900个数
 * 需要注意的是，当长度大于9时，就应该另行处理了，否则会超出整数范围
 * @author Phoenix-Z
 *
 */
public class NthDigit {
	
	public int findNthDigit(int n) {
		//digit初始值为负数，是为了后续判断n是否为超过9位长的数字
		int digit = -1;
		//now是表示长度为i的序列的序号范围
		int now = 1;
		//len是上述范围的长度
		int len = 0;
		for(int i = 0; i < 8; i++)
		{
			len = 9 * (int) Math.pow(10, i) * (i + 1);
			if(now <= n && n < now + len)
			{
				int diff = n - now;
				int num = (int)Math.pow(10, i) + diff / (i + 1);
				digit = (int)(Integer.toString(num).charAt(diff % (i + 1)) - '0');
				break;
			}
			now = now + len;
		}
		//处理长度超过9的数据
		if(digit < 0)
		{
			int diff = n - now;
			int num = (int)Math.pow(10, 8) + diff / (8 + 1);
			digit = (int)(Integer.toString(num).charAt(diff % (8 + 1)) - '0');
		}
		return digit;
    }

	public static void main(String[] args) {
		System.out.println(new NthDigit().findNthDigit(1000000000));
	}
	
}