class Solution(object):
	# (95ms)
    def updateBoard(self, board, click):
        """
        :type board: List[List[str]]
        :type click: List[int]
        :rtype: List[List[str]]
        """
        row, col = click[0], click[1]
        if board[row][col] == 'M':
        	board[row][col] = 'X'
        	return board
        count = 0
        for i in [-1, 0, 1]:
        	for j in [-1, 0, 1]:
        		if 0 <= row + i < len(board) and 0 <= col + j < len(board[i]) and board[row + i][col + j] == 'M':
        			count += 1
        if count > 0:
        	board[row][col] = str(count)
        else:
        	board[row][col] = 'B'
        	for i in [-1, 0, 1]:
        		for j in [-1, 0, 1]:
        			if 0 <= row + i < len(board) and 0 <= col + j < len(board[i]) and board[row + i][col + j] == 'E':
        				self.updateBoard(board, [row + i, col + j])
        return board

print Solution().updateBoard([['E', 'E', 'E', 'E', 'E'],['E', 'E', 'M', 'E', 'E'], ['E', 'E', 'E', 'E', 'E'],['E', 'E', 'E', 'E', 'E']], [3, 0])