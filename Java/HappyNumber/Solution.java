import java.util.HashSet;
import java.util.Set;

/**
 * 这道题在维基百科上有关于Happy Number的介绍
 * https://en.wikipedia.org/wiki/Happy_number#Popular_culture
 * (7ms)
 * 这个方法就是把每次迭代产生的中间数加入到set集中，如果后面出现了重复的数字
 * 就跳出循环，以避免出现死循环。
 * 
 * 在discuss中大多数更快地结果都是判断当n小于5而且n不等1时跳出循环，不过没有看到合理的解释
 * 确实效率提高了，如果需要数学方面的证明可以看维基百科
 * @author Phoenix-Z
 *
 */
public class Solution {

	public boolean isHappy(int n) {
		//用Set判断某个数字是否出现过了
		Set<Integer> exists = new HashSet<>();
		
		//now表示迭代过程中的中间结果
		int now = splitNum(n);
		exists.add(now);
		
		while(now != 1){
			now = splitNum(now);
			//如果已经出现过就跳出循环
			if(exists.contains(now))
			{
				break;
			}
			exists.add(now);
		}
		if (now == 1) {
			return true;
		}
		return false;
    }
	
	public int splitNum(int n){
		int ans = 0;
		while(n > 0)
		{
			ans += (int)Math.pow(n % 10, 2);
			n = n / 10;
		}
		return ans;
	} 
	
	public static void main(String[] args) {
		System.out.println(new Solution().isHappy(2));
	}
}