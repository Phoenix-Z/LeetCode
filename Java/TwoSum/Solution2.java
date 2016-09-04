import java.util.Arrays;

/**
 * (2ms)
 * 方法二：
 * 这种做法实际上就是通过一维数组map来实现HashMap的作用，而由于没有HashMap的操作，
 * 实际的时间复杂度就是O(n),因此运行速度比方法三还要快
 * 为什么要求最小值和最大值？
 * 由于map的索引用来存放nums数组的值（键），而map存放nums中的索引（值）
 * 而nums中的数组中很可能存在负值，所以需要求出最小值，将数组整体平移|min|个单位，而max控制着map数组的长度
 * @author Phoenix-Z
 *
 */
public class Solution2 {
	public int[] twoSum(int[] nums, int target)
	{
		int[] ans = {-1, -1};
		int len = nums.length;
		
		//找出nums中的最大值和最小值
		int max = nums[0], min = nums[0];
		for (int i = 1; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

		//mi表示索引至少平移多少个单位才能防止索引出现负值
        int mi = Math.min(min, target - max);
        //ma表示索引的上界
        int ma = Math.max(max, target - min);

        int[] map = new int[ma - mi + 1];
        //由于数组的索引为非负数，因此给map赋值为-1，
        //如果map某一索引对应的值为-1，说明该索引暂时不在nums数组中
        Arrays.fill(map, -1);
       
        //target需要相应的平移
        target = target - mi;
        
        //以下for-loop中的思路和方法三是一致的
        for (int i = 0; i < len; i++) {
            int key = target - nums[i];
            if (map[key] != -1) {
            	ans[0] = map[key];
            	ans[1] = i;
                return ans;
            } else {
                map[nums[i] - mi] = i;
            }
        }
        
        return ans; 
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(new Solution2().twoSum(nums, target)));
	}
}
