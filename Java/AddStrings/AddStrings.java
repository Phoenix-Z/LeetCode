/**
 * (27ms)
 * 大数加法，这里只需要实现两个正数相加。
 * @author Phoenix-Z
 *
 */
public class AddStrings {

	public String addStrings(String num1, String num2) {
		//ans用来保存结果
        StringBuilder ans = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        //addOne用来标记是否需要进位
        boolean addOne = false;
        //从两个字符串的末尾开始相加
        while(i >= 0 && j >= 0)
        {
        	//需要注意的是获取到字符后，转为int时需要减去'0'
        	int digit1 = num1.charAt(i--) - '0', digit2 = num2.charAt(j--) - '0';
        	//当两个一位数相加大于10时
        	if(digit1 + digit2 >= 10)
        	{
        		//有低位的进位
        		if(addOne)
        		{
        			ans.append(Integer.toString(digit1 + digit2 - 10 + 1));
        		} else { //没有低位的进位
        			ans.append(Integer.toString(digit1 + digit2 - 10));
        		}
        		//标记有进位
        		addOne = true;
        	} else if(digit1 + digit2 == 9 && addOne) {
        		//两个一位相加等于9时，如果有进位，就会变为10，又会产生进位
        		ans.append('0');
        		addOne = true;
        	} else if (addOne) {
        		//有来自低位的进位，但是两个一位数相加小于9，就不会产生新的进位
				ans.append(Integer.toString(digit1 + digit2 + 1));
				//不产生进位，要将addOne标记为false
				addOne = false;
			} else {
				//没有低位的进位，也不会产生新的进位，直接相加即可
				ans.append(Integer.toString(digit1 + digit2));
			}
        }
        //两个字符串很有可能有一个比另一个长，需要额外处理
        while(i >= 0) {
        	int digit = num1.charAt(i--) - '0';
        	//有低位的进位，且当前数字为9，会产生新进位
        	if(digit == 9 && addOne) {
        		ans.append('0');
        		addOne = true;
        	} else if(addOne) {
        		//有低位的进位，但不会产生新进位
        		ans.append(Integer.toString(digit + 1));
        		addOne =false;
        	} else {
        		//没有低位的进位，也不会产生新的进位
				ans.append(Integer.toString(digit));
			}
        }
        //下面的处理同上
        while(j >= 0) {
        	int digit = num2.charAt(j--) - '0';
        	if(digit == 9 && addOne) {
        		ans.append('0');
        		addOne = true;
        	} else if(addOne) {
        		ans.append(Integer.toString(digit + 1));
        		addOne =false;
        	} else {
				ans.append(Integer.toString(digit));
			}
        }
        //比如999 + 1，最后长度会加1，会有进位
        if(addOne) {
        	ans.append('1');
        }
        //在转换为字符串时，需要先逆置字符串
        return ans.reverse().toString();
    }
	
	public static void main(String[] args) {
		String num1 = "123";
		String num2 = "57";
		System.out.println(new AddStrings().addStrings(num1, num2));
	}
}