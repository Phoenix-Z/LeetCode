/**
 * (3ms)
 * 方法三：
 * 不出意外，这个方法是最快的。思路和Two Sum的方法二一样，O(n)的时间复杂度。
 */
public class Solution3 {
    public boolean containsDuplicate(int[] nums) {
        //当数组为空时，直接返回false
        if(nums.length == 0) {
            return false;
        }
        //找出最小值和最大值，最小值是关键，因为要确保索引大于等于0.最大值是为了方便获取数组长度，以节省运行内存。
        int min = nums[0], max = nums[0];
        for(int num : nums)
        {
            if(min > num)
                min = num;
            if(max < num)
                max = num;
        }

        //exist数组是用来标记num是否存在，缺省值为false
        boolean[] exist = new boolean[max - min + 1];

        for(int num : nums){
            if(exist[num - min]) {
                return true;
            }
            exist[num - min] = true;
        }

        return false;
    }
}