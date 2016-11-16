/**
 * (4ms)
 * 这个方法首先判断是否在重叠，如果有重叠，就将两个长方形的面积相加再减去重叠部分的面积，
 * 就是最终的结果。
 * @author Phoenix-Z
 *
 */
public class RectangleArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		//(leftX, leftY)是重叠部分左下角顶点的坐标， (rightX, rightY)是右上角顶点的坐标
		int leftX = 0, leftY = 0, rightX = 0, rightY = 0;
		//首先判断是否有重叠，如果有重叠，则更新重叠部分的左下角和右上角的坐标
		if(E <= C && H >= B && G >= A && F <= D) {
			leftX = Math.max(A, E);
			leftY = Math.max(B, F);
			rightX = Math.min(C, G);
			rightY = Math.min(D, H);
		} 
		//计算重叠部分的面积
		int area = (rightX - leftX) * (rightY - leftY);
		//计算结果
		return (C - A) * (D - B) + (G - E) * (H - F) - area;
    }
	
}