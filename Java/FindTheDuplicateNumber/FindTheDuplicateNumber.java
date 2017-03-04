/**
 * (1ms)
 * 这个方法的思路来自于判断链表是否有环，即使用两个指针，一个指针一次走一步，另一个指针一次走两步，由于某一个数字出现了多次，
 * 那么slow和fast会在该数字指向的索引就是进入环的entrypoint。
 * 时间复杂度为O(n), 空间复杂度为O(1)。
 * @author Phoenix-Z
 *
 */
public class FindTheDuplicateNumber {

	public int findDuplicate(int[] nums) {
		if(nums == null || nums.length < 2) {
			return -1;
		}
		int slow = nums[0];
		int fast = nums[nums[0]];
		// 这个循环的终止条件有两种可能性， 一是fast和slow相等，但是不是同一个位置上的数字
		// 二是fast和slow指向的是同一个数字，正是由于这两种情况的存在，所以需要第二个循环
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		
		fast = 0;
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
    }
	
}
