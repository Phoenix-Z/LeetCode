import java.util.ArrayList;
import java.util.List;

/**
 * (70ms)
 * 打表。。。
 * @author Phoenix-Z
 *
 */
public class Solution {
	public boolean isPowerOfThree(int n) {
		List<Integer> list = new ArrayList<>();
		int i = 1;
		int num = 1;
		while(num < Integer.MAX_VALUE)
		{
			list.add(num);
			num = (int) Math.pow(3, i);
			i++;
		}
		if(list.contains(n))
			return true;
        return false;
    }
}