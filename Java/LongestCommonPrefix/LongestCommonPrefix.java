/**
 * (13ms)
 * 这个方法易于理解，就是逐个比较字符串，如果前缀的字符不同就截止，然后据此来判断最长共同前缀。
 * @author Phoenix-Z
 *
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {

		if(strs.length == 0)
            return null;
		//对于第一个字符串而言，最长共同前缀就是其本身
        StringBuilder ans = new StringBuilder(strs[0]);
        for(int i = 1; i < strs.length; i++) {
        	int pos = 0;
        	if(ans.length() == 0)
        		break;
        	//从头比较前缀，遇到不同的字符，或者到达其中一个字符串结尾就截止
        	while(pos < ans.length() && pos < strs[i].length() && ans.charAt(pos) == strs[i].charAt(pos)) {
        		System.out.println(ans.charAt(pos));
        		System.out.println(strs[i].charAt(pos));
        		pos++;
        	}
        	//截断前缀
        	if(pos < ans.length())
        		ans.delete(pos, ans.length());
        }
        return ans.toString();
    }
	
	public static void main(String[] args) {
		String[] strs = {"a", "b"};
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
	}
}
