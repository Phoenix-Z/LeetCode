import java.util.ArrayList;
import java.util.List;

/**
 * (2ms)
 * 这是个递归的做法。
 * Created by Phoenix-Z on 2017/5/3.
 */
public class Subsets{

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++) {
            helper(ans, new ArrayList<>(), nums, 0, i);
        }
        return ans;
    }

    // size表示子集的长度，长度为从0到nums的length的整数
    private void helper(List<List<Integer>> ans, List<Integer> now, int[] nums, int pos, int size) {
        if(now.size() == size)
            ans.add(new ArrayList<>(now));
        if(pos >= nums.length || now.size() > size)
            return;
        for(int i = pos; i < nums.length; i++) {
            now.add(nums[i]);
            helper(ans, now, nums, i + 1, size);
            now.remove(now.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets test = new Subsets();
        int[] nums = {1};
        System.out.println(test.subsets(nums));
    }
}
