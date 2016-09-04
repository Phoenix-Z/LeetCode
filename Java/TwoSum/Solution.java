import java.util.Arrays;
/**
 * (41ms)
 * ����һ��
 * �������ж�Ԫ��ϣ�ֱ���ҵ������ֹѭ������û���ҵ�����Ĭ��ֵ{-1, -1}
 * �������������룬ʱ�临�Ӷ�ΪO(n^2)
 * @author Phoenix-Z
 *
 */
public class Solution {

	public int[] twoSum(int[] nums, int target) {
		int[] ans = {-1, -1};
		int len = nums.length;
		label:
		for(int i = 0; i < len - 1; i++)
		{
			for(int j = i + 1; j < len; j++)
			{
				if(nums[i] + nums[j] == target)
				{
					ans[0] = i;
					ans[1] = j;
					//���ҵ�������������ѭ��
					break label;
				}
			}
		}
		return ans;
    }
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));
	}
}