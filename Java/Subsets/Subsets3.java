import java.util.ArrayList;
import java.util.List;

/**
 * (3ms)
 * 这个方法也挺好的，借助了额外的list。
 * Created by Phoenix-Z on 2017/5/3.
 */
public class Subsets3 {

    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int i : S) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }

}
