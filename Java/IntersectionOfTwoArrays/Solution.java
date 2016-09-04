import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 方法一：
 * 遍历nums1数组中的所有元素，然后在nums2中查找是否有这个元素，如果有就添加到Set中
 * 查找的方法可以是遍历整个nums2数组，这样时间复杂度就是O(n^2),性能较差
 * 改进的方法就是使用Arrays提供的二分搜索（binarySearch），如果有，返回值应该大于等于0，否则小于0
 * 但是在二分搜索之前需要进行排序，二分搜索的时间复杂度为O(log n)，而排序算法的时间复杂度为O(n * log n)
 * 所以这种方法最好的时间复杂度为O(n * log n)
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<>();
        //对nums2数组二分搜索前需要排序
        Arrays.sort(nums2);

        for (Integer num : nums1) {
            //若num在nums2中，则返回其索引，故返回值应该大于等于0
            if(Arrays.binarySearch(nums2, num) >= 0){
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
        System.out.println(Arrays.toString(new Solution().intersection(nums1, nums2)));
    }
}