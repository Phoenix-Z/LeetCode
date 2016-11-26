/**
 * (16ms)
 * 这个题目的做法很多，效率也不尽相同。这个方法是原创，效率很高，但代码量较多。
 * 这个方法首先统计字符串每个字符出现的次数，如果字符串可以被拆分成多个重复的子串，
 * 那么每个字符重现的次数的最大公约数一定大于1，所以紧接着是求出现过的字符次数的最大公约数。
 * 然后可以枚举最大公约数的所有约数，这里约数可以看做是子串重复的次数。
 * 根据约数求取子串的长度，最后根据子串长度来判断是否可以拆分成重复的子串。
 * @author Phoenix-Z
 *
 */
public class RepeatedSubstringPattern {

	public boolean repeatedSubstringPattern(String str) {
		//统计字符串每个字符出现的次数
		int[] count = new int[26];
		for(char c : str.toCharArray()) {
			count[c - 'a']++;
		}
		
		//求取出现过的字符，它们出现次数的最大公约数
		int gcd = 0;
		for(int i = 0; i < 26; i++) {
			if(count[i] != 0) {
				if(gcd == 0) {
					gcd = count[i];
				} else {
					gcd = gcd(gcd, count[i]);
				}
			}
		}
		
		//如果最大公约数等于1，就意味着一定不可以被拆分成重复的字符串
		if(gcd == 1)
			return false;
		
		//subLength表示子串的长度
		int subLength = 0;
		//先根据最大公约数来获取子串长度
		for(int c : count) {
			subLength += c / gcd;
		}
		
		//枚举最大公约数的所有约数
		for(int j = gcd; j >= 2; j--) {
			//判断j是否为最大公约数的约数
			if(gcd % j != 0)
				continue;
			//重新计算子串的长度
			int newSubLength = subLength * (gcd / j);
			if(newSubLength == 0 && str.length() % newSubLength != 0)
				continue;
			int num = str.length() / newSubLength;
			String subS = str.substring(0, newSubLength);
			StringBuilder sb = new StringBuilder();
			//判断该子串是否可行
			for (int k = 0; k < num; k++) {
				sb.append(subS);
			}
			if (sb.toString().equals(str))
				return true;
		}
		return false;
    }
	
	//辗转相除法求取最大公约数
	public int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		String str = "";
		System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern(str));
	}
}