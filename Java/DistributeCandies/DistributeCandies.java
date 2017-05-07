import java.util.HashSet;
import java.util.Set;

/**
 * (261ms)
 * Created by Phoenix-Z on 2017/5/7.
 */
public class DistributeCandies {

    public static int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for(int candy : candies) {
            set.add(candy);
        }
        System.out.println(set);
        return Math.min(candies.length / 2, set.size());
    }

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[] {1,1,1,1,2,2,2,3,3,3}));
    }

}
