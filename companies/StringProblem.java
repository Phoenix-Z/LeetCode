/**
 * 输出给定字符串的全排列，主要问题在于可能会有重复，所以需要去重。
 * 这个解法不是在原字符串上进行交换位置来实现的，而是先统计每个字符出现的次数，
 * 然后根据给定字符自己产生字符串，因此可以去重。
 * @author Phoenix-Z
 *
 */
public class StringProblem {

	private static int count = 0;
	public static void dfs(char[] ans, int[] num, int n, int now) 
	{
		if(now == n) {
			count++;
			System.out.println(ans);
			return;
		}
		for(int i = 0; i < 26; i++) {
			if(num[i] > 0) {
				num[i]--;
				ans[now] = (char)('a' + i);
				dfs(ans, num, n, now + 1);
				num[i]++;
			}
		}
	}
	
	public static void main(String[] args) {
		String[] ss = {"aaabbbccc", "aba"};
		for(String s : ss)
		{
			count = 0;
			int[] num = new int[26];
			char[] ans = new char[s.length()];
			for(char c : s.toCharArray()) {
				num[c - 'a']++;
			}
			dfs(ans, num, s.length(), 0);
			System.out.println(count);
			System.out.println();
		}
	}
}