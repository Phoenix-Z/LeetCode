/**
 * @author Phoenix-Z
 *
 */
public class StudentAttendanceRecordI {

	// (9ms)
	public boolean checkRecord(String s) {
		int countOfAbsent = 0;
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				countOfAbsent++;
				if(countOfAbsent > 1)
					return false;
			}
			if(s.charAt(i) == 'L') {
				if(i < s.length() - 2 && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L')
					return false;
			}
		}
		return true;
    }
	
	// (17ms) 正则表达式
	public boolean checkRecord2(String s) {
	    return !s.matches(".*LLL.*|.*A.*A.*");
	}
	
}
