/**
 * (5ms)
 * 这个方法就是用一个长度为3的ans数组来存储数据，遍历原数组，如果ans数组长度小于3，且不与ans中
 * 的数组相同就添加到ans数组中，如果ans数组已满，就找出最小的数字，判断该数字是否比ans数组中
 * 最小的数字大，如果大的话就更新。
 * @author Phoenix-Z
 *
 */
public class ThirdMaximumNumber {

	public int thirdMax(int[] nums) {
		int[] ans = new int[3];
		int len = 0;
		for(int i = 0; i < nums.length; i++) {
			int j;
			for(j = 0; j < len; j++) {
				if(nums[i] == ans[j]) 
					break;
			}
			if(j == len) {
				if(len < 3) {
					ans[len++] = nums[i]; 
				} else {
					int minIndex = 0;
					for(int k = 1; k < 3; k++) {
						if(ans[minIndex] > ans[k]) {
							minIndex = k;
						}
					}
					if(nums[i] > ans[minIndex])
						ans[minIndex] = nums[i];
				}
			}
		}
		if(len == 1)
			return ans[0];
		if(len == 2)
			return Math.max(ans[0], ans[1]);
		return Math.min(ans[0], Math.min(ans[1], ans[2]));
    }
	
	public static void main(String[] args) {
		int[] nums = {5,2,4,1,3,6,0};
		System.out.println(new ThirdMaximumNumber().thirdMax(nums));
	}
}