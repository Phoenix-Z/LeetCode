/**
 * (13ms)
 * 这个方法时间复杂度为O(n)
 * Created by Phoenix-Z on 2017/6/25.
 */
public class MaximumProductOfThreeNumbers2 {

    public int maximumProduct(int[] nums) {
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if(num < firstMin) {
                secondMin = firstMin;
                firstMin = num;
            } else if(num < secondMin){
                secondMin = num;
            }

            if(num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax){
                thirdMax = num;
            }
        }
        return Math.max(firstMin * secondMin * firstMax, firstMax * secondMax * thirdMax);
    }
    
}
