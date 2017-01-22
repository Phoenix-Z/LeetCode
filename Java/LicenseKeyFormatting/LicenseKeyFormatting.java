/**
 * (25ms)
 * 这个方法是先将原来的"-"符号去掉，同时将所有小写字母转换为大写字母，然后再从后往前添加"-"符号。
 * @author Phoenix-Z
 *
 */
public class LicenseKeyFormatting {

	public static String licenseKeyFormatting(String S, int K) {
		StringBuilder ans = new StringBuilder(S.replace("-", "").toUpperCase());
		int index = ans.length() - K;
		while(index > 0) {
			ans.insert(index, '-');
			index = index - K;
		}
		return ans.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(licenseKeyFormatting("2-4A0r7-4k", 4));
		System.out.println(licenseKeyFormatting("2-4A0r7-4k", 3));
	}
}