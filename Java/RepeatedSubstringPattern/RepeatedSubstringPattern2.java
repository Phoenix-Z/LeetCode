/**
 * (444ms)
 * 这个方法的思想就是枚举子串的长度(从1到原字符串的一半，因为至少要重复一次)，一旦子串长度可能
 * 符合要求(就是先用第一个子串和第二个子串是否相等来判断是否有可能是合适的子串的长度)，再对所有的
 * 子串进行判断。由于大量使用了获取子串的方法，所以效率很低。
 * @author Phoenix-Z
 *
 */
public class RepeatedSubstringPattern2 {

	public boolean repeatedSubstringPattern(String str) {
		//subLen表示子串的长度
		int subLen = 1;
		while(subLen <= str.length() / 2) {
			if(str.substring(0, subLen).equals(str.substring(subLen, 2 * subLen))) {
				if(str.length() % subLen != 0)
				{
					subLen++;
					continue;
				}
				int num = str.length() / subLen;
				int i;
				for(i = 0; i < num - 1; i++) {
					if(!str.substring(i * subLen, (i + 1) * subLen).equals(
							str.substring((i + 1) * subLen, (i + 2) * subLen))){
						break;
					}
				}
				//如果其中有一个子串不合要求，i的值就一定会小于num - 1
				if(i == num - 1)
					return true;
			}
			subLen++;
		}
		if(subLen > str.length() / 2) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "aabaaba";
		System.out.println(new RepeatedSubstringPattern2().repeatedSubstringPattern(str));
	}
}