/**
 * (0ms)
 * 这道题是不使用+和-运算符来实现两个数字的相加，这里使用的位运算，只需要使用&和^运算即可
 * 关于位运算还有些好玩的tricks，如下面的链接
 * https://discuss.leetcode.com/topic/50315/a-summary-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
 * @author Phoenix-Z
 *
 */
public class SumOfTwoIntegers {

	public static int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
	
	public static void main(String[] args) {
		System.out.println(getSum(3, 10));
	}
}
