/**
 * (126ms)
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 */
var updateBoard = function(board, click) {
    var row = click[0], col = click[1];
    if(board[row][col] == 'M') {
    	board[row][col] = 'X';
    	return board;
    }
    var count = 0;
    for(var i = row - 1; i <= row + 1; i++) {
    	for(var j = col - 1; j <= col + 1; j++) {
    		if(i >= 0 && i < board.length && j >= 0 && j < board[i].length 
    			&& board[i][j] == 'M')
    			count ++;
    	}
    }
    if(count > 0) {
    	board[row][col] = '' + count;
    } else {
    	board[row][col] = 'B';
    	for(var i = row - 1; i <= row + 1; i++) {
    		for(var j = col - 1; j <= col + 1; j++) {
    			if(i >= 0 && i < board.length && j >= 0 && j < board[i].length 
    				&& board[i][j] == 'E')
    				updateBoard(board, [i, j]);
    	}
    }
    }
    return board;
};