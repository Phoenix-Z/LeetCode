/**
 * (296ms)
 * 这个算法的时间复杂度为O(n^2)，空间复杂度为O(n)
 * Created by Phoenix-Z on 2017/5/13.
 */
public class SubarraySumEqualsK {


    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] prevSum = new int[nums.length + 1];
        for(int i = 0; i< nums.length; i++) {
            for(int j = i + 1; j > 0; j--) {
                prevSum[j] = prevSum[j - 1] + nums[i];
                if(prevSum[j] == k)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(subarraySum(nums, 2));
    }

}
