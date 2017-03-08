import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * (17ms)
 * 这个方法是将前面所说的两个方法进行结合，既解决了碰撞的问题，也避免了重复encode的问题。
 * @author Phoenix-Z
 *
 */
public class EncodeAndDecodeTinyURL2 {

	private Map<Integer, List<String>> cache = new HashMap<>();
	
	// Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    	int key = longUrl.hashCode();
    	String shortUrl = "" + key;
    	if(cache.containsKey(key)) {
    		int index = cache.get(key).indexOf(longUrl);
    		if(index == -1) {
    			List<String> newList = cache.get(key);
    			newList.add(longUrl);
    			cache.put(key, newList);
    			shortUrl += "/" + (newList.size() - 1); 
    		} else {
    			shortUrl += "/" + index;
    		}
    	} else {
    		List<String> newList = new ArrayList<>();
    		newList.add(longUrl);
    		cache.put(key, newList);
    		shortUrl += "/0";
    	}
    	return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	String[] pos = shortUrl.split("/");
    	return cache.get(Integer.parseInt(pos[0])).get(Integer.parseInt(pos[1]));
    }
	
    public static void main(String[] args) {
    	EncodeAndDecodeTinyURL2 test = new EncodeAndDecodeTinyURL2();
		String encodeRes = test.encode("https://leetcode.com/problems/design-tinyurl"); 
		System.out.println(encodeRes);
		System.out.println(test.decode(encodeRes));
	}
    
}
