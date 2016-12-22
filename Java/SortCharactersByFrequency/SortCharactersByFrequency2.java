import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * (27ms)
 * 这只是对方法一做的局部优化，使用一个256(ASCII码范围)大小的数组来统计次数，而不是使用map，其他基本一致。
 * @author Phoenix-Z
 *
 */
public class SortCharactersByFrequency2 {

	public static String frequencySort(String s) {
		int[] counts = new int[256]; 
		for(char c : s.toCharArray()) {
			counts[c]++;
		}
		TreeMap<Integer, List<Character>> sortMap = new TreeMap<>();
		for(int i = 0; i < 256; i++) {
			if(counts[i] > 0) {
				if(!sortMap.containsKey(counts[i])) {
					sortMap.put(counts[i], new ArrayList<>());
				}
				sortMap.get(counts[i]).add((char)i);
			}
		}
		
        StringBuilder ans = new StringBuilder();
        while(sortMap.size() > 0) {
        	Map.Entry<Integer, List<Character>> entry = sortMap.pollLastEntry();
        	List<Character> cs = entry.getValue();
        	for(Character c : cs) {
        		int count = entry.getKey();
        		while(count-- > 0) {
        			ans.append(c);
        		}
        	}
        }
        return ans.toString();
    }
	
}