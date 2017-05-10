/**
 * (10ms)
 * 这个题目本质上是一个判断一个无向图的连通性的问题，返回值就是连通子图的个数。
 * 这个代码使用的是DFS,当然也可以使用BFS以及并查集算法。
 * Created by Phoenix-Z on 2017/5/10.
 */
public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int num = 0;
        boolean[] visited = new boolean[M.length];
        for(int i = 0; i < M.length; i++) {
            if(!visited[i]) {
                DFS(M, i, visited);
                num++;
            }
        }
        return num;
    }

    private void DFS(int[][] M, int rowNum, boolean[] visited) {
        for(int i = 0; i < M[rowNum].length; i++) {
            if(M[rowNum][i] == 1 && !visited[i]) {
                visited[i] = true;
                DFS(M, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] M = {{1,1,0}, {1,1,0}, {0,0,1}};
        FriendCircles test = new FriendCircles();
        System.out.println(test.findCircleNum(M));
    }
}
