/**
 * (3ms) 
 * 这个方法跟上一个方法基本一致，只是使用了一个数组而不是两个数组来统计次数，代码也相对简洁。
 * @author Phoenix-Z
 *
 */
public class BullsAndCows2 {

	public String getHint(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		int[] numbers = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i))
				bulls++;
			else {
				//这里很巧妙，这是为什么使用一个数组就行。
				if (numbers[secret.charAt(i) - '0']++ < 0)
					cows++;
				if (numbers[guess.charAt(i) - '0']-- > 0)
					cows++;
			}
		}
		return bulls + "A" + cows + "B";
	}

}