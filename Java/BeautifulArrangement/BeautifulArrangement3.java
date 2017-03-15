/**
 * (56ms)
 * 这个是性能最高的一个算法，没有从1遍历到N，并用一个boolean型数组来标记是否使用过该数字，而是直接初始化一个数组num[i]=i,
 * 同样的，如果从后往前遍历，时间可以缩减到8ms。
 * @author Phoenix-Z
 *
 */
public class BeautifulArrangement3 {

	private int count = 0;
	
	private void helper(int[] nums, int start) {
        if (start < 2) {
            count++;
            return;
        }
        for (int i = start; i >= 1; i--) {
            swap(nums, start, i);
            if (nums[start] % start == 0 || start % nums[start] == 0) 
            	helper(nums, start - 1);
            swap(nums,i, start);
        }
    }
    public int countArrangement(int N) {
        if (N == 0) 
        	return 0;
        int[] nums = new int[N+1];
        for (int i = 0; i <= N; i++) 
        	nums[i] = i;
        helper(nums, N);
        return count;
    }
	
    public void swap(int[] nums, int pos1, int pos2) {
    	int tmp = nums[pos1];
    	nums[pos1] = nums[pos2];
    	nums[pos2] = tmp;
    }
    
    public static void main(String[] args) {
		int N = 4;
		System.out.println(new BeautifulArrangement3().countArrangement(N));
	}
}
