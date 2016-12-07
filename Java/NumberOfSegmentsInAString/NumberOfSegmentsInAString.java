/**
 * (2ms)
 * 这道题目是根据空格符分割字符串，然后返回分成了几段，最常规的思路就是使用正则表达式，见方法二。
 * 这个方法是使用基础的while循环遍历整个字符串，一旦遇到空格就使段落数加一，然后再找到下一个非空格符的位置。
 * 直到遍历完整个字符串。由于没有使用java的API，效率很高。
 * @author Phoenix-Z
 *
 */
public class NumberOfSegmentsInAString {

	public int countSegments(String s) {
		//seg表示最终找到的段落数
		int seg = 0;
		//先取出字符串开头的空白符，以确保找到第一个段落的第一个字符
		s = s.trim();
		int i = 0;
		while (i < s.length()) {
			//一旦遇到空格符，就停止前进
			while (i < s.length() && s.charAt(i) != ' ')
				i++;
			//为了避免出现多个空格符，需要先找到下一段落的第一个字符
			while (i < s.length() && s.charAt(i) == ' ')
				i++;
			seg++;
		}
		return seg;
	}

	public static void main(String[] args) {
		String s = "1, 2, 3";
		System.out.println(new NumberOfSegmentsInAString().countSegments(s));
	}
}