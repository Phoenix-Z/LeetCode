/**
 * 用两个指针维护一下就可以了
 * @author Phoenix-Z
 *
 */
public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		int newLength = 0;
		if(nums.length > 0)
		{
			nums[newLength++] = nums[0];
			
			for(int i = 1; i < nums.length; i++)
			{
				if(nums[i] != nums[newLength - 1])
				{
					nums[newLength++] = nums[i];
				}
			}
		}
		
		return newLength;
    }
}