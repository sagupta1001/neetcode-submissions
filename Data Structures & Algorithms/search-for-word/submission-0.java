class Solution {

    private static final int[][] DIRS = {
        {-1,0},{1,0},{0,-1},{0,1}
    };
    private Set<Pair<Integer, Integer>> path = new HashSet<>();


    private boolean dfs(char[][] board, int curRow, int curCol, int searchIndex, String word) {
        if (searchIndex == word.length()) {
            return true;
        }

        if (curRow < 0 || curRow >= board.length || curCol < 0 || curCol >= board[0].length ||
            word.charAt(searchIndex) != board[curRow][curCol] || path.contains(new Pair<>(curRow, curCol)))
            {
                return false;
            }

        path.add(new Pair<>(curRow, curCol));
        boolean res = dfs(board, curRow + 1, curCol, searchIndex+1, word) ||
                        dfs(board, curRow - 1, curCol, searchIndex+1, word) ||
                        dfs(board, curRow, curCol+1, searchIndex+1, word) ||
                        dfs(board, curRow, curCol-1, searchIndex+1, word);
        path.remove(new Pair<>(curRow, curCol));

        return res;
    }

    public boolean exist(char[][] board, String word) {
        int nr = board.length;
        int nc = board[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                boolean found = dfs(board, r, c, 0, word);
                if (found) return true;
            }
        }

        return false;
    }
}
