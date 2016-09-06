import java.util.HashMap;
import java.util.Map;

/**
 * (143ms)
 * 方法三：
 * 比较差的一个做法，从运行时间就可以看出来，还是借助于Map的数据结构，不作详述
 * @author Phoenix-Z
 *
 */
public class Solution3 {

	public int firstUniqChar(String s) {
		Map<String, Integer> map = new HashMap<>();
        String[] str = s.split("");
        int len = str.length;
        boolean[] unique = new boolean[len];
        
        for(int i = 0; i < len; i++)
        {
        	Integer index = map.get(str[i]);
        	if(index == null)
        	{
        		unique[i] = true;
        		map.put(str[i], i);
        	}
        	else
        	{
        		unique[index] = false;
        	}
        }
        
        for(int i = 0; i < len; i++)
        {
        	if (unique[i]) 
        	{
				return i;
			}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution3().firstUniqChar("loveleetcode"));
	}
	
}