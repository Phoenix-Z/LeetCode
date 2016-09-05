import java.util.HashMap;
import java.util.Map;
/**
 *(11ms)
 * 方法二：
 * 这个方法实际上与其他两种方法有相似之处，比方法一好在当发现存在重复元素直接返回，而不用将所有元素加入到map中
 * 而比方法三好在代码简洁，但是HashMap的存取会消耗一定的时间。
 */
public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer num : nums){
            if(map.get(num) != null) {
                return true;
            }
            map.put(num, num);
        }
        return false;
    }
}