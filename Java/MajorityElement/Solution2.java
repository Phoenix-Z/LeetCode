import java.util.Arrays;

/**
 * (4ms)
 * ��������
 * ����������Ƚ���������Ȼ���ǵ����һ��Ԫ�س�����[n/2]�����ϣ�
 * ��ô��������������nums.length/2��λ����һ����������֡�
 * ����������ʱ�临�Ӷ�ΪO(nlogn)(�����ʱ�临�Ӷ�)
 * @author Phoenix-Z
 *
 */
public class Solution2 {

	public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
	
}