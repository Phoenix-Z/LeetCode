/**
 * (18ms)
 * 这个方法的思路和Power Of Two的方法三是一致的。
 * @author Phoenix-Z
 *
 */
public class Solution {
	public boolean isPowerOfThree(int n) {
	    // 1162261467 is 3^19,  3^20 is bigger than int  
	    return ( n>0 &&  1162261467%n==0);
	}
}