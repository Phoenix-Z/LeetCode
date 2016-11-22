/**
 * (7ms)
 * 这个题目本身没啥难度，主要就是统计有多少个连续相同的数字，然后拼接在一起。
 * 需要注意的是n是从1开始计数的，而不是从0开始的。
 * @author Phoenix-Z
 *
 */
public class CountAndSay {

	public String countAndSay(int n) {
		//如果n为奇数，就返回one，否则返回two
        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        //给奇数序列添加第一个值
        one.append(1);
        //给偶数序列添加第二个值
        two.append(11);
        int i = 2;
        while(i++ < n) {
        	if(i % 2 == 0) {
        		//先将two之前的内容清空
        		two.delete(0, two.length());
        		//遍历one
        		for(int j = 0; j < one.length() - 1; j++) {
        			//统计重复数字出现的次数
        			int count = 1;
        			while(j < one.length() - 1 && one.charAt(j) == one.charAt(j + 1)) {
        				count++;
        				j++;
        			}
        			//先添加出现的次数
        			two.append(count);
        			//再添加出现的数字
        			two.append(one.charAt(j));
        		}
        		//对于最后一个单独的数字特殊处理一下
        		if(one.length() == 1||one.charAt(one.length() - 1) != one.charAt(one.length() - 2)) {
        			two.append(1);
        			two.append(one.charAt(one.length() - 1));
        		}
        	} else {
        		//以下操作跟上面基本一致
        		one.delete(0, one.length());
        		for(int j = 0; j < two.length() - 1; j++) {
        			int count = 1;
        			while(j < two.length() - 1 && two.charAt(j) == two.charAt(j + 1)) {
        				count++;
        				j++;
        			}
        			one.append(count);
        			one.append(two.charAt(j));
        		}
        		if(two.charAt(two.length() - 1) != two.charAt(two.length() - 2)) {
        			one.append(1);
        			one.append(two.charAt(two.length() - 1));
        		}
        	}
        }
        //根据n的奇偶返回合适的结果
        return n % 2 != 0 ? one.toString() : two.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(2));
	}
	
}