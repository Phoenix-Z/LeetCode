/**
 * (4ms)
 * 这个方法也很有意思，使用了三个变量max，mid，min分别表示最大值，中间值，最小值。
 * 这有点像右移位的意思，如果大于最大值，就从最大值开始移位，如果大于中间值，就从中间值开始移位，
 * 以此类推。因此最后的时间复杂度为O(n)，空间复杂度为O(1)。
 * @author Phoenix-Z
 *
 */
public class ThirdMaximumNumber2 {

	public int thirdMax(int[] nums) {
		//这里将三个变量声明为long，是因为，数组元素有可能为int型的最小值
		long max = Long.MIN_VALUE, mid = max, min = max;

		for (int ele : nums) {
			if (ele > max) {
				min = mid;
				mid = max;
				max = ele;
			} else if (max > ele && ele > mid) { 
				//注意这里加了max>ele的判断，是为了避免等于max的值出现在mid上，即去重
				min = mid;
				mid = ele;
			} else if (mid > ele && ele > min) {
				min = ele;
			}
		}

		//如果min依然是long型的最小值，就说明nums数组中只有一种或两种元素，返回最大值即可
		//如果min不为long型的最小值，就说明nums数组中至少存在三种元素，返回第三大的元素
		return (int) (min != Long.MIN_VALUE ? min : max);
	}

}