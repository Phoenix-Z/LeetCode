/**
 * (0ms)
 * 这道题目是一个非负整数加1，但是是以数组形式传参，需要注意的是对于全是9的数字(如999)
 * 数组的长度会增加一，所以需要先判断是否是特殊情况。
 * plusOne2基本思路是一样的，但是显然判断的更好点。
 * @author Phoenix-Z
 *
 */
public class Solution {

	public int[] plusOne(int[] digits) {
		int len = digits.length;
		int count = 0;
		//判断digits是否全是9
		boolean flag = false;
		
		while(digits[count++] == 9)
		{
			if(count == len)
			{
				flag = true;
				break;
			}

		}
		//如果全是9，只需要生成一个新数组，长度加1，数组的首个元素为1，其他采用默认值0即可
		if (flag) {
			int[] result = new int[len + 1];
			result[0] = 1;
			return result;
		}
		//从数组末尾开始加，这时不需要担心数组越界问题，因为肯定会在某一位开始停止进位
		int i = len - 1;
		while(digits[i] + 1 == 10)
		{
			digits[i] = 0;
			i--;
		}
		digits[i] += 1;
		return digits;
    }
	
	public int[] plusOne2(int[] digits) {
        
	    int n = digits.length;
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;
	        }
	        
	        digits[i] = 0;
	    }
	    
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    
	    return newNumber;
	}
	
}