/**
 * (10ms)
 * 这个方法很朴素，就是先求出前导0的个数为count，然后对该数字求反码，再与-1左移count位后做与运算即可得到结果。
 * @author Phoenix-Z
 *
 */
public class NumberComplement {

	public static int findComplement(int num) {
		int count = 1;
		while(((num << count) & Integer.MIN_VALUE) == 0) {
			count++;
		}
		return num ^ -1 & (-1 >>> count);
    }
	
	public static void main(String[] args) {
		int[] nums = {5, 1};
		for(int num : nums) {
			System.out.println(findComplement(num));
		}
	}
}