/**
 * (2ms)
 * 方法一：
 * 这个方法首先使用(num&(num-1))==0 && num>0 来确保num一定是2的幂次(见Power Of Two的方法二)
 * 然后使用了(num-1)%3==0这个条件保证num一定是4的幂次
 * (num^k - 1) = (num - 1)(num^(k-1) + ....),所以num^k-1可以被(num - 1)整除，这里num为4 
 * @author Phoenix-Z
 *
 */
public class Solution2 {

	public boolean isPowerOfFour(int num) {
        return (num&(num-1))==0 && num>0 && (num-1)%3==0;
    }
}
