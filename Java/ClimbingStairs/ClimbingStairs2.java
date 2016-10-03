/**
 * (0ms)
 * 这道题本质上是一道斐波那契数列的题目。
 * 当n <= 0时，自然返回0；
 * 当n == 1时，只有一种爬楼梯的方式；
 * 当n == 2时，有两种爬楼梯的方式，(两次走一步，一次走两步)；
 * 当已知走 n - 1长和 n - 2长的楼梯有f(n - 1)和f(n - 2)种方式之后，那么走n长的楼梯的就是这个之和。
 * 因为走了n - 1长的楼梯之后再走一步就是n长，而走了n - 2长的楼梯之后再走一步步长为2的就是n长
 * 注意这里n - 2走一步再走一步达到n长的这种情况已经包含在前一种情况之中了。
 * 所以有递推：f(n) = f(n - 1) + f(n - 2)
 * 这就是fibonacci数列，不过需要注意的是头两个值是1和2，而不是1和1。
 * @author Phoenix-Z
 *
 */
public class ClimbingStairs2 {

	public int climbStairs(int n) {
        if(n < 2) 
        	return 1; 
        int[] res = new int[n+1];
        res[0]=1;
        res[1]=1;
        for(int i = 2; i <= n; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }
	
	public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs(44));
	}
}
