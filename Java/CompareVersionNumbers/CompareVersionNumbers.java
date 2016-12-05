/**
 * (3ms)
 * 这个解法就是先根据点号(".")对原始字符串进行分割，然后再对两个字符串数组逐一比较。
 * @author Phoenix-Z
 *
 */
public class CompareVersionNumbers {

	public int compareVersion(String version1, String version2) {
		//这里是本题需要注意的，根据点号分割字符串时，需要先转义
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int pointer = 0;
		//对两个字符串数组逐一比较
		while(pointer < v1.length && pointer < v2.length) {
			if(Integer.parseInt(v1[pointer]) < Integer.parseInt(v2[pointer])) {
				return -1;
			} else if(Integer.parseInt(v1[pointer]) > Integer.parseInt(v2[pointer])) {
				return 1;
			}
			pointer++;
		}
		//考虑1.0和1相等，或者1.1与1不相等的情况
		if(v1.length < v2.length) {
			for(int i = v1.length; i < v2.length; i++) {
				if(Integer.parseInt(v2[i]) != 0)
					return -1;
			}
		} else if(v1.length > v2.length) {
			for(int i = v2.length; i < v1.length; i++) {
				if(Integer.parseInt(v1[i]) != 0)
					return 1;
			}
		}
		return 0;
    }
	
	public static void main(String[] args) {
		String version1 = "1.0";
		String version2 = "1";
		System.out.println(new CompareVersionNumbers().compareVersion(version1, version2));
	}
}