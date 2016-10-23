import java.util.Arrays;

/**
 * (1ms)
 * 这个方法就是将数组的前nums.length - (k % nums.length)个元素用一个数组保存起来，
 * 然后将后面的元素移动到前面，再把保存起来的元素添加到数组的后面。
 * @author Phoenix-Z
 *
 */
public class RotateArray {

	public void rotate(int[] nums, int k) {
		//需要注意的是，k的值有可能大于数组的长度，这时候需要做一次取模运算
		int[] arr = new int[nums.length - (k % nums.length)];
		//j是新数组的指针
		int j = 0;
		for(int i = 0; i < nums.length; i++) {
			//保存前n个元素
			if(i < nums.length - (k % nums.length)) {
				arr[i] = nums[i];
			} else { //将后面的元素移动到前面
				nums[j++] = nums[i];
			}
		}
		//将保存下来的元素添加至数组之后
		for(int i = 0; i < arr.length; i++)
		{
			nums[j++] = arr[i];
		}
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		new RotateArray().rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}
	
}