/**
 * (15ms)
 * 这可能是一个假的medium题。
 * @author Phoenix-Z
 *
 */
public class PerfectNumber {

	public static boolean checkPerfectNumber(int num) {
		if(num == 1) {
			return false;
		}
        int end = (int) Math.sqrt(num);
        int sum = 1;
        for(int i = 2; i <= end; i++) {
        	if(num % i == 0) {
        		sum += i + num / i;
        	}
        }
        return sum == num;
    }
	
	public static void main(String[] args) {
		System.out.println(checkPerfectNumber(28));
	}
	
}
