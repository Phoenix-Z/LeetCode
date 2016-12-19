/**
 * (2ms)
 * 这个首先遍历一遍整个数组，然后对所有数字进行异或，最后的结果就是只出现一次的那两个数字的异或和。
 * 由于这两个数字是不同的，那么它们的二进制表示中一定有一位是不同的，那么这个位置的异或就是1,这里使用最右边
 * 一个1的那一个bit。由此，我们可以根据这个位置是0或者1将数组中的数字分成两个部分，只出现一次的那两个数字
 * 一定被分在不同的部分，再分别对这两个部分求异或就可以找到这两个数字。
 * 时间复杂度为O(n)，空间复杂度为O(1)。
 * @author Phoenix-Z
 *
 */
public class SingleNumberIII2 {

	public int[] singleNumber(int[] nums) {
		// 获取我们需要寻找的把两个数字的异或
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        //获取这个异或从右边数第一个是1的bit位置
        diff &= -diff;   //这等价于：diff &= ~(diff - 1)就是负数的补码即diff &= ~diff + 1
        
        int[] rets = {0, 0}; // 结果集
        for (int num : nums)
        {
            if ((num & diff) == 0) // 选中的位置没有置1
            {
                rets[0] ^= num;
            }
            else // 选中的位置置1
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
	
}