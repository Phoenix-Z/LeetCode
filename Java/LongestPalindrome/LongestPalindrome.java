import java.util.HashMap;
import java.util.Map;

/**
 * (22ms)
 * 遍历整个字符串，统计每个字符出现的次数。对于出现偶数次的字符肯定可以全部出现在回文串中，
 * 而整个字符串只允许一个字符出现奇数次，其他出现奇数次的字符需要次数减一。
 * @author Phoenix-Z
 *
 */
public class LongestPalindrome {

	public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        //统计字符出现的次数
        for(char c : s.toCharArray())
        {
        	int count = map.getOrDefault(c, 0) + 1;
        	map.put(c, count);
        }
        //判断是否有出现奇数次的字符
        boolean odd = false;
        int maxLength = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
        	int count = entry.getValue();
        	//出现偶数次的字符
        	if (count % 2 == 0) {
				maxLength += count;
			} else { //出现奇数次的字符
				maxLength += count - 1;
				odd = true;
			}
        }
        //如果有出现奇数次的字符，整个次数加一
        if (odd) {
			maxLength++;
		}
        return maxLength;
    }
	
	public static void main(String[] args) {
		
	}
}
