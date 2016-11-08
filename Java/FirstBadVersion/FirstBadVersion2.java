/**
 * (17ms)
 * 思路依然是二分法，不过是一个优化过的版本。
 * @author Phoenix-Z
 *
 */
public class FirstBadVersion2 {

	//这是个API，直接调用即可
	public boolean isBadVersion(int version){
		if(version >= 2)
			return true;
		return false;
	}
	
	public int firstBadVersion(int n) {
		int start = 1, end = n;
		while (start < end) {
			//这种防止加法溢出的写法值得借鉴
			int mid = start + (end - start) / 2;
			if (!isBadVersion(mid))
				start = mid + 1;
			else
				end = mid;
		}
		return start;
	}

}