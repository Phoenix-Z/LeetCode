/**
 * (0ms)
 * 方法二：这个方法显然更好
 * 从前往后遍历数组，将不等于val的值从数组开始处覆盖原来的值，覆盖的长度就是最后所需的长度
 * @author Phoenix-Z
 *
 */
public class Solution2 {
	public int removeElement(int[] nums, int val) 
	{
		int len = 0;    
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != val)
			{
				nums[len++] = nums[i];
		    }
		}
		   
		return len;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,2,3};
		System.out.println(new Solution().removeElement(nums, 3));
	}
}
