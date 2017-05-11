import java.util.HashMap;
import java.util.Map;

/**
 * (133ms)
 * 首先对数组求和，如果和为奇数，那么不可能分成和相等的两个分组。如果和为奇数，就将target设置为和的一半，然后查看是否有子集和
 * 等于target。这里使用了一个Map存储中间值，避免重复计算，否则会TLE。
 * Created by Phoenix-Z on 2017/5/10.
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0)
            return false;
        int target = sum / 2;
        return findSubset(nums, target, 0, new HashMap<>());
    }

    private boolean findSubset(int[] nums, int target, int pos, Map<Integer, Boolean> part) {
        if(target < 0)
            return false;
        if(target == 0)
            return true;
        boolean exist = false;
        for(int i = pos + 1; i < nums.length; i++) {
            boolean res;
            if(part.containsKey(target - nums[i])) {
                res = part.get(target-nums[i]);
            } else {
                res = findSubset(nums, target - nums[i], i, part);
                part.put(target - nums[i], res);
            }
            exist |= res;
        }
        return exist;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 5, 11};
        PartitionEqualSubsetSum test = new PartitionEqualSubsetSum();
        System.out.println(test.canPartition(nums));
    }

}
