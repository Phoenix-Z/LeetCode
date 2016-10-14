/**
 * (9ms)
 * 这个方法就是将原字符串根据空格分割，如果返回的字符串数组非空，就返回字符串数组最后一个字符串的长度。
 * 否则就返回0。
 * 需要注意的是对于全是空格符的字符串，split之后得到的是空的字符串数组。
 * @author Phoenix-Z
 *
 */
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
        if(s == null || s.equals(""))
            return 0;
        String[] ss = s.split(" ");
        if(ss.length == 0)
            return 0;
        return ss[ss.length - 1].length();
    }
	
}