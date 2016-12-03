import java.util.Arrays;
/**
 * (36ms)
 * 这道题目的解题思路大致是一样的，只是在部分细节的处理上有些许不同，才导致效率不同。
 * 题目中说每给n-1个数字加一，可以等价的想成先给其中一个数减1，然后再给所有的数加一。
 * 这样，我们自然可以想到以最小值为基准，其他所有的数组都通过减一的方式减至最小值，那么最后的数组一定是
 * 相等的(因为加一是所有数字一起加的)，所以这道题目的答案就是数组中所有数字与最小值之差的和。
 * 这个解法是先给数组排序，自然数组的第一个数字就是最小值，但是时间复杂度是O(nlogn)
 * @author Phoenix-Z
 *
 */
public class MinimumMovesToEqualArrayElements {

	public int minMoves(int[] nums) {
		Arrays.sort(nums);
		int moves = 0;
		for(int i = nums.length - 1; i >= 1; i--) {
			moves += nums[i] - nums[0];
		}
		return moves;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(new MinimumMovesToEqualArrayElements().minMoves(nums));
	}
}