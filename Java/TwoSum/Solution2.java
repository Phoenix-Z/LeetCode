import java.util.Arrays;

/**
 * (2ms)
 * ��������
 * ��������ʵ���Ͼ���ͨ��һά����map��ʵ��HashMap�����ã�������û��HashMap�Ĳ�����
 * ʵ�ʵ�ʱ�临�ӶȾ���O(n),��������ٶȱȷ�������Ҫ��
 * ΪʲôҪ����Сֵ�����ֵ��
 * ����map�������������nums�����ֵ����������map���nums�е�������ֵ��
 * ��nums�е������кܿ��ܴ��ڸ�ֵ��������Ҫ�����Сֵ������������ƽ��|min|����λ����max������map����ĳ���
 * @author Phoenix-Z
 *
 */
public class Solution2 {
	public int[] twoSum(int[] nums, int target)
	{
		int[] ans = {-1, -1};
		int len = nums.length;
		
		//�ҳ�nums�е����ֵ����Сֵ
		int max = nums[0], min = nums[0];
		for (int i = 1; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

		//mi��ʾ��������ƽ�ƶ��ٸ���λ���ܷ�ֹ�������ָ�ֵ
        int mi = Math.min(min, target - max);
        //ma��ʾ�������Ͻ�
        int ma = Math.max(max, target - min);

        int[] map = new int[ma - mi + 1];
        //�������������Ϊ�Ǹ�������˸�map��ֵΪ-1��
        //���mapĳһ������Ӧ��ֵΪ-1��˵����������ʱ����nums������
        Arrays.fill(map, -1);
       
        //target��Ҫ��Ӧ��ƽ��
        target = target - mi;
        
        //����for-loop�е�˼·�ͷ�������һ�µ�
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
