/**
 * (2ms)
 * 很有意思的一道智力题。
 * Created by Phoenix-Z on 2017/6/17.
 */
public class PoorPigs {

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1));
    }

    public static void main(String[] args) {
        System.out.println(poorPigs(2, 15, 60));
    }

}
