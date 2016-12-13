import java.util.Arrays;

/**
 * (24ms)
 * 这个方法需要先对两个数组进行排序，两个数组从小到大排序，使用两个指针，分别指向两个数组。
 * 对于每一个house，找到与之最近的heater(注意这里不需要回溯，是因为两个数组是排过序的，
 * 一旦j位置的heater离i位置的house更近，那么该heater一定比前面所有heater离i之后的house更近。)
 * 而radius需要选取所有最近距离中的最大值，以确保所有heater都能覆盖到所有的房子。
 * @author Phoenix-Z
 *
 */
public class Heaters {

	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int radius = 0;
		int i = 0, j = 0;
		while(i < houses.length) {
			while(j < heaters.length - 1 && 
					Math.abs(heaters[j] - houses[i]) >= Math.abs(heaters[j + 1] - houses[i]))
				j++;
			radius = Math.max(radius, Math.abs(heaters[j] - houses[i]));
			i++;
		}
		return radius;
    }
	
	public static void main(String[] args) {
		int[] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
		int[] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
		System.out.println(new Heaters().findRadius(houses, heaters));
	}
}