/**
 * (11ms)
 * 这个方法的思路和之前那个是一致的，只不过先遍历了一遍数组找到最小值，而不是先排序，
 * 所以时间复杂度是O(n)，因此效率更高一点。当然可以通过一定的方法将两个循环变成一个循环，
 * 但是可读性不及这个版本。
 * @author Phoenix-Z
 *
 */
public class MinimumMovesToEqualArrayElements2 {

	public int minMoves(int[] nums) {
		int moves = 0;
		int min = nums[0];
		//找到最小值
		for(int num : nums) {
			if(num < min)
				min = num;
		}
		//找到最小移动次数
		for(int num : nums) {
			moves += num - min;
		}
		return moves;
    }
	
}