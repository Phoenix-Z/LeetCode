import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * (5ms)
 * 方法三：
 * 这种方法是最快的，它首先将两个数组都从小到大排序(时间复杂度O(n * log n))，
 * 然后使用两个指针，遍历数组，如果两个指针指向的元素相等，就将其放入到结果集中
 * 如果一个指针指向的元素小于另一个，则这个指针向前进一格，另一个留在原地。
 */
public class Solution3 {
    public int[] intersection(int[] nums1, int[] nums2) {
        //最终结果集
        Set<Integer> ans = new HashSet<>();

        //对两个数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //两个指针i和j，一开始都指向数组第一个元素
        int i = 0, j = 0;

        //如果一个数组遍历完了，而另一个没有，则说明另一个数组中剩下来的元素肯定大于当前数组中的所有元素，也就没有必要继续了
        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] < nums2[j]){
                i++;
            }
            else if (nums1[i] > nums2[j]){
                j++;
            }
            //元素相等，就将其加入到结果集中，两个指针同时前进一格
            else {
                ans.add(nums1[i]);
                i++;
                j++;
            }
        }

        //以下是将Set转成int[]的固定过程
        int[] result = new int[ans.size()];
        i =0;
        for (Integer num : ans) {
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new Solution3().intersection(nums1, nums2)));
    }
}