/**
 * (28ms)
 * 做法一：简单有效，效率很高
 * 遍历整个字符串，统计每个字符出现的次数
 * 然后在遍历一遍字符串，找出第一个出现次数等于的字符所对应的索引即可
 * @author Phoenix-Z
 *
 */
public class Solution {
	public int firstUniqChar(String s) {
        //freq数组用来存放每个字符出现的次数，ASCII共有256个字符
		int[] freq = new int[256];
        
		//统计次数
		for(int i = 0; i < s.length(); i ++)
		{
            freq[s.charAt(i)] ++;
		}
		
		//查找第一个只出现一次的字符的索引
        for(int i = 0; i < s.length(); i ++)
        {
            if(freq[s.charAt(i)] == 1)
            {
                return i;
            }
        }
        //找不到则返回-1
        return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().firstUniqChar("loveleetcode"));
	}
}