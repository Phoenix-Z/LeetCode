/**
 * (107ms)
 * 另一种有趣的做法。
 * Created by Phoenix-Z on 2017/7/9.
 */
public class EliminationGame3 {

    public int lastRemaining(int n) {
        int head = 1, remain = n, step = 1;
        boolean left2right = true;
        while(remain > 1) {
            if(left2right || remain % 2 == 1) {
                head = head + step;
            }
            remain /= 2;
            left2right = !left2right;
            step *= 2;
        }
        return head;
    }

}
