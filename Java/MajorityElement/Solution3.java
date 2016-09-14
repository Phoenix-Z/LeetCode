/**
 * (2ms)Boyer-Moore Vote Algorithm
 * 方法三：
 * 这个方法采用了上述的算法，时间复杂度为O(n)，空间复杂度为O(1)，
 * 详细过程可以看维基百科
 * https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
 * @author Phoenix-Z
 *
 */

public class Solution3 {

	public int majorityElement(int[] nums) {
        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
	
}