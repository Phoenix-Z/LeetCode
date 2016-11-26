/**
 * (21ms)
 * 这个方法是结合了KMP算法，效率较高，而且代码量少，当然也最难理解。
 * @author Phoenix-Z
 *
 */
public class RepeatedSubstringPattern4 {

	public boolean repeatedSubstringPattern(String str) {
		int l = str.length();
		for (int i = (l + 1) / 2; i < l; i++) {
			if (l % (l - i) == 0) {
				String prefix = str.substring(0, i);
				String remainder = str.substring(i);
				String suffix = str.substring(l - i);
				if (str.startsWith(remainder) && suffix.equals(prefix)) {
					return true;
				}
			}
		}
		return false;
	}

}