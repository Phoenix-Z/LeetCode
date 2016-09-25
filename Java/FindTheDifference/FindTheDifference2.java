/**
 * (8ms)
 * 这个方法也是很好的，这里利用了异或的特性:
 * x ^ x = 0(可以看成是x - x = 0)
 * x ^ 0 = x(可以看成是x - 0 = x)
 * 所以只要将这两个字符串中的字符逐一异或，最后的值就是添加的字符！
 * @author Phoenix-Z
 *
 */
public class FindTheDifference2 {

	public char findTheDifference(String s, String t) {
		char ans = '\u0000';
		
		for(int i = 0; i < s.length(); i++)
		{
			/*
			 * 注意这里使用了^=运算符，而不是使用ans = ans ^ s.charAt(i);
			 * 因为java在进行如上运算时都是先转换成int型的，也就是说ans是char型的，
			 * 而右部表达式的计算结果是int型的，这自然会报错。而使用^=运算符的时候，
			 * java会强制类型转换，而不管精度的损失，而这是这道题目所需要的。
			 */
			ans ^= s.charAt(i);
			ans ^= t.charAt(i);
		}
		
		//注意到t比s多一个字符
		ans ^= t.charAt(t.length() - 1);
		
		return ans;
    }
	
	public static void main(String[] args) {
		String s = "abcd";
		String t = "abcde";
		System.out.println(new FindTheDifference().findTheDifference(s, t));
	}
}
