/**
 * (6ms)
 * 统计s串中各字符出现的次数
 * 然后遍历t串找出多出来的字符
 * @author Phoenix-Z
 *
 */
public class FindTheDifference {

	public char findTheDifference(String s, String t) {
        char diff = '\u0000';
        int[] count = new int[26];
        
        for(char c : s.toCharArray())
        {
        	count[c - 'a']++;
        }
        
        for(char c : t.toCharArray())
        {
        	if(count[c - 'a'] == 0)
        	{
        		diff = c;
        		break;
        	}
        	count[c - 'a']--;
        }
        
        return diff;
    }
	
	public static void main(String[] args) {
		String s = "abcd";
		String t = "abcde";
		System.out.println(new FindTheDifference().findTheDifference(s, t));
	}
}
