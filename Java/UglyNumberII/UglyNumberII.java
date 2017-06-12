import java.util.LinkedList;
import java.util.Queue;

/**
 * (47ms)
 * Created by Phoenix-Z on 2017/6/10.
 */
public class UglyNumberII {

    public int nthUglyNumber(int n) {
        int now = 1;
        Queue<Integer> multiplyTwo = new LinkedList<>();
        Queue<Integer> multiplyThree = new LinkedList<>();
        Queue<Integer> multiplyFive = new LinkedList<>();
        multiplyTwo.offer(1);
        multiplyThree.offer(1);
        multiplyFive.offer(1);

        while(--n > 0) {
            int nowWithTwo = multiplyTwo.peek() * 2;
            int nowWithThree = multiplyThree.peek() * 3;
            int nowWithFive = multiplyFive.peek() * 5;
            now = Math.min(nowWithTwo, Math.min(nowWithThree, nowWithFive));
            if(now == nowWithTwo) {
                multiplyTwo.poll();
            }
            if(now == nowWithThree) {
                multiplyThree.poll();
            }
            if(now == nowWithFive){
                multiplyFive.poll();
            }
            multiplyTwo.offer(now);
            multiplyThree.offer(now);
            multiplyFive.offer(now);
        }
        return now;
    }


    public static void main(String[] args) {
        UglyNumberII test = new UglyNumberII();
        System.out.println(test.nthUglyNumber(7));
    }
}
