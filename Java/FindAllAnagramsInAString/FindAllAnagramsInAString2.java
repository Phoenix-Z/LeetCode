import java.util.ArrayList;
import java.util.List;

/**
 * (23ms)
 * 这个方法使用的是滑动窗口的方式，left和right分别指向窗口的两端，这两个指针只遍历了链表一次，
 * 时间复杂度为O(n)，空间复杂度为O(1)。
 * @author Phoenix-Z
 *
 */
public class FindAllAnagramsInAString2 {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		//特殊情况处理
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;
		//这也是用来统计p串中字符出现的次数，当然可以缩小数组长度
		int[] hash = new int[256]; 
		// 统计字符出现的次数
		for (char c : p.toCharArray()) {
			hash[c]++;
		}
		// 两个指针指向窗口的两端，count是当前窗口的大小，窗口最大为p串的长度
		int left = 0, right = 0, count = p.length();
		while (right < s.length()) {
			//不管right指向的字母是否在p串中，right都向前走一步
			//如果right指向的字母在串中，count减1
			//当前hash数组中那个字母对应的值大于1，就意味着p串中有那个字母
			if (hash[s.charAt(right++)]-- >= 1)
				count--;

			//当count等于0时，意味着找到了正确的anagram
			//然后将窗口的左指针放入到结果列表中
			if (count == 0)
				list.add(left);

			//如果发现窗口的大小等于p，需要将窗口的做指针向前移动，以便找到新的匹配的窗口
			//因为把窗口最左边的字母移出了窗口，需要将其hash数组的值加一
			//如果这个字母在p中，那么就增加count的值
			//这个字母在hash数组中的值大于等于0，意味着它原本是在hash中，因为它不可能小于0
			if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
				count++;
		}
		return list;
	}
}