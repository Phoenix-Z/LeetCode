import java.util.Arrays;

/**
 * (1ms)
 * 这个方法也很有意思，它是首先将整个数组颠倒，然后对于前k个元素颠倒，
 * 再对后面所有的元素颠倒，就可以达到循环数组的效果。
 * @author Phoenix-Z
 *
 */
public class RotateArray3 {

	public void rotate(int[] nums, int k) {
		//需要对k先处理一下，以防数组越界
	    k %= nums.length;
	    //颠倒整个数组
	    reverse(nums, 0, nums.length - 1);
	    //颠倒前k个元素
	    reverse(nums, 0, k - 1);
	    //颠倒后面所有元素
	    reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
	    while (start < end) {
	        int temp = nums[start];
	        nums[start] = nums[end];
	        nums[end] = temp;
	        start++;
	        end--;
	    }
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		new RotateArray2().rotate(nums, 4);
		System.out.println(Arrays.toString(nums));
	}
}