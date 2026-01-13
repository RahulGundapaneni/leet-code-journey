class Solution {
    public boolean isValidSudoku(char[][] board) {

        // 1. Check rows
        for (int i = 0; i < 9; i++) {
            boolean[] check = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int a = board[i][j] - '1';
                    if (check[a]) return false;
                    check[a] = true;
                }
            }
        }

        // 2. Check columns
        for (int i = 0; i < 9; i++) {
            boolean[] check = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int a = board[j][i] - '1';
                    if (check[a]) return false;
                    check[a] = true;
                }
            }
        }

        // 3. Check 3x3 boxes
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                boolean[] check = new boolean[9];

                for (int i = boxRow * 3; i < boxRow * 3 + 3; i++) {
                    for (int j = boxCol * 3; j < boxCol * 3 + 3; j++) {
                        if (board[i][j] != '.') {
                            int a = board[i][j] - '1';
                            if (check[a]) return false;
                            check[a] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
