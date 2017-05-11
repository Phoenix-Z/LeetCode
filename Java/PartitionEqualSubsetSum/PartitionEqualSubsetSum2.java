/**
 * (23ms)
 * java的Map是有多慢。。。
 * Created by Phoenix-Z on 2017/5/10.
 */
public class PartitionEqualSubsetSum2 {

    private int[] flag;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0)
            return false;
        int target = sum / 2;
        flag = new int[target + 1];
        return findSubset(nums, target, 0);
    }

    private boolean findSubset(int[] nums, int target, int pos) {
        if(target == 0)
            return true;
        boolean exist = false;
        for(int i = pos + 1; i < nums.length; i++) {
            if(target >= nums[i]) {
                boolean res;
                if(flag[target - nums[i]] == 0) {
                    res = findSubset(nums, target - nums[i], i);
                    flag[target - nums[i]] = res ? 1 : -1;
                } else {
                    res = flag[target - nums[i]] == 1 ? true : false;
                }
                exist |= res;
            }
        }
        return exist;
    }

}
