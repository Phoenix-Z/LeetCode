import java.util.ArrayList;
import java.util.List;

/**
 * (65ms)
 * 这个算法是一个O(n^2)的算法，虽然代码简洁，但是效率一般
 * Created by Phoenix-Z on 2017/5/29.
 */
public class MinimumIndexSumOfTwoLists2 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList<>();
        for(int sum = 0; sum < list1.length + list2.length - 1; sum++) {
            for(int i = 0; i <= sum; i++) {
                if(i < list1.length && sum - i < list2.length &&
                        list1[i].equals(list2[sum - i]))
                    ans.add(list1[i]);
            }
            if(ans.size() > 0)
                break;
        }
        return ans.toArray(new String[ans.size()]);
    }

}
