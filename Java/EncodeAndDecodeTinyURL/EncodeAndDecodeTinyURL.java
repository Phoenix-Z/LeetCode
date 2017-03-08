import java.util.HashMap;
import java.util.Map;
/**
 * (11ms)
 * 这个题目本质上就是构造一个映射表，这个方法是使用一个map，以url的hash值作为键，url作为值，存放在map中。当数据量很大的时候，
 * 很可能会发生碰撞。所以这个方法不是很好，也可以使用一个字符串数组，返回的是字符串在数组中的位置。但是这个方法，对同一个字符串
 * encode多次返回的值不一样，浪费空间。
 * @author Phoenix-Z
 *
 */
public class EncodeAndDecodeTinyURL {

	private Map<Integer, String> cache = new HashMap<>();
	
	// Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    	int key = longUrl.hashCode();
    	cache.put(key, longUrl);
        return "" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	int key = Integer.parseInt(shortUrl);
    	return cache.get(key);
    }
	
    public static void main(String[] args) {
    	EncodeAndDecodeTinyURL test = new EncodeAndDecodeTinyURL();
		String encodeRes = test.encode("https://leetcode.com/problems/design-tinyurl"); 
		System.out.println(encodeRes);
		System.out.println(test.decode(encodeRes));
	}
}
