import java.util.HashMap;

/**
 * (40ms)
 * 这个方法也是适用于Unicode字符的，主要是借助一个map来记录某个字符出现的次数，
 * 效率相对较低，但也不失为一个好方法。
 * @author Phoenix-Z
 *
 */
public class Solution3 {

	public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) 
        {
        	return false;
        }
        
        //map的键是字符串中出现的字符，值是字符出现的次数
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(Character c : s.toCharArray())
        {
        	//这个getOrDefault方法用的确实好
            int count = map.getOrDefault(c,0)+1;
            map.put(c,count);
        }
        
        for(Character c : t.toCharArray())
        {
            int count = map.getOrDefault(c,0)-1;
            if(count < 0) 
            {
            	return false;
            }
            map.put(c,count);
        }
        return true;
	}
	
	public static void main(String[] args) {
		String s = "中国汉字";
		String t = "汉字中国";
		System.out.println(new Solution().isAnagram(s, t));
	}
	
}