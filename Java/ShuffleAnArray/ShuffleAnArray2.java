import java.util.Random;
/**
 * (236ms)
 * 只是另一种做法。
 * @author Phoenix-Z
 *
 */
public class ShuffleAnArray2 {

	private int[] nums;
    private Random random;

    public ShuffleAnArray2(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null) return null;
        int[] a = nums.clone();
        for(int j = 1; j < a.length; j++) {
        	//注意这里是j+1，因为nextInt返回的是0-j的整数，如果传入的参数是j的话，就可以随机到原始顺序
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }
    
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
	
}