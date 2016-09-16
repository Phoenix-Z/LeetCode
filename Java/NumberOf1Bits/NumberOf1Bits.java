/**
 * (3ms)
 * 方法一：
 * 这个方法很直接，就是首先将整数n转化为二进制字符串，然后再遍历这个字符串，找出1的个数
 * 这里需要注意的是，当整数大于2^31-1的时候，数字就溢出了，恰好和负数的二进制序列是一样的，
 * 所以可以直接像下面这么操作。
 * Created by Phoenix-Z on 2016/9/16.
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        //count记录1bit出现的次数
        int count = 0;
        //将整数转化为二进制字符串
        String str = Integer.toBinaryString(n);

        //遍历字符串
        for(char c : str.toCharArray())
        {
            if(c == '1')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString((int)Math.pow(2,32) ));
    }
}