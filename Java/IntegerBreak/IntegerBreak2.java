/**
 * (0ms) 
 * 这是个奇妙的解法，假设这个数字被分解成后的数字中有一个f(f>=4)，那么这个f可以被分解成2和f-2，
 * 从而2*(f-2)=2f-4>=f,所以f只可能是1,2,3，显然1是没有意义的，至于选择分解成2还是3，可以这样理解，
 * 对于6而言，分解成3,3显然比分解成2,2,2的乘积大。进而对于n而言，可以以6为单位进行分解，那么最后剩下来的，
 * 一定小于6,其中5可以分解成2*3,而4可以分解成2*2，当然也可以不分解，不分解可以使代码更具一致性。
 * @author Phoenix-Z
 *
 */
public class IntegerBreak2 {

	public int integerBreak(int n) {
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		int product = 1;
		while (n > 4) {
			product *= 3;
			n -= 3;
		}
		product *= n;

		return product;
	}

}