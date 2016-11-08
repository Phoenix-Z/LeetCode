/**
 * (23ms)
 * 这就是一个二分搜索的方法，需要注意做加法时可能会超出int的范围，以及边界的处理。
 * @author Phoenix-Z
 *
 */
public class FirstBadVersion {

	//这是个API，直接调用即可
	public boolean isBadVersion(int version){
		if(version >= 2)
			return true;
		return false;
	}
	
	public int firstBadVersion(int n) {
		int left = 1, right = n;
		int mid = 1;
		while(left <= right)
		{
			//这里不是mid = (left + right) / 2,是因为当数字非常大时，加法会溢出
			mid = left / 2 + right / 2 + 1;
			if(!isBadVersion(mid))
			{
				if(left == mid)
				    left++;
				else
				    left = mid;
			} else if(mid == 1 || !isBadVersion(mid - 1)) {
				return mid;
			} else {
				if(right == mid)
				    right--;
				else
				    right = mid;
			}
		}
		return mid;
    }
	
	public static void main(String[] args) {
		System.out.println(new FirstBadVersion().firstBadVersion(4));
	}
}