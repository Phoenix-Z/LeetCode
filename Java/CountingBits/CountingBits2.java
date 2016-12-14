/**
 * (3ms)
 * 这个方法是对上一个方法的改进，没有使用java提供的数学方法，而是使用了一个base变量，
 * 随着i的增长，也呈指数型增长。
 * @author Phoenix-Z
 *
 */
public class CountingBits2 {

	public int[] countBits(int num) {
		int[] count = new int[num + 1];
		int base = 1;
		for(int i = 1; i <= num; i++) {
			if(base * 2 == i)
				base = i;
			count[i] = 1 + count[i - base];
		}
		return count;
    }
	
}