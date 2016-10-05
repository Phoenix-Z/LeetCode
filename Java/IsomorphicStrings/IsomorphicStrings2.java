import java.util.HashMap;
import java.util.Map;

/**
 * (32ms)
 * 这个方法效率相对较低，但是可以帮助深入理解HashMap的相关操作。
 * 这个方法借助两个Map，存储的分别是s串和t串的第i位的字符和i。
 * 这里充分利用了HashMap的put操作的返回值，put的返回值是key上一个所对应的value值(这实际上
 * 达到了一种同步，即一个字符始终都会被映射成同一个字符)，
 * 如果之前没有这个key的键值对，就返回null(这里避免了两个不同字符映射成同一个字符)
 * @author Phoenix-Z
 *
 */
public class IsomorphicStrings2 {

	public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
    
        /*
         * 注意这里使用了Integer来定义i，因为这实际上就生成了一个对象，
         * 这样才可以在后续使用!=判断是否相等。
         * 如果使用int，虽然Java会自动装箱，但是有可能会生成不同的对象，
         * 理论上可以使用equals方法来判断，但是有可能有的Java垃圾回收机制，
         * 会将自动装箱生成的对象清理掉，那么会报空指针异常。
         * 所以这里最好就直接使用Integer来定义i。
         */
        for(Integer i = 0; i < s.length(); i++) {

            if(m1.put(s.charAt(i), i) != m2.put(t.charAt(i), i)) {
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