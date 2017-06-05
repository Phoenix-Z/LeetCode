/**
 * (12ms)
 * Created by Phoenix-Z on 2017/6/5.
 */
public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int available = 0, left = -2, right = 0;
        while (right < flowerbed.length) {
            while (right < flowerbed.length && flowerbed[right] == 0) {
                right++;
            }
            available += right == flowerbed.length ? (right - left - 1) / 2 : (right - left - 2) / 2;
            left = right;
            right++;
        }
        return n <= available;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(flowerbed, 1));
    }
}
