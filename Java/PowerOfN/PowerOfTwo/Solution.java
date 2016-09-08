import java.util.ArrayList;
import java.util.List;

/**
 * (10ms)
 * 方法一：
 * 万能的做法：打表，把int范围内所有N的幂次的数字放入列表中，
 * 然后对于每个num,只要看它在不在列表中就行了。
 * 以下是2的幂次的一个步骤，其他幂次的就不写了，因此效率相比其他方法确实低。。。
 * @author Phoenix-Z
 *
 */
public class Solution {
	public boolean isPowerOfTwo(int n) {
        List<Integer> list = new ArrayList<>(32);
		for(int i = 0; i < 31; i++)
		{
			list.add((int)Math.pow(2, i));
		}
		if(list.contains(n))
			return true;
		return false;
    }
}
