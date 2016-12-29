import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * (252ms)
 * 就是随机排列，感觉没什么实际意义。
 * @author Phoenix-Z
 *
 */
public class ShuffleAnArray {

	private int[] original;
    private int[] changable;

    public ShuffleAnArray(int[] nums) {
        original = Arrays.copyOf(nums, nums.length);
        changable = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        changable = Arrays.copyOf(original, original.length);
        return changable;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	List<Integer> list = new ArrayList<>();
    	for(int num : changable) {
    		list.add(num);
    	}
    	Collections.shuffle(list);
    	for(int i = 0; i < changable.length; i++) {
    		changable[i] = list.get(i);
    	}
        return changable;
    }
	
    public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		ShuffleAnArray obj = new ShuffleAnArray(nums);
		int[] param_1 = obj.reset();
		System.out.println(Arrays.toString(param_1));
		int[] param_2 = obj.shuffle();
		System.out.println(Arrays.toString(param_2));
		int[] param_3 = obj.reset();
		System.out.println(Arrays.toString(param_3));
	}
}