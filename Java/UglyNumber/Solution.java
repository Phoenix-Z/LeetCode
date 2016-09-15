/**
 * (2ms)
 * 需要判断num是否大于0
 * @author Phoenix-Z
 *
 */
public class Solution {

	public boolean isUgly(int num) {
		if (num <= 0) {
			return false;
		}
		while(num % 2 == 0)
		{
			num = num / 2;
		}
		
		while(num % 3 == 0)
		{
			num = num / 3;
		}
		
		while(num % 5 == 0)
		{
			num = num / 5;
		}
		
		if (num == 1) {
			return true;
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		int num = 14;
		System.out.println(new Solution().isUgly(num));
	}
	
}