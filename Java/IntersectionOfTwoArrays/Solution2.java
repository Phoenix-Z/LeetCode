import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * (6ms)
 * 方法二：先将nums1中的所有元素添加到midAns的Set中，然后遍历nums2中的所有元素，查看其是否在midSet中，
 * 若存在，则属于交集，添加到ans集中，即为最后的结果。
 * 从代码上看是O(n)的时间复杂度，但由于Set的Contains的实现可能也是O(n)的，所以其运行速度会方法三中O(n * log n)慢些。
 */
public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        //中间结果集
        Set<Integer> midAns = new HashSet<>(nums1.length);
        //最终结果集
        Set<Integer> ans = new HashSet<>();

        //将nums1中的所有元素添加至中间结果集中
        for (Integer num : nums1) {
            midAns.add(num);
        }

        //遍历nums2中的元素，若在中间结果集，就将其添加至最终结果集中
        for (Integer num : nums2){
            if(midAns.contains(num))
            {
                ans.add(num);
            }
        }

        //以下是将Set转成int[]的固定过程
        int[] result = new int[ans.size()];
        int i =0;
        for (Integer num : ans) {
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new Solution2().intersection(nums1, nums2)));
    }
}