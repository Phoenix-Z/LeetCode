/**
 * (22ms)
 * Created by Phoenix-Z on 2017/7/19.
 */
public class MaximumAverageSubarrayI {

    public static double findMaxAverage(int[] nums, int k) {
        double nowSum = 0;
        for(int i = 0; i < k; i++) {
            nowSum += nums[i];
        }
        double maxSum = nowSum;
        int head = k, tail = 0;
        while(head < nums.length) {
            nowSum = nowSum - nums[tail] + nums[head];
            if(nowSum > maxSum)
                maxSum = nowSum;
            head++;
            tail++;
        }
        return maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));
    }
}
