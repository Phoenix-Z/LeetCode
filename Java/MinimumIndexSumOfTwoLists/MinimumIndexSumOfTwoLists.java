import java.util.*;

/**
 * (28ms)
 * Created by Phoenix-Z on 2017/5/29.
 */
public class MinimumIndexSumOfTwoLists {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> ans = new ArrayList<>();
        int minIndex = list1.length + list2.length;
        for (int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                if(i + j < minIndex) {
                    ans = new ArrayList<>();
                    ans.add(list2[i]);
                    minIndex = i + j;
                } else if(i + j == minIndex){
                    ans.add(list2[i]);
                }
            }
        }
        String[] res = new String[ans.size()];
        ans.toArray(res);
        return res;
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }
}
