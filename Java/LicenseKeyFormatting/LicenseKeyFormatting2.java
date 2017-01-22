/**
 * (35ms)
 * 这个方法就是直接从后往前遍历字符串，忽视原有的"-"符号，一旦某一段达到所需的长度要求，就添加一个"-"符号。
 * @author Phoenix-Z
 *
 */
public class LicenseKeyFormatting2 {

	public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    } 
	
}