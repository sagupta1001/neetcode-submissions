class Solution {

    private int getSquare(int row, int col) {
        // [0,0] -> 0
        // [2,2] -> 0
        // [3,3] -> 4
        // [5,5] -> 4
        // [7,2] -> 6

        // row 0 -> 2 = square -> 0 
        // row 3 -> 5 = square -> 3
        // row 6 -> 8 = square -> 6
        // row / 3 * 3

        // col 0 -> 8 = square -> 0 to 2
        // col / 3
        return row / 3 * 3 + col / 3;
    }

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rowChecker = new HashMap<>();
        HashMap<Integer, HashSet<Character>> colChecker = new HashMap<>();
        HashMap<Integer, HashSet<Character>> squareChecker = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                int s = getSquare(r, c);
                if (rowChecker.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                    colChecker.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                    squareChecker.computeIfAbsent(s, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }
                rowChecker.get(r).add(board[r][c]);
                colChecker.get(c).add(board[r][c]);
                squareChecker.get(s).add(board[r][c]);
            }
        }

        return true;
    }
}
