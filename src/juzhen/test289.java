package juzhen;

public class test289 {
    class Solution {
        public void gameOfLife(int[][] board) {
            // 遍历数组，将每个细胞的状态更新
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    int liveNeighbors = countLiveNeighbors(board, i, j);
                    if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                        board[i][j] = -1;
                    } else if (board[i][j] == 0 && liveNeighbors == 3) {
                        board[i][j] = 2;
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] < 0) {
                        board[i][j] = 0;
                    } else if (board[i][j] > 0) {
                        board[i][j] = 1;
                    }
                }
            }
        }

        public int countLiveNeighbors(int[][] board, int row, int col) {
            int count = 0;
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && (i != row || j != col)) {
                        count += (board[i][j] == 1|| board[i][j] == -1) ? 1 : 0;
                    }
                }
            }
            return count;
        }
    }
}
