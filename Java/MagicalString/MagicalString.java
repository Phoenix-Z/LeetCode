/**
 * (26ms)
 * 这个方法就是动态的创建Magical String，直到字符串的长度大于等于给定的n，最后再统计构造出的字符串中‘1’的
 * 个数。
 * @author Phoenix-Z
 *
 */
public class MagicalString {

	public int magicalString(int n) {
		StringBuilder magic = new StringBuilder("122");
		int index = 2;
		while (magic.length() < n) {
			int count = magic.charAt(index++) - '0';
			char c = magic.charAt(magic.length() - 1) == '1' ? '2' : '1';
			while (count-- > 0) {
				magic.append(c);
			}
		}
        int count = 0;
        while (--n >= 0) {
        	if (magic.charAt(n) == '1')
        		count++;
        }
        return count;
    }
	
}