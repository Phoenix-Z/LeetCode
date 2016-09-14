/**
 * (2ms)Boyer-Moore Vote Algorithm
 * ��������
 * ��������������������㷨��ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ΪO(1)��
 * ��ϸ���̿��Կ�ά���ٿ�
 * https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
 * @author Phoenix-Z
 *
 */

public class Solution3 {

	public int majorityElement(int[] nums) {
        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
	
}