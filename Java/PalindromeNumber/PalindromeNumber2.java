/**
 * (212ms)
 * 转换成了一个字符串，使用charAt方法进行判断
 * @author Phoenix-Z
 *
 */
public class PalindromeNumber2 {

	public  boolean isPalindrome(int x)
	{
		String str = Integer.toString(x);
		int len = str.length();
		boolean flag = true;
		
		for(int i = 0; i < len / 2; i++)
		{
			if(str.charAt(i) != str.charAt(len - i - 1))
			{
				flag = false;
			}
		}
		
		return flag;
	}
	
	public static void main(String[] args) {
		System.out.println(new PalindromeNumber2().isPalindrome(1001));
	}
}