import java.util.Arrays;

/**
 * (0ms)
 * 这是个数学问题，某个位置(第i个)的灯泡要亮着，除非i的约数的个数为奇数个，考虑到约数都是成对出现的，比如说12的约数有
 * 1和12，2和6，以及3和4，只有当i是完全平方数时，它的约数的个数为奇数个。所以这个问题就转换成小于等于n的数中，有多少个
 * 完全平方数，而这显然可以通过|sqrt(i)|得知，因为1^2， 2^2， 3^2，...
 * Created by Phoenix-Z on 2017/5/2.
 */
public class BulbSwitcher {

    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(0));
    }
}
