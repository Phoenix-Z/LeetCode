import java.util.Arrays;

/**
 * (8ms)
 * 大多数非常快的做法都是生成一个长度为26的数组，然后扫描s串中所有字母出现的次数(题目
 * 给的测试样例都是小写的英文字母)，然后在对t串扫描，如果次数为0，则不存在相应的字符。
 * 但是这种做法不利于扩展，比如Unicode字符，上述做法无法对中文字符串进行排序，所以
 * 下面这种做法更值得推荐。
 * 先将两个字符串转为字符数组，这里使用了toCharArray()方法，这个方法比split方法效率更高，
 * 而且这个方法返回的是char型数组，而不是String类型的数组。
 * 然后将这个两个数组排序，在逐一比较每个字符是否相等，如果不相等，就说明使用了不一样的字符。
 * @author Phoenix-Z
 *
 */
public class Solution2 {

	public boolean isAnagram(String s, String t) 
	{
		if(s.length() != t.length())
			return false;
		//将字符串转换为字符数组
	    char[] sChar = s.toCharArray();
	    char[] tChar = t.toCharArray();
	    
	    //对数组排序
	    Arrays.sort(sChar);
	    Arrays.sort(tChar);
	    
	    //这里直接使用了Arrays中的方法来比较数组是否相等
	    return Arrays.equals(sChar, tChar);   
	}
	
	public static void main(String[] args) {
		String s = "中国汉字";
		String t = "汉字中哈";
		System.out.println(new Solution().isAnagram(s, t));
	}
}