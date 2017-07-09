/**
 * (79ms)
 * 类似于约瑟夫环问题，该算法的时间复杂度为O(log n)
 * https://discuss.leetcode.com/topic/61875/one-line-java-solution-based-on-josephus-problem
 * Created by Phoenix-Z on 2017/7/9.
 */
public class EliminationGame {

    public static int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (1 + n/2 - lastRemaining(n / 2));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        for (int num : nums) {
            System.out.println(lastRemaining(num));
        }
    }

}
