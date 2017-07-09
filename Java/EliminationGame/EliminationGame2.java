/**
 * (81ms)
 * O(1)的算法。。。
 * Created by Phoenix-Z on 2017/7/9.
 */
public class EliminationGame2 {

    public int lastRemaining(int n) {
        return ((Integer.highestOneBit(n) - 1) & (n | 0x55555555)) + 1;
    }
    
}
