/**
 * (2ms)
 * 这个方法的基本思路跟之前的是一样的，只不过对于较短的版本号，采取了补0的方式，比如原来是1.1和1，
 * 在比较过程中会把1变成1.0，从而减少了if语句的使用，效率上也有所提高。
 * @author Phoenix-Z
 *
 */
public class CompareVersionNumbers2 {

	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
			int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
			int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
			if (num1 < num2) {
				return -1;
			} else if (num1 > num2) {
				return 1;
			}
		}

		return 0;
	}

}