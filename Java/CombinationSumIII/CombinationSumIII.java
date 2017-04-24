import java.util.ArrayList;
import java.util.List;

/**
 * (1ms)
 * Created by Phoenix-Z on 2017/4/24.
 */
public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), k, n);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> now, int nowK,int nowN) {
        if(nowK == 0 && nowN == 0) {
            ans.add(new ArrayList<>(now));
            return;
        }
        if(nowK < 0 || nowN < 0)
            return;
        for(int i = now.isEmpty() ? 1 : now.get(now.size() - 1) + 1; i <= 9; i++) {
            now.add(i);
            dfs(ans, now, nowK - 1, nowN - i);
            now.remove(now.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII test = new CombinationSumIII();
        System.out.println(test.combinationSum3(3, 9));
    }
}
