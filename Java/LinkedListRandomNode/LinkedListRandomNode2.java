import java.util.Random;
/**
 * (143ms)
 * 这本质上是一道蓄水池抽样(Reservoir Sampling)的题目，算法可以参考：http://blog.jobbole.com/42550/
 * 这个链接https://gregable.com/2007/10/reservoir-sampling.html写的更加详细一些。
 * @author Phoenix-Z
 *
 */
public class LinkedListRandomNode2 {

	private ListNode head;
    private Random random = new Random();
    
    public LinkedListRandomNode2(ListNode head) {
        this.head = head;                
    }
    
    public int getRandom() {
        
    	ListNode c = head;
        int r = c.val;
        for(int i=1;c.next != null;i++){
            c = c.next;
            if(random.nextInt(i + 1) == i) {
                r = c.val;                        
            }
        }
        
        return r;
    }
    
}