import java.util.ArrayList;
import java.util.List;

/**
 * (26ms)
 * Created by Phoenix-Z on 2017/4/26.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void helper(List<List<Integer>> ans, ArrayList<Integer> now, int[] candidates, int target, int pos) {
        if(target == 0) {
            ans.add(new ArrayList<>(now));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = pos; i < candidates.length; i++) {
            now.add(candidates[i]);
            helper(ans, now, candidates, target - candidates[i], i);
            now.remove(now.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum test = new CombinationSum();
        System.out.println(test.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
