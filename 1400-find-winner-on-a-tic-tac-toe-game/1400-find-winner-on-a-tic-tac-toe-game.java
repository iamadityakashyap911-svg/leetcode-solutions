class Solution {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];

        // A = 1, B = 2
        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];

            board[r][c] = (i % 2 == 0) ? 1 : 2;

            if (checkWinner(board, board[r][c])) {
                return board[r][c] == 1 ? "A" : "B";
            }
        }

        // 9 moves made and nobody won
        if (moves.length == 9) {
            return "Draw";
        }

        return "Pending";
    }

    private boolean checkWinner(int[][] board, int player) {
        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) {
                return true;
            }
        }

        // Columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player &&
                board[1][j] == player &&
                board[2][j] == player) {
                return true;
            }
        }

        // Main diagonal
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) {
            return true;
        }

        // Other diagonal
        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) {
            return true;
        }

        return false;
    }
}