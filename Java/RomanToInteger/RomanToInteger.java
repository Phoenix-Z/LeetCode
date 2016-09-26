import java.util.HashMap;
import java.util.Map;

/**
 * (108ms)应该是数据量增加了，所以没有之前运行的快。
 * 这个方法很好啊，从后遍历字符串，一次遍历即可取得结果，比较好的做法是从后往前遍历。
 * 
 * 改进方法：可以看到使用HashMap一个个将罗马数字映射到数字有点麻烦，这里给出一个比较漂亮的做法：
 * String roman = "IVXLCDM";
 * int[] num = {1,5,10,50,100,500,1000};
 * 可以使用num[roman.IndexOf(s.charAt(i))]来达到与HashMap相同的效果，虽然效率差不多，
 * 但是写的代码较少，可以借鉴。
 * @author Phoenix-Z
 *
 */

public class RomanToInteger {

	private Map<Character, Integer> roman = new HashMap<>();
	
	{
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);
	}
	
	public int romanToInt(String s) {
		int num = 0;
		char[] cs = s.toCharArray();
		num += roman.get(cs[s.length() - 1]);
		for(int i = s.length() - 2; i >= 0; i--)
		{
			if(roman.get(cs[i]) < roman.get(cs[i + 1]))
			{
				num -= roman.get(cs[i]);
			}
			else {
				num += roman.get(cs[i]);
			}
		}
		return num;
    }
	
	public static void main(String[] args) {
		String[] strings = {"XIII", "MMMCMXCIX"};
		RomanToInteger test = new RomanToInteger();
		for(String string : strings)
			System.out.println(test.romanToInt(string));
	}
	
}