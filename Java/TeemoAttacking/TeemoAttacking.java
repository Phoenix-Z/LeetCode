/**
 * (11ms)
 * 这个题目比较简单，时间复杂度为O(n),空间复杂度为O(1)。
 * @author Phoenix-Z
 *
 */
public class TeemoAttacking {

	public static int findPoisonedDuration(int[] timeSeries, int duration) {
		if(timeSeries.length == 0) {
            return 0;
        }
		int left = timeSeries[0], right = timeSeries[0] + duration; 
		int totalTime = 0;
		for(int i = 1; i < timeSeries.length; i++) {
			if(right >= timeSeries[i]) {
				right = timeSeries[i] + duration;
			} else {
				totalTime += right - left;
				left = timeSeries[i];
				right = timeSeries[i] + duration;
			}
		}
		totalTime += right - left;
		return totalTime;
    }
	
	public static void main(String[] args) {
		int[] timeSeries = {1, 4};
		System.out.println(findPoisonedDuration(timeSeries, 2));
	}
}
