import java.util.Arrays;
import java.util.HashMap;

/**
 * (5ms)
 * ��������
 * ��������������һ��HashMap,���Ѿ����ʹ���Ԫ�ط��뵽HashMap�У����������Ϣ����˿������Ч��.
 * �����Ͽ�����������ʱ�临�Ӷ���O(n),������HashMap�Ĵ洢�Ͳ�ѯ��Ҫһ����ʱ�䣬��˱ȷ�������΢��Щ.
 * �ͷ���һ�Աȣ�
 * ����һ���������е�ÿһ��Ԫ�ض��鿴��������Ԫ����������Ƿ����target��������n*n�ĸ��Ӷ�
 * ���������������е�ÿһ��Ԫ��ֻ�����Ƿ����target - n��һ��Ԫ�أ�����ѯ�ٶȵ���ߵ�����HashMap��������n * 1�ĸ��Ӷ�
 * @author Phoenix-Z
 *
 */
public class Solution3 {
	public int[] twoSum(int[] nums, int target)
	{
		//Ĭ�Ϸ���ֵΪ[-1, -1]
		int[] ans = {-1, -1};
		int len = nums.length;
		
        HashMap<Integer, Integer> numsWithIndexes = new HashMap<>(len);
        
        //���� m + n = target
        for(int i = 0; i < len; i++){
        	//�ǰֵΪn
            int n = nums[i];
            
            //��HashMap���� m(target - n)
            Integer mIndex = numsWithIndexes.get(Integer.valueOf(target - n));
            
            //����HashMap���ҵ��ˣ����ҵ�������Ҫ�Ľ�
            if(mIndex != null) {
            	//ע��������ĸ�ֵ˳�򣬳�����HashMap�е�����mIndexһ���Ѿ��������ˣ����Ա� i С
                ans[0] = mIndex;
                ans[1] = i;
                return ans;
            } 
            //���û���ҵ����ͽ�n��������������HashMap��
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
