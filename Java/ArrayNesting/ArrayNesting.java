import java.io.FileNotFoundException;

/**
 * (40ms)
 * 注意题设nums数组中的元素各不相同，所以不会有多个数字指向同一个数字。
 * Created by Phoenix-Z on 2017/6/1.
 */
public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        int max = -1;
        boolean[] visited = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                int count = 0, now = i;
                while(count == 0 || now != i) {
                    visited[now] = true;
                    count++;
                    now = nums[now];
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) throws FileNotFoundException {
        /*Scanner in = new Scanner(new FileInputStream("D:\\IdeaProjects\\LeetCode\\src\\com\\phoenix\\ex565\\data.txt"));
        String[] datas = in.nextLine().split(",");
        in.close();
        int[] nums = new int[datas.length];
        for(int i = 0; i < datas.length; i++) {
            nums[i] = Integer.parseInt(datas[i]);
        }*/
        int[] nums = {5,4,0,3,1,6,2};
        ArrayNesting test = new ArrayNesting();
        System.out.println(test.arrayNesting(nums));
    }
}
