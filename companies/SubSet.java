import java.util.Arrays;

/**
 * 求一个集合的子集，需要注意的是，子集中的元素可以重复，但是子集本身是不能重复的。
 * @author Phoenix-Z
 *
 */
public class SubSet {

	private static int[] nums = {2, 1, 2};
	/**
	 * 
	 * @param ans 答案数组，，即子集
	 * @param num 原始数组各种数字出现次数对应的数组
	 * @param n 原始数组数字的种类数
	 * @param nowp 子集长度
	 * @param nown 当前考虑的原始数组中的某一个数字的序号
	 */
	public static void dfs(int[] ans, int[] num, int n, int nowp, int nown) {
		if(nown == n) {
			for(int i = 0; i < nowp; i++)
			{
				System.out.print(ans[i] + " ");
			}
			if(nowp == 0)
				System.out.println("[]");
			else {
				System.out.println();
			}
			return;
		}
		if(num[nown] > 0) {
			num[nown]--;
			ans[nowp] = nums[nown];
			dfs(ans, num, n, nowp + 1, nown);
			num[nown]++;
		}
		dfs(ans, num, n, nowp, nown + 1);
	}
	
	public static void main(String[] args) {
		Arrays.sort(nums);
		int[] ans = new int[nums.length];
		int[] num = new int[100];
		int j = 0;
		num[j] = 1;
		for(int i = 1; i < nums.length; i++)
		{
			if(nums[i] != nums[i - 1])
				num[++j]++;
			else {
				num[j]++;
			}
		}
		dfs(ans, num, j + 1, 0, 0);
	}
}