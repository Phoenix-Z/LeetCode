import java.util.HashSet;
import java.util.Set;

/**
 * (14ms)
 * 方法一：
 * 将nums中的数字添加到Set中，如果Set中元素的个数与nums的长度不同，说明存在元素至少出现两次
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (Integer num : nums) {
            set.add(num);
        }

        return set.size() != nums.length;
    }

}