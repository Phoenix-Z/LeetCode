/**
 * (10ms)
 * 贪心而已。
 * Created by Phoenix-Z on 2017/6/2.
 */
public class OptimalDivision {

    public static String optimalDivision(int[] nums) {
        StringBuilder ans = new StringBuilder();
        ans.append(nums[0]);
        if(nums.length == 2) {
            ans.append('/');
            ans.append(nums[1]);
        }
        if(nums.length > 2) {
            ans.append("/(");
            for (int i = 1; i < nums.length; i++) {
                ans.append(nums[i]);
                if(i < nums.length - 1)
                    ans.append('/');
            }
            ans.append(')');
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1000,100,10,2};
        System.out.println(optimalDivision(nums));
    }
}
