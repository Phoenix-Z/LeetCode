/**
 * (1ms)
 * 这个代码非常简洁，也十分有效。本质上同方法一的思路是一样的，但是这里使用了位运算并行的处理32个bit，
 * 而不是一位一位的进行判断。实际上这是设计了一个周期为3的位运算的循环，可以使用卡诺图来设计。
 * 由于32bit遵循相同的规则，可以考虑1位的情况，我们需要周期为3的循环，使用两个变量(就会有4个状态)，
 * 使用其中的前三个状态，先写出真值表，再写逻辑表达式。
 * current   incoming  next
 * twos ones    bit    twos ones
 * 0 	0        0    	0 	0
 * 0 	1        0    	0 	1
 * 1 	0        0    	1 	0
 * 0 	0        1    	0 	1
 * 0 	1        1    	1 	0
 * 1 	0        1    	0 	0
 * @author Phoenix-Z
 *
 */
public class SingleNumberII2 {

	public int singleNumber(int[] A) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < A.length; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        twos = (twos ^ A[i]) & ~ones;
	    }
	    return ones;
	}
	
}