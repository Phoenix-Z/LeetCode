/**
 * (48ms)
 * 这个方法其实是和方法二基本一致的，就是枚举所有可能的子串长度，但是这里做了一些优化。
 * 第一，从后向前枚举，实际上可以节省比较多的时间；
 * 第二，没有多次调用substring方法(这个方法的效率相对较低，而且会产生为数众多的String对象)，
 * 每次迭代只是用了一次substring来获取第一个子串，然后使用效率更高的StringBuilder生成一个
 * 子串重复多次的字符串，再将这个字符串同原来的字符串比较，以此来判断这个子串是否可行。
 * 这一点显然可以用于方法一的改进。
 * @author Phoenix-Z
 *
 */
public class RepeatedSubstringPattern3 {

	public boolean repeatedSubstringPattern(String str) {
		int l = str.length();
		for (int i = l / 2; i >= 1; i--) {
			if (l % i == 0) {
				int m = l / i;
				String subS = str.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < m; j++) {
					sb.append(subS);
				}
				if (sb.toString().equals(str))
					return true;
			}
		}
		return false;
	}

}