/**
 * (10ms)
 * 这个方法很简单，就是遍历整个数组，在遍历的同时更新最长1的个数。一旦遇到0，count值就复位。
 * 时间复杂度为O(n),空间复杂度为O(1)
 * @author Phoenix-Z
 *
 */
public class MaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int maxCount = count;
		for(int num : nums) {
			if(num == 1) {
				count++;
				maxCount = count > maxCount ? count : maxCount;
			} else {
				count = 0;
			}
		}
		return maxCount;
    }
	
}
