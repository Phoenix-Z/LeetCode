/**
 * (0ms)
 */
public class SortColors {

    public void sortColors(int[] nums) {
    	int numOfZero = 0, numOfOne = 0, numOfTwo = 0;
        for(int num : nums) {
        	if(num == 0) {
        		numOfZero++;
        	} else if(num == 1) {
        		numOfOne++;
        	} else {
        		numOfTwo++;
        	}
        }
        for(int i = 0; i < numOfZero; i++) {
        	nums[i] = 0;
        }
        for(int i = 0; i < numOfOne; i++) {
        	nums[i + numOfZero] = 1;
        }
        for(int i = 0; i < numOfTwo; i++) {
        	nums[i + numOfZero + numOfOne] = 2;
        }
    }
}