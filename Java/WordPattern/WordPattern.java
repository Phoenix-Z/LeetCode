import java.util.HashMap;
import java.util.Map;

/**
 * (2ms)
 * 这个方法就是使用了Map的put操作，使用了两个HashMap，第一个Map的put的键为每一次遍历的pattern字符，
 * 值为这个字符所在的位置， 第二个Map的put的键为每一次遍历的str字符串，值为这个字符串所在的位置。
 * 需要注意的是java在put操作时，对于int型的位置，需要先封装成一个Integer对象，那么在后面比较值是否
 * 相等时，可能会因为java自动生成的对象不是同一个对象，所以需要多写一些代码来int的值是否相等。
 * @author Phoenix-Z
 *
 */
public class WordPattern {

	public boolean wordPattern(String pattern, String str) {
		//将pattern和str分割成字符或者字符串
		char[] cs = pattern.toCharArray();
		String[] ss = str.split(" ");
		
		if(cs.length != ss.length)
			return false;
		
		Map<Character, Integer> patterns = new HashMap<>();
		Map<String, Integer> strs = new HashMap<>();
		
		for(int i = 0; i < cs.length; i++) {
			Integer lastPattern = patterns.put(cs[i], i);
			Integer lastStr = strs.put(ss[i], i);
			//针对生成对象可能不一致的问题，需要处理一下
			if(lastPattern != null && lastStr != null && lastPattern.intValue() == lastStr.intValue())
				continue;
			if(lastPattern != lastStr)
				return false;
		}
		
		return true;
    }
	
	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog cat cat fish";
		System.out.println(new WordPattern().wordPattern(pattern, str));
	}
}