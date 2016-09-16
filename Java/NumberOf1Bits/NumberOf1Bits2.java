/**
 * (2ms)
 * 方法二：
 * 这个方法直接使用了位运算。需要注意的是应使用无符号右移运算符>>>，
 * 但是效率和方法一的差不多。
 * Created by Phoenix-Z on 2016/9/16.
 */
public class NumberOf1Bits2 {
    public int hammingWeight(int n) {
        //ones记录1bit出现的次数
        int ones = 0;

        while(n!=0) {
            //注意需要使用 n & 1 来获取 n 的最低位，要么是0，要么是1
            ones = ones + (n & 1);
            //使用>>>运算符右移一位，这时是向最高位补0
            n = n >>> 1;
        }
        return ones;
    }
}