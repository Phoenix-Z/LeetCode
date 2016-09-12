/**
 * (0ms)
 * �����˼·��remove element�ķ�������������һ�µģ����ǽ���0ֵ��ͷ��ʼ���ǣ�Ȼ���ٲ�0���ɡ�
 * @author Phoenix-Z
 *
 */
public class Solution {
	public void moveZeroes(int[] nums) {
        int noZero = 0;
		for(int i = 0; i < nums.length; i++)
        {
        	if(nums[i] != 0)
        	{
        		nums[noZero++] = nums[i];
        	}
        }
		for(int i = noZero; i < nums.length; i++)
		{
			nums[i] = 0;
		}
		//System.out.println(Arrays.toString(nums));
    }
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		new Solution().moveZeroes(nums);
	}
}
