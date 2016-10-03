import java.util.ArrayList;
import java.util.List;

/**
 * (3ms)
 * 暴力的做法，还挺有效，但需要小心数组越界的问题
 * @author Phoenix-Z
 *
 */
public class BinaryWatch {

	//时针亮灯个数0~3个
	private String[][] hours = {{"0"}, {"1", "2", "4", "8"}, 
			{"3", "5", "9", "6", "10"}, {"7", "11"}};
	//分针亮灯个数0~5个
	private String[][] minutes = {{"00"}, {"01", "02", "04", "08", "16", "32"},
			{"03", "05", "09", "17", "33", "06", "10", "18", "34", "12", "20", "36",
		"24", "40", "48"}, {"07", "11", "19", "35", "13", "21", "37", "25", "41","49",
			"14", "22", "38","26", "42", "50", "28", "44", "52", "56"},
			{"15", "23", "39", "27", "43", "51", "30", "46", "54", "57", "29", "45", 
			"53", "58"}, {"31", "47", "55", "59"}};
	
	public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        if(num < 0 || num > 8)
            return list;
        int high = num < 4 ? num : 3;
        int low = num < 6 ? 0 : num - 5;
        for(int i = low; i <= high; i++)
        {
        	for(int j = 0; j < hours[i].length; j++)
        	{
        		for(int k = 0; k < minutes[num - i].length; k++)
        		{
        			list.add(hours[i][j] + ":" + minutes[num - i][k]);
        		}
        	}
        }
        return list;
    }
	
	public static void main(String[] args) {
		System.out.println(new BinaryWatch().readBinaryWatch(6));
	}
}
