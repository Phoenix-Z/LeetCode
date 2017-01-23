/**
 * (13ms)
 * 这个方法是使用整型数组来代替字符串，而且在构造字符串的同时统计1的个数。其中值得注意的一个小技巧是，当
 * 需要在两个整数（x1和x2）之间来回切换时，可以使用x ^= x1 ^ x2,在这题中可以使用x ^= 3。
 * @author Phoenix-Z
 *
 */
public class MagicalString2 {

	public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        
        int[] a = new int[n + 1];
        a[0] = 1; a[1] = 2; a[2] = 2;
        int head = 2, tail = 3, num = 1, result = 1;
        
        while (tail < n) {
            for (int i = 0; i < a[head]; i++) {
                a[tail] = num;
                if (num == 1 && tail < n) result++;
                tail++;
            }
            num = num ^ 3;
            head++;
        }
        
        return result;
    }
	
}