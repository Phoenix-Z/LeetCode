/**
 * (1ms)
 * 这道题的关键在于理解题意，被pick出来的数字小于传入的num小时返回-1，
 * 也就是说如果传入的num大了就返回-1，传入的num小了就返回1，相等时返回0.
 * 这道题的思路就是二分搜索，需要注意的是取中点的时候不能直接左端点加上右端点然后除以2，
 * 因为这很容易就超过int的范围，导致结果不正确。
 * @author Phoenix-Z
 *
 */
public class GuessNumberHigherOrLower extends GuessGame {

	/* The guess API is defined in the parent class GuessGame.
	   @param num, your guess
	   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
	      int guess(int num); */
	public int guessNumber(int n) {
		int ans = (1 + n) / 2;
		int left = 1, right = n;
		while(left <= right) {
			ans = left + (right - left) / 2;
			if(guess(ans) == 0)
				break;
			else if(guess(ans) == -1) {
				right = ans;
			} else {
				left = ans + 1;
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		System.out.println(new GuessNumberHigherOrLower().guessNumber(2));
	}
}

class GuessGame {
	private static int pickedNum = 2;
	public int guess(int num) {
		if(pickedNum < num)
			return -1;
		else if (pickedNum > num) {
			return 1;
		}
		return 0;
	}
}