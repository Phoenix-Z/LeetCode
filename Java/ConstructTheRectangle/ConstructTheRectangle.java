/**
 * (6ms)
 * 很简单的一道题。
 * @author Phoenix-Z
 *
 */
public class ConstructTheRectangle {

	public int[] constructRectangle(int area) {
		int width = (int)Math.sqrt(area), length = area / width;
		while(width * length != area) {
			width--;
			length = area / width;
		}
		return new int[] {length, width};
    }
	
}
