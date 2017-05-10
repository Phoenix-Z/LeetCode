/**
 * (149ms)
 * @param {number[][]} M
 * @return {number}
 */

var findCircleNum = function(M) {
    var DFS = function(M, visited, row) {
        for(var j = 0; j < M[row].length; j++) {
            if(M[row][j] == 1 && !visited[j]) {
                visited[j] = true;
                DFS(M, visited, j);
            }
        }
    };
    var num = 0;
    var visited = new Array(M.length);
    visited.fill(false);
    for(var i = 0; i < M.length; i++) {
        if(!visited[i]) {
            visited[i] = true;
            num++;
            DFS(M, visited, i);
        }
    }
    return num;
};