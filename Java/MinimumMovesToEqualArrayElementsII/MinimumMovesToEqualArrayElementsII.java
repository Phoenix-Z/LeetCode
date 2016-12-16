import java.util.Arrays;
/**
 * (9ms)
 * 这道题目需要先进行排序，然后这个数组是从小到大排序的了，可以把这些数字想象成，以数组下表为x轴，数组元素的
 * 数值为y轴，分布在坐标平面上。考虑通过move操作之后，数组的元素有一个相同的值，我们可以把这个值想象成一条
 * 水平线，move的次数等于所有的点到这条水平线的垂直距离。考虑其中的两点，如果这两点在水平线的同一侧，
 * 那么这两点到水平线的距离之和，等于两点之间的垂直距离加上两倍的离水平线较近的点的距离。但是如果两点分居
 * 水平线的两侧，那么两点到水平线的距离就等于两点之间的垂直距离。基于此，我们应该使数组元素平均的分布在
 * 水平线的两侧，那么move的次数等于成对的点间的垂直距离。
 * 所以在下面的代码中，让最大值与最小值配对，逐渐像数组中间靠拢，如果数组元素个数为奇数，那么水平线就应该
 * 放置在中位数上，如果元素个数为偶数，水平线应该是最中间的两个数的平均值。
 * 由于需要先进行排序，所以算法的时间复杂度为O(nlogn).
 * @author Phoenix-Z
 *
 */
public class MinimumMovesToEqualArrayElementsII {

	public int minMoves2(int[] nums) {
		int minMoves = 0;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length / 2; i++) {
			minMoves += nums[nums.length - 1 - i] - nums[i];
		}
		return minMoves;
    }
	
}