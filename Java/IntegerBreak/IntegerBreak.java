/**
 * (1ms)
 * 这道题目是将一个给定的整数分解成若干个整数之和，然后计算这些整数的乘积，最后返回乘积的最大值。
 * 一个容易想到的想法是应该使分解出来的整数尽可能地相等，当然这不总是奏效(比如对于8而言，分解成两个4的乘积
 * 不如分解成3,3,2的乘积来的大)，但这依然比较平均，所以我们可以假设被分解成part个数字，然后遍历所有分解
 * 可能性，使每个数字尽可能相等，为此这里使用了round函数。最后求取最大值即可。
 * @author Phoenix-Z
 *
 */
public class IntegerBreak {

	public int integerBreak(int n) {
        int ans = 1;
        for(int part = 2; part < n; part++) {
        	//一定要选取四舍五入之后的数字，否则不能保证每个数字尽可能相等
            int avg = (int) Math.round(n * 1.0 / part);
            int product = (int) (Math.pow(avg, part - 1) * (n - avg * (part - 1)));
            ans = Math.max(ans, product);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {29, 2, 3, 7, 10};
        IntegerBreak test = new IntegerBreak();
        for (int n : nums) {
            System.out.println(test.integerBreak(n));
        }
    }
}