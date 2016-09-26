import java.util.HashMap;
import java.util.Map;

/**
 * (15ms)
 * 该方法分情况讨论：
 * 当num = 0时，直接返回"0"；
 * 当num > 0时，逐次对16取余，然后查找Map中对应的字符，找到num小于0即可终止循环
 * 			  这么处理可以避免出现前导0；
 * 当num < 0时，使用位运算，逐位的右移，然后每4位产生一个整数，查找Map中对应的字符，循环32次(int长度)即可
 * 			 这么处理是因为负数的最高位一定是1，所以不会出现前导0。
 * 
 * 改进方法：可以不使用HashMap,直接使用一个长为16的字符数组即可
 * @author Phoenix-Z
 *
 */
public class NumberToHex {

	private Map<Integer, Character> numMap = new HashMap<>();
	
	{
		char c = '0';
		for(int i = 0; i < 10; i++)
		{
			numMap.put(i, c++);
		}
		c = 'a';
		for(int i = 10; i < 16; i++)
		{
			numMap.put(i, c++);
		}
	}
	
	public String toHex(int num) {
        //num等于0，直接返回即可
		if (num == 0) {
			return "0";
		}
        
		//使用StringBuilder是因为需要大量地进行添加字符操作，而且还可以直接逆转字符串的顺序
        StringBuilder sb = new StringBuilder();
        
        //num > 0,不停对16取余即可
        if(num > 0)
        {
        	while(num / 16 > 0)
        	{
        		sb.append(numMap.get(num % 16));
        		num = num / 16;
        	}
        	if(num > 0)
        		sb.append(numMap.get(num));
        	sb.reverse();
        	return sb.toString();
        }
        
        //当num < 0时，使用位运算
        int tmp = 0;
        for(int i = 0; i < 32; i++)
        {
        	tmp += ((num >>> i) & 1) * (int)Math.pow(2, i % 4);
        	if((i + 1) % 4 == 0)
        	{
        		sb.append(numMap.get(tmp));
        		tmp = 0;
        	}
        }
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		int[] nums = {0, 26, -1};
		NumberToHex aHex = new NumberToHex();
		for(int num : nums)
			System.out.println(aHex.toHex(num));
	}
}
