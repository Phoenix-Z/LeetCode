/**
 * (6ms)
 * 这个方法相对容易理解一些，它使用了二分搜索的方法。比如说n等于10，一个有11个数字，搜索的初始范围是[1, 10]。首先考察中间值5，
 * 统计有多少个数字小于等于5，个数记为count。如果count大于5，那么由鸽巢原理，一定有一个小于等于5的数字重复出现了，那么就可以
 * 把搜索范围缩减为[1, 5]。如果count<=5,那么就说明1到5这五个数字每个数字只出现了一次，或者没有出现，那么我们的搜索范围就可以
 * 缩减为[6, 10]。以此类推。
 * 时间复杂度为O(nlogn),空间复杂度为O(1)。
 * @author Phoenix-Z
 *
 */
public class FindTheDuplicateNumber2 {

	public static int findDuplicate(int[] nums) {
		if(nums == null || nums.length < 2)
			return -1;
		int left = 0, right = nums.length;
		while(left < right) {
			int mid = (left + right) / 2;
			int count = 0;
			for(int num : nums) {
				if(num <= mid)
					count++;
			}
			if(count > mid) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
    }
	
	public static void main(String[] args) {
		int[] nums = {4, 1, 3, 2, 2, 5};
		System.out.println(findDuplicate(nums));
	}
}
