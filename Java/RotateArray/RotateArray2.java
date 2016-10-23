import java.util.Arrays;

/**
 * (1ms)
 * 这个方法一方面时间效率很高，另一方面空间复杂度为O(1)，空间效率也很高。
 * 这个方法基本思想就是，从第一个元素开始，将元素放到新数组的正确位置上，
 * 从而一个个地就都可以恢复到正确的位置上。
 * 只不过需要注意的是如果数组的长度和移动的位移的最大公约数大于1，会出现循环，
 * 从而导致有些元素不能恢复到正确的位置上，所以需要循环处理。
 * @author Phoenix-Z
 *
 */
public class RotateArray2 {

	public void rotate(int[] nums, int k) {
		//如果k等于0，需要特殊处理，因为无法求解最大公约数，而且事实上无需循环数组了
		if(k == 0)
			return;
		int len = nums.length;
		//limit表示数组长度和位移量的最大公约数
		int limit = gcd(len, k);
		for(int i = 0; i < limit; i++)
		{
			//初始位置对应的新位置
	        int newPos = (i + k) % len;
	        int oldNum = nums[i];
	        while(newPos != i) {
	        	//先将新位置的元素取出来
	        	int tmp = nums[newPos];
	        	//将值填入新位置中
	        	nums[newPos] = oldNum;
	        	//更新旧值
	        	oldNum = tmp;
	        	//更新新位置
	        	newPos = (newPos + k) % len;
	        }
	        //初始位置填入新值
	        nums[i] = oldNum;
		}
    }
	//求解最大公约数
	public int gcd(int m, int n) {
		if(m % n == 0)
			return n;
		return gcd(n, m % n);
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		new RotateArray2().rotate(nums, 4);
		System.out.println(Arrays.toString(nums));
	}
}