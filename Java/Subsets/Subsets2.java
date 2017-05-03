import java.util.ArrayList;
import java.util.List;

/**
 * (2ms)
 * 这个方法颇具巧思，一个集合(长度为n)的子集个数为2^n个，那么可以用二进制数来标记是否需要将某个位置的数字添加到当前子集中，
 * 可以参见https://discuss.leetcode.com/topic/2764/my-solution-using-bit-manipulation/7中的解释。
 * 不过这个方法依然有局限性，如果集合长度超过32个，这个代码就不再适用了。
 * Created by Phoenix-Z on 2017/5/3.
 */
public class Subsets2 {

    public static List<List<Integer>> subsets(int[] nums) {
        int ansSize = (int) Math.pow(2, nums.length);
        List<List<Integer>> ans = new ArrayList<>(ansSize);
        for(int i = 0; i < ansSize; i++) {
            List<Integer> now = new ArrayList<>();
            for(int j = 0; j < nums.length; j++) {
                if((i >> j & 1) == 1) {
                    now.add(nums[j]);
                }
            }
            ans.add(now);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{3, 1, 2}));
    }
}
