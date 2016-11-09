/**
 * (30ms)
 * 这个方法显得特别简洁，虽然看起来运行时间很长，但是时间花费大多花在了String.format这个方法上，
 * 只要改成字符串相加的方式，就可以有效地提高效率。
 * 这个方法的基本思想就是遍历12hours * 60 min, 将小时数左移六位(乘以64)
 * (这是因为分针数用了六位来表示)在加上分针数，我们就可以把这个和看作是十位(有效位数)整数，
 * 使用Integer类提供的bitCount函数(用来统计给定整数的二进制形式bit值为1的个数)模拟亮灯的动作，
 * 只要bit为1的个数等于给定亮灯的个数，那么这个时间就是我们需要的，输出即可
 * @author Phoenix-Z
 *
 */
public class BinaryWatch3 {

	public List<String> readBinaryWatch(int num) {
		//times为结果集
        List<String> times = new ArrayList<>();
        //遍历所有合法的时间
        for (int h=0; h<12; h++)
        {
            for (int m=0; m<60; m++)
            {
            	//小时左移六位再加上分钟数，使用bitCount函数统计bit为1的个数
                if (Integer.bitCount(h * 64 + m) == num)
                {
                	//格式化时间的表示
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times; 
    }
	
}