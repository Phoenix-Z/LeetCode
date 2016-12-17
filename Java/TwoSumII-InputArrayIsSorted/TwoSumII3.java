import java.util.Arrays;
/**
 * (1ms)
 * 这个方法是解决这个问题的最优解，它采用了双指针技术，一个指针left从前往后遍历，一个指针right从后往前遍历，
 * 由于数组已经排序过了，当left指针前进一步，两个元素之和变大；当right指针后退一步，两个元素之和变小。
 * 所以在遍历的同时可以将两个元素之和与target相比，如果比target大，right指针后退一步；如果比target小，
 * left指针前进一步；如果和target相等，就找到了目标元素，返回即可。
 * 当然这个解法也是基于重复元素不会超过两个这一事实的(即答案只有唯一解)，算法的时间复杂度为O(n)。
 * @author Phoenix-Z
 *
 */
public class TwoSumII3 {

	public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        int left = 0, right = numbers.length - 1;
        while(left < right) {
        	int now = numbers[left] + numbers[right];
        	if(now == target) {
        		index[0] = left + 1;
        		index[1] = right + 1;
        		break;
        	} else if (now < target) {
				left++;
			} else {
				right--;
			}
        }
        return index;
    }
	
	public static void main(String[] args) {
		int[] numbers = {2, 3, 4};
		int target = 6;
		System.out.println(Arrays.toString(new TwoSumII3().twoSum(numbers, target)));
	}
}