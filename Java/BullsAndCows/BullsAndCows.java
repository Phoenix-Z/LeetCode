/**
 * (3ms)
 * 这个方法只扫描这两个字符串一次，如果两个字符串同一位置上的字符相同，bull值就加一，
 * 如果不相同就统计这两个字符串上的字符出现的次数。
 * @author Phoenix-Z
 *
 */
public class BullsAndCows {

	public String getHint(String secret, String guess) {
		int[] countA = new int[10];
		int[] countB = new int[10];
		int countOfA = 0;
		int countOfB = 0;
		for(int i = 0; i < secret.length(); i++) {
			if(secret.charAt(i) == guess.charAt(i))
				countOfA++;
			else {
				countA[secret.charAt(i) - '0']++;
				countB[guess.charAt(i) - '0']++;
			}
		}
		for(int i = 0; i < 10; i++) {
			countOfB += Math.min(countA[i], countB[i]);
		}
		String hint = countOfA + "A" + countOfB + "B";
		return hint;
    }
	
	public static void main(String[] args) {
		String secret = "1123";
		String guess = "0111";
		System.out.println(new BullsAndCows().getHint(secret, guess));
	}
}