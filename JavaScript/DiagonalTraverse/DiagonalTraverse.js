/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
// (185ms)
var findDiagonalOrder = function(matrix) {
    var ans = [];
    if(matrix == undefined || matrix.length == 0) {
        return ans;
    }
    var m = matrix.length, n = matrix[0].length;
    for(let sum = 0; sum < m + n - 1; sum++) {
        var i, j;
        if(sum % 2 == 0) {
            i = Math.min(sum, m - 1);
            j = sum - i;
            while(i >= 0 && j < n) {
                ans.push(matrix[i--][j++]);
            }
        } else {
            j = Math.min(sum, n - 1);
            i = sum - j;
            while(j >= 0 && i < m) {
                ans.push(matrix[i++][j--]);
            }
        }
    }
    return ans;
};

// (402ms)
var findDiagonalOrder2 = function(matrix) {
    var ans = [];
    if(matrix == undefined || matrix.length == 0) {
        return ans;
    }
    var tuple = [];
    for(let i = 0; i < matrix.length; i++) {
        for(let j = 0; j < matrix[0].length; j++) {
            tuple.push([i, j]);
        }
    }
    tuple.sort(function(x, y) {
        let sumX = x[0] + x[1];
        let sumY = y[0] + y[1];
        if(sumX == sumY) {
            return y[sumY % 2] - x[sumX % 2];
        } 
        return sumX - sumY;
    });
    for(let i = 0; i < tuple.length; i++) {
        ans.push(matrix[tuple[i][0]][tuple[i][1]]);
    }
    return ans;
};