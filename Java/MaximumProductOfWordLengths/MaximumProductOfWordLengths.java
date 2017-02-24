/**
 * (23ms)
 * 这个方法非常的精妙，它是将每个字母映射到某一个bit位上，int有32位，足够26个字母使用。这里对于每一个字符串，
 * 如果某一个字母出现了，那么某一位就置1。如果两个字符串不含有相同字母，那么映射成的数字就不会有某一位同时置1，
 * 从而这两个数字的与运算的结果是0，从而可以判断。
 * 时间复杂度为O(n^2),空间复杂度为O(n)。
 * @author Phoenix-Z
 *
 */
public class MaximumProductOfWordLengths {

	public int maxProduct(String[] words) {
		if(words == null || words.length < 2) {
			return 0;
		}
		int[] bitDiff = new int[words.length];
		for(int i = 0; i < words.length; i++) {
			for(int j = 0; j < words[i].length(); j++) {
				bitDiff[i] |= 1 << (words[i].charAt(j) - 'a');
			}
		}
		int max = 0;
		for(int i = 0; i < bitDiff.length; i++) {
			for(int j = 0; j < bitDiff.length; j++) {
				if((bitDiff[i] & bitDiff[j]) == 0) {
					int product = words[i].length() * words[j].length();
					if(product > max) {
						max = product;
					}
				}
			}
		}
		return max;
    }
	
}
