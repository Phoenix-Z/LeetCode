/**
 * (1ms)
 * 方法一：(写的很丑)
 * 这个方法基本思路是遍历整个数组，一个指针（i）从前到后遍历，另一个指针（len）从后往前遍历，
 * 将i遇到的val全部移动到数组的最后，从而分成两个部分，前一部分就是所需的剩下来的数组。
 * @author Phoenix-Z
 *
 */
public class Solution {
	public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1){
			return nums[0] == val ? 0: 1;
		}
        int len = nums.length - 1;
        int i;
        for(i = 0; i < len; i++)
        {
        	if(nums[i] == val)
        	{
        		while(nums[len] == val && len > 0)
        		{
        			len--;
        		}
        		if(len > i)
        		{
	        		int tmp = nums[i];
	        		nums[i] = nums[len];
	        		nums[len] = tmp;
        		}
        	}
        }
        while(nums[len] == val && len >= 0)
        {
        	len--;
        	if(len < 0)
        	break;
		}
        
        return len + 1;
    }
	
	
	
	public static void main(String[] args) {
		int[] nums = {};
		System.out.println(new Solution().removeElement(nums, 3));
	}
}
