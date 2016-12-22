import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * (43ms)
 * 这道题目本质上和Top k元素的题目基本一致，这里挑了一种方法实现。
 * @author Phoenix-Z
 *
 */
public class SortCharactersByFrequency {

	public static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		TreeMap<Integer, List<Character>> sortMap = new TreeMap<>();
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			Integer count = entry.getValue();
			if(!sortMap.containsKey(count)) {
				sortMap.put(count, new ArrayList<>());
			}
			sortMap.get(count).add(entry.getKey());
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
	
	public static void main(String[] args) {
		String s = "Aabb";
		System.out.println(frequencySort(s));
	}
}