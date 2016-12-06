/**
 * (47ms)
 * 这道题目很磨人，首先需要先确定什么输入合法，应该返回什么值。
 * 首先要将str最前面的空格符删除，这个可以使用trim方法来实现，而字符串中间的空格符视为非法输入。
 * 其次可以使用"-"和"+"来表示整数的正负，没有这两个符号视为正数，但是这两个符号只能出现其中的一个，
 * 且只能出现一次，否则视为不合法的输入。
 * 接着尝试在"-"和"+"后找到尽可能多的数字，一旦遇到空格或者字母，就停止找后面的数字。然后将找到的这一串
 * 数字转换成整数即可。
 * 如果不能转换，就返回0，如果可以转换，但是超过了整型的范围，就返回int的最大值或者最小值，
 * 如果既可以转换，也在整型的范围之内，就返回该数字。
 * @author Phoenix-Z
 *
 */
public class StringToInteger {

	public int myAtoi(String str) {
		//sign表示字符串表示的是正数还是负数
		int sign = 0;
		//删除字符串前后的空格符
		str = str.trim();
		//sb用来获取最终需要进行转换的数字串
		StringBuilder sb = new StringBuilder();
		for(char c : str.toCharArray()) {
			if(c == '-') {
				//防止正负号出现两次以上
				if(sign != 0)
					return 0;
				sign = -1;
				continue;
			}
			if(c == '+') {
				if(sign != 0)
					return 0;
				sign = 1;
				continue;
			}
			if(c > '9' || c < '0' || c == ' ')
				break;
			//如果没有符号，就默认为正号
			if(sign == 0)
			    sign = 1;
			sb.append(c);
		}
		str = sb.toString();
		//如果str只剩空串了，就不能进行转换
		if(str.length() == 0)
			return 0;
		
		if(sign == 1) {
			//如果str表示的数字超过了整型的范围，且是正数，就返回int的最大值
			if(str.length() > 10 || (str.length() == 10 
					&& str.compareTo(Integer.toString(Integer.MAX_VALUE)) >= 0))
				return Integer.MAX_VALUE;
		} else if(sign == -1) {
			//如果str表示的数字超过了整型的范围，且是负数，就返回int的最小值
			if(str.length() > 10 || (str.length() == 10 
					&& str.compareTo(Integer.toString(Integer.MIN_VALUE).substring(1)) >= 0))
				return Integer.MIN_VALUE;
		}
		//正常转换
		return Integer.parseInt(str) * sign;
    }
	
	public static void main(String[] args) {
		String str = "-1";
		System.out.println(new StringToInteger().myAtoi(str));
	}
}