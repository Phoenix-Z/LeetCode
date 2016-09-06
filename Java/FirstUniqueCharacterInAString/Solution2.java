/**
 * (40ms)
 * 方法二：
 * 利用java提供的方法，对比某个字符出现的第一个索引和最后一个索引是否一致，若一致，则表示只出现一次
 * 同样地，由于indexOf和lastIndexOf方法的时间复杂度也为O(n),所以这个解法并不是简单看上去的O(n)的时间复杂度
 * @author Phoenix-Z
 *
 */
public class Solution2 
{
	public int firstUniqChar(String s) 
	{
        for (int i = 0; i < s.length(); i++) 
        {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) 
            {
                return i;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		System.out.println(new Solution2().firstUniqChar("loveleetcode"));
	}
}