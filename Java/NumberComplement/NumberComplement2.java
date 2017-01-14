/**
 * (12ms)
 * 这个方法使用了Java提供的Integer.highestOneBit方法，这个方法返回一个int值，这个int只有一位置1了，那
 * 一位是传入的参数最左边被置1的一位。将这个返回值左移一位再减一，再与num的反码进行与运算，就会只剩下有效位。
 * @author Phoenix-Z
 *
 */
public class NumberComplement2 {

	public static int findComplement(int num) {
		return ~ num & ((Integer.highestOneBit(num) << 1) - 1);
    }
	
	public static void main(String[] args) {
		int[] nums = {5, 1};
		for(int num : nums) {
			System.out.println(findComplement(num));
		}
	}
}
