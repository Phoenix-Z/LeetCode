/**
 * (8ms)
 * 这个方法就是使用双指针技术，一个从前扫描，另一个从后扫描，跳过非数字或字母的字符
 * Character类有个静态方法isLetterOrDigit用来判断是数字和字母。
 * @author Phoenix-Z
 *
 */
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		char[] sc = s.toUpperCase().toCharArray();
		while(i < j)
		{
			/*while((sc[i] > 'Z' || (sc[i] < 'A' && sc[i] > '9') || sc[i] < '0') && i < j)
				i++;
			while((sc[j] > 'Z' || (sc[j] < 'A' && sc[j] > '9') || sc[j] < '0') && i < j)
				j--;*/
			while(!Character.isLetterOrDigit(sc[i]) && i < j)
				i++;
			while(!Character.isLetterOrDigit(sc[j]) && i < j)
				j--;
			if(sc[i++] != sc[j--])
				return false;
		}
        return true;
    }
	
	public static void main(String[] args) {
		String[] ss = {"aA", "0P", "a." ,"aa"};
		for(String s : ss)
			System.out.println(new ValidPalindrome().isPalindrome(s));
	}
}
