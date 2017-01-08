/**
 * (14ms)
 * 这个方法就是方法一的改进版，既然只需要建立字母和数字之间的一一对应关系，那么只需要统计我们需要的字母出现的
 * 次数，一旦先计算出每个数字出现的次数，就可以按照数字的顺序进行添加了。
 * @author Phoenix-Z
 *
 */
public class ReconstructOriginalDigitsFromEnglish2 {

	public static String originalDigits(String s) {
		int[] count = new int[10];
		for (char c : s.toCharArray()) {
			switch (c) {
			case 'z':
				count[0]++;
				break;
			case 'w':
				count[2]++;
				break;
			case 'x':
				count[6]++;
				break;
			case 's':
				count[7]++;
				break;// 7-6
			case 'g':
				count[8]++;
				break;
			case 'u':
				count[4]++;
				break;
			case 'f':
				count[5]++;
				break; // 5-4
			case 'h':
				count[3]++;
				break; // 3-8
			case 'i':
				count[9]++;
				break;// 9-8-5-6
			case 'o':
				count[1]++; // 1-0-2-4
			}
		}
		count[7] -= count[6];
		count[5] -= count[4];
		count[3] -= count[8];
		count[9] = count[9] - count[8] - count[5] - count[6];
		count[1] = count[1] - count[0] - count[2] - count[4];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j < count[i]; j++) {
				sb.append(i);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "owtneo";
		System.out.println(originalDigits(s));
	}
}
