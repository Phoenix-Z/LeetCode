import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * (17ms)
 * 这道题目就是判断两个字符串是否同构，对于s串中同一字符出现n次，那么在t串中映射成的字符也要出现n次
 * 两个不同的字符不能映射成同一个字符。
 * 映射关系用Map来表现，防止两个字符映射成同一个字符，可以使用Set将已经映射过的字符保存起来。
 * @author Phoenix-Z
 *
 */
public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		//存储映射的字符
		Set<Character> used = new HashSet<>();
		//存储映射关系
		Map<Character, Character> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++)
		{
			Character character = map.get(s.charAt(i));
			if(character == null)
			{
				if (!used.contains(t.charAt(i))) {
					map.put(s.charAt(i), t.charAt(i));
					used.add(t.charAt(i));
				}else {
					return false;
				}
				
			}else if(character != t.charAt(i)) {
					return false;
			}
		}
        return true;
    }

	public static void main(String[] args) {
		String s = "paper";
		String t = "title";
		System.out.println(new IsomorphicStrings().isIsomorphic(s, t));
	}
}