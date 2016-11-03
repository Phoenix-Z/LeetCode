/**
 * (2ms)
 * 这个方法效率高了许多，类里面声明的数组表示的是nums数组的前j个元素之和，
 * 那么要求从i到j的数组元素之和，只需要前j个元素之和减去前i个元素之和。
 * @author Phoenix-Z
 *
 */
public class NumArray2 {

	private int[] nums = null;

	public NumArray2(int[] nums) {
		//求解前（i + 1）个元素之和
	    for(int i = 1; i < nums.length; i++)
	        nums[i] += nums[i - 1];
	    
	    this.nums = nums;
	}

	public int sumRange(int i, int j) {
	    //如果i等于0，直接返回前j个元素之和即可，否则返回前j个元素之和减去前i个元素之和的结果
	    return (i == 0) ? nums[j] : (nums[j] - nums[i - 1]);
	}
	
}