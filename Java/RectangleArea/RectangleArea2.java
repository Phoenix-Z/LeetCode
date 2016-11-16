import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * (4ms) 
 * 这个方法优点在于不需要判断是否重叠，缺点就是没有前一个方法容易理解。
 * @author Phoenix-Z
 *
 */
public class RectangleArea2 {

	int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int left = max(A, E), right = max(min(C, G), left);
		int bottom = max(B, F), top = max(min(D, H), bottom);
		return (C - A) * (D - B) - (right - left) * (top - bottom) + (G - E) * (H - F);
	}

}