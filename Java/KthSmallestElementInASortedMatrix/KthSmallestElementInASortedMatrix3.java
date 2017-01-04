import java.util.PriorityQueue;

/**
 * (27ms)
 * 这个方法是用优先权队列模拟了一个最小堆，首先把矩阵第一行的所有元素添加到最小堆中，然后删除最小堆中的前k-1
 * 个元素，那么队列头的就是第k小的元素。再删除一个元素的同时，将被删除元素下一行同一列的元素添加进最小堆中，
 * 以防止在下面几行，但是元素值较小的元素被忽略。
 * @author Phoenix-Z
 *
 */
public class KthSmallestElementInASortedMatrix3 {
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		for (int j = 0; j <= n - 1; j++)
			pq.offer(new Tuple(0, j, matrix[0][j]));
		for (int i = 0; i < k - 1; i++) {
			Tuple t = pq.poll();
			if (t.x == n - 1)
				continue;
			pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
		}
		return pq.poll().val;
	}
}

class Tuple implements Comparable<Tuple> {
	int x, y, val;

	public Tuple(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}

	@Override
	public int compareTo(Tuple that) {
		return this.val - that.val;
	}
}