import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (213ms)
 * 这个方法很丑陋，是一个O(n^2)的算法，而且也使用了较多的内存，效率很低。
 * 这个方法就是多次判断是否是anagram，不过不是就前进一格。
 * 当然也做了一些优化，比如如果在s中遇到了p中没有的字符，那么就直接跳到该字符的下一个。
 * @author Phoenix-Z
 *
 */
public class FindAllAnagramsInAString {

	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        //count数组记录p字符串中字符出现的次数，如果没有出现，则为-1
        int[] count = new int[26];
        Arrays.fill(count, -1);
        //统计字符出现的次数
        for(char c : p.toCharArray()) {
        	if(count[c - 'a'] < 0)
        	{
        		count[c - 'a'] = 1;
        	} else {
        		count[c - 'a']++;
			}
        }
        int sLen = s.length(), pLen = p.length();
        for(int i = 0; i <= sLen - pLen; i++) {
        	//每次遍历都要重新恢复数组，这里花费的时间较多
        	int[] tmp = Arrays.copyOf(count, 26);
        	int j;
        	for(j = 0; j < pLen; j++) {
        		//如果遇到了p中没有的字符，就直接跳到该字符的下一个
        		if(tmp[s.charAt(i + j) - 'a'] < 0)
        		{
        			i += j;
        			break;
        		} else if(tmp[s.charAt(i + j) - 'a'] > 0) {
        			tmp[s.charAt(i + j) - 'a']--;
        		} else {
					break;
				}
        	}
        	//如果是anagram，就添加到结果集中
        	if(j == pLen)
        	{
        		ans.add(i);
        	}
        }
        return ans;
    }
	
	public static void main(String[] args) {
		String s = "abab";
		String p = "ab";
		System.out.println(new FindAllAnagramsInAString().findAnagrams(s, p));
	}
	
}