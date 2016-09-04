import java.util.Arrays;
import java.util.HashMap;

/**
 * (5ms)
 * 方法三：
 * 这种做法借助了一个HashMap,将已经访问过的元素放入到HashMap中，充分利用信息，因此可以提高效率.
 * 表面上看这种做法的时间复杂度是O(n),但由于HashMap的存储和查询需要一定的时间，因此比方法二稍微慢些.
 * 和方法一对比：
 * 方法一对于数组中的每一个元素都查看其他所有元素与其相加是否等于target，所以是n*n的复杂度
 * 方法三对于数组中的每一个元素只查找是否存在target - n这一个元素，而查询速度的提高得益于HashMap，所以是n * 1的复杂度
 * @author Phoenix-Z
 *
 */
public class Solution3 {
	public int[] twoSum(int[] nums, int target)
	{
		//默认返回值为[-1, -1]
		int[] ans = {-1, -1};
		int len = nums.length;
		
        HashMap<Integer, Integer> numsWithIndexes = new HashMap<>(len);
        
        //假设 m + n = target
        for(int i = 0; i < len; i++){
        	//令当前值为n
            int n = nums[i];
            
            //在HashMap中找 m(target - n)
            Integer mIndex = numsWithIndexes.get(Integer.valueOf(target - n));
            
            //若在HashMap中找到了，即找到了所需要的解
            if(mIndex != null) {
            	//注意这里面的赋值顺序，出现在HashMap中的索引mIndex一定已经遍历过了，所以比 i 小
                ans[0] = mIndex;
                ans[1] = i;
                return ans;
            } 
            //如果没有找到，就将n和它的索引放入HashMap中
            else{ 
                numsWithIndexes.put(Integer.valueOf(n), Integer.valueOf(i));
            }
        }
        return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(new Solution3().twoSum(nums, target)));
	}
}
