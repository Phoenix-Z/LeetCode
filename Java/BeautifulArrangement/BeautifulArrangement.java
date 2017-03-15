import java.util.ArrayList;
import java.util.List;
/**
 * (395ms)
 * 基本思路就是回溯法，不过这里使用了List来存储中间结果，效率较低。
 * @author Phoenix-Z
 *
 */
public class BeautifulArrangement {

	private int ans = 0;
	
	public int countArrangement(int N) {
		List<Integer> used = new ArrayList<>();
		arrange(used, N);
		return ans;
    }
	
	public void arrange(List<Integer> used, int N) {
		if(used.size() == N) {
			ans++;
			return;
		}
		for(int i = 1; i <= N; i++) {
			int now = used.size() + 1;
			if(used.contains(i))
				continue;
			if(i % now == 0 || now % i == 0) {
				used.add(new Integer(i));
				arrange(used, N);
				used.remove(new Integer(i));
			}
		}
	}
	
	public static void main(String[] args) {
		int N = 4;
		System.out.println(new BeautifulArrangement().countArrangement(N));
	}
}
