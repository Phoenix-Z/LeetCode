/**
 * (1ms)
 * 时间复杂度O(n)，空间复杂度O(n)
 * 这个方法是使用了额外的数组来标记数字是否出现过，想法简单，虽然效率较高，但是使用了较多的空间。
 * @author Phoenix-Z
 *
 */
public class MissingNumber {

	public int missingNumber(int[] nums) {
		boolean[] exist = new boolean[nums.length + 1];
        for(int num : nums) {
        	exist[num] = true;
        }
        for(int i = 0; i < exist.length; i++) {
        	if(!exist[i])
        		return i;
        }
        return exist.length;
    }
	
	public int missingNumber2(int[] nums) {
		ArrayList<Integer> all = new ArrayList<>();
		ArrayList<Integer> origin = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			all.add(i);
			origin.add(nums[i]);
		}
		all.add(nums.length);
		all.removeAll(origin);
		return all.get(0);
    }
	
	public static void main(String[] args) {
		int[] nums = {0};
		MissingNumber test = new MissingNumber();
		System.out.println(test.missingNumber2(nums));
	}
}
