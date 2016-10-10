/**
 * (49ms)
 * 这个方法虽然慢，但是思路很有意思，它是先使用正则表达式将字符串中非数字和字母的字符去除掉，
 * 然后将该字符串颠倒，与原串比较来判断是否是回文串。
 * @author Phoenix-Z
 *
 */
public class ValidPalindrome2 {

	public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
	
}
