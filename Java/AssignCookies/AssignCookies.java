import java.util.Arrays;

/**
 * (18ms)
 * 这是个贪心算法的问题，首先对两个数组排序(从小到大排序)，然后用两个指针分别遍历这两个数组，
 * 遇到满足gi，则i前进一步，j也前进一步，否则只有j前进。最后返回i即可，因为它就代表了满足的孩子数。
 * @author Phoenix-Z
 *
 */

public class AssignCookies {

	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0, j = 0;
		while(i < g.length && j < s.length) {
			if(g[i] <= s[j]) {
				i++;
			}
			j++;
		}
		return i;
    }
	
}