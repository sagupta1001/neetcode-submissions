class Solution {
    // Problem
    // 1x1 chess board
    // [["Q"]]

    // approach
    // place a queen on a cell in a row
    // and then place a queen on a valid cell in the next row
    // and repeat, until there is a row for which no valid cell is possible
    // then backtrack back
    // if the we reached the Nth row, and found a valid cell to place the queen
    // then add that arrangement to the final result

    // pseudo code
    // each row must not conflict with any of the prior rows. 
    // check if current cell row conflicts with prior row Queen's row index
    // check if current cell col conflicts with prior row Queen's column index
    // check if current cell col is +/-R with Rth prior row Queen's column index

private List<List<String>> res;

private void dfs(int n, int curRow, int[][] curTraversal) {
    if (curRow == n + 1) {
        List<String> board = new ArrayList<>();

        for (int r = 1; r <= n; r++) {
            StringBuilder row = new StringBuilder();

            for (int c = 1; c <= n; c++) {
                row.append(curTraversal[r - 1][c - 1] == 1 ? 'Q' : '.');
            }

            board.add(row.toString());
        }

        res.add(board);
        return;
    }

    // try placing queen in each column of current row
    for (int col = 1; col <= n; col++) {

        if (!isValid(curRow, col, n, curTraversal)) {
            continue;
        }

        // place queen
        curTraversal[curRow - 1][col - 1] = 1;

        // move to next row
        dfs(n, curRow + 1, curTraversal);

        // backtrack
        curTraversal[curRow - 1][col - 1] = 0;
    }
}

private boolean isValid(int row, int col, int n, int[][] board) {
    // check previous rows only
    for (int r = 1; r < row; r++) {
        for (int c = 1; c <= n; c++) {

            if (board[r - 1][c - 1] == 1) {

                // same column
                if (c == col) {
                    return false;
                }

                // diagonal
                if (Math.abs(row - r) == Math.abs(col - c)) {
                    return false;
                }
            }
        }
    }

    return true;
}

public List<List<String>> solveNQueens(int n) {
    res = new ArrayList<>();

    int[][] curTraversal = new int[n][n];

    dfs(n, 1, curTraversal);

    return res;
}
}
