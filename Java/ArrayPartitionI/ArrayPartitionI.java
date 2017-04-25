import java.util.Arrays;

/**
 * (34ms)
 * Created by Phoenix-Z on 2017/4/25.
 */
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
