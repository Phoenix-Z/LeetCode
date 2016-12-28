/**
 * (22ms) 
 * 汉明距离主要关心的是，两个数字某一位上一个是0，而另一个是1。假设数组长度为n，分别研究整型的每一位，
 * 如果在某一位上有k个数是1，那么有n-k个数是0，那么就有k * (n-k)次机会汉明距离会加一，所以只要将这32位 
 * 所有的k * (n - k)相加就是我们所需要的结果。
 * 时间复杂度为O(n)
 * @author Phoenix-Z
 *
 */
public class TotalHammingDistance {

	public static int totalHammingDistance(int[] nums) {
		int total = 0, n = nums.length;
		for (int j = 0; j < 32; j++) {
			//bitCount表示在当前这一bit位上，有多少个是1的数字
			int bitCount = 0;
			for (int i = 0; i < n; i++)
				bitCount += (nums[i] >> j) & 1;
			total += bitCount * (n - bitCount);
		}
		return total;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 14, 2 };
		System.out.println(totalHammingDistance(nums));
	}
}