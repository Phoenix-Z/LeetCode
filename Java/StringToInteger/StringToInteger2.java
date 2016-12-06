/**
 * (39ms)
 * 思路基本上一致的，不过用了较少的java原生API，所以在效率上稍微高了点
 * @author Phoenix-Z
 *
 */
public class StringToInteger2 {

	public int myAtoi(String str) {
		int index = 0, sign = 1, total = 0;
		// 1. 如果是空串，直接返回0
		if (str.length() == 0)
			return 0;

		// 2. 删除str前面多余的空格符
		while (str.charAt(index) == ' ' && index < str.length())
			index++;

		// 3. 判断是正数还是负数
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			sign = str.charAt(index) == '+' ? 1 : -1;
			index++;
		}

		// 4. 转换数字并防止溢出
		while (index < str.length()) {
			int digit = str.charAt(index) - '0';
			if (digit < 0 || digit > 9)
				break;

			// 检查total有没有可能在10次之后出现溢出，并加上digits，如果溢出，就返回int的最值
			if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total 
					&& Integer.MAX_VALUE % 10 < digit)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

			total = 10 * total + digit;
			index++;
		}
		return total * sign;
	}

}