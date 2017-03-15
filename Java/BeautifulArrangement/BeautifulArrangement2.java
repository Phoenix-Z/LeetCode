/**
 * (106ms)
 * 也是回溯法，使用boolean型数组来标记是否已经添加过。效率有所改善。
 * 如果将now从后往前遍历，居然可以缩减到10ms。
 * @author Phoenix-Z
 *
 */
public class BeautifulArrangement2 {

	private int ans = 0;
	
	public int countArrangement(int N) {
		boolean[] used = new boolean[N];
		arrange(used, N, N);
		return ans;
    }
	
	public void arrange(boolean[] used, int N, int now) {
		// 不用考虑pos=1的情况，因为任何数字都可以放在那个位置
		if(now < 2) {
			ans++;
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(used[i - 1])
				continue;
			if(i % now == 0 || now % i == 0) {
				used[i - 1] = true;
				arrange(used, N, now - 1);
				used[i - 1] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		int N = 4;
		System.out.println(new BeautifulArrangement2().countArrangement(N));
	}
}
