/**
 * (1ms)
 * ����һ��(д�ĺܳ�)
 * �����������˼·�Ǳ����������飬һ��ָ�루i����ǰ�����������һ��ָ�루len���Ӻ���ǰ������
 * ��i������valȫ���ƶ����������󣬴Ӷ��ֳ��������֣�ǰһ���־��������ʣ���������顣
 * @author Phoenix-Z
 *
 */
public class Solution {
	public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1){
			return nums[0] == val ? 0: 1;
		}
        int len = nums.length - 1;
        int i;
        for(i = 0; i < len; i++)
        {
        	if(nums[i] == val)
        	{
        		while(nums[len] == val && len > 0)
        		{
        			len--;
        		}
        		if(len > i)
        		{
	        		int tmp = nums[i];
	        		nums[i] = nums[len];
	        		nums[len] = tmp;
        		}
        	}
        }
        while(nums[len] == val && len >= 0)
        {
        	len--;
        	if(len < 0)
        	break;
		}
        
        return len + 1;
    }
	
	
	
	public static void main(String[] args) {
		int[] nums = {};
		System.out.println(new Solution().removeElement(nums, 3));
	}
}
