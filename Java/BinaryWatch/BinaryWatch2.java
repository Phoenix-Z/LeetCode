import java.util.ArrayList;
import java.util.List;

/**
 * (3ms)
 * 这个做法就是把方法一中打的表用程序写出来，基本思路是一样的。
 * 而打表的程序部分使用的是递归的方法，有点类似DFS的思想。
 * @author Phoenix-Z
 *
 */
public class BinaryWatch2 {

	public List<String> readBinaryWatch(int num) {
		//最终结果集
        List<String> res = new ArrayList<>();
        //nums1中的数字表示第一排LED灯所表示的数字，nums2中的数字表示第二排LED灯所表示的数字
        int[] nums1 = new int[]{8, 4, 2, 1}, nums2 = new int[]{32, 16, 8, 4, 2, 1};
        
        for(int i = 0; i <= num; i++) {
        	//list1中的数字表示当第一排LED灯亮了i个灯之后，可以表示的小时数
            List<Integer> list1 = generateDigit(nums1, i);
            //list2中的数字表示当第二排LED灯亮了num - i个灯之后，可以表示的分钟数
            List<Integer> list2 = generateDigit(nums2, num - i);
            //将小时数和分钟数结合起来输出
            for(int num1: list1) {
                if(num1 >= 12) 
                	continue;
                for(int num2: list2) {
                    if(num2 >= 60) 
                    	continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }

    private List<Integer> generateDigit(int[] nums, int count) {
    	//返回值res表示count个灯亮，可能的所有数字
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }

    private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if(count == 0) {
            res.add(sum);
            return;
        }
        
        for(int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);    
        }
    }
	
}