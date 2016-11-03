/**
 * (86ms)
 * 这个方法就是最简单的做法，但是在多次调用时效率很低，所以需要改进。
 * @author Phoenix-Z
 *
 */
public class NumArray {

	private int[] nums = null;
    
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int ans = 0;
        for(int k = i; k <= j; k++) {
        	ans += nums[k];
        }
        return ans;
    }
	
}