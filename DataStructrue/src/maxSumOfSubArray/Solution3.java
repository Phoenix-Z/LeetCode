package maxSumOfSubArray;

/**
 * ʱ�临�Ӷ�ΪO(nlogn)
 * ����������õ��Ƿ��ε�˼�룬��һ������ֳ������������֣���ô��������кͿ��ܳ������������֣�Ҫô����벿�֣�
 * Ҫô���Ұ벿�֣�Ҫô��������������֡����ڵ�����������ȷֱ���������ֽ����ֵ���벿�ֺ��Ұ벿�ֵ����ͣ�Ȼ��
 * ��Ӽ��ɡ�
 * @author Phoenix-Z
 *
 */

public class Solution3 {

	public static int maxSubSum(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}
	
	public static int helper(int[] nums, int left, int right) {
		if(left == right)
			return nums[left] > 0 ? nums[left] : 0;
		int mid = (left + right) / 2;
		int maxLeftSum = helper(nums, left, mid);
		int maxRightSum = helper(nums, mid + 1, right);
		int maxLeftBoardSum = 0, leftBoardSum = 0;
		for(int i = mid; i >= left; i--) {
			leftBoardSum += nums[i];
			if(leftBoardSum > maxLeftBoardSum)
				maxLeftBoardSum = leftBoardSum;
		}
		int maxRightBoardSum = 0, rightBoardSum = 0;
		for(int i = mid + 1; i <= right; i++) {
			rightBoardSum += nums[i];
			if(rightBoardSum > maxRightBoardSum)
				maxRightBoardSum = rightBoardSum;
		}
		return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBoardSum + maxRightBoardSum);
	}
	
}
