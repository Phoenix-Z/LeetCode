import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/**
 * (19ms)
 * 这个问题首先可以对身高进行排序，对于最高的一组来说，没有其他人比他们更高了，所以只需要对第二个参数进行排序
 * 即可。然后对第二高的一组来说，只需要根据第二个参数插入到相应的位置即可。依此类推。
 * 可以从这里学习如何对二维数组的排序，注意int[]是一种参数类型。
 * @author Phoenix-Z
 *
 */
public class QueueReconstructionByHeight {

	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people,new Comparator<int[]>(){
	           @Override
	           public int compare(int[] o1, int[] o2){
	        	   //如果身高不同，就按照身高从大到小排序，如果身高相同，就按照第二个参数从小到大排序
	               return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
	           }
	        });
	        List<int[]> res = new LinkedList<>();
	        for(int[] cur : people){
	            res.add(cur[1],cur);       
	        }
	        return res.toArray(new int[people.length][]);
    }
	
	public static void main(String[] args) {
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		System.out.println(Arrays.deepToString(reconstructQueue(people)));
	}
}