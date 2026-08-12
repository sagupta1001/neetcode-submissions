class Solution {
    // problem
    // determine cells where water can flow to both 
    // pacific and atlantic oceans

    // approach
    // for each cell start a traversal
    // see if it can reach the pacific ocean and the atlantic ocean
    // - if height of neighbour is less than current cell then keep 
    // - traversing
    // if it can, then keep track of that cell

    // runtime, iterate through every cell is O(N*M) and traversal is also
    // upto O(N*M) so O(N^2*M^2)

    // alternative:
    // do the traversal for pacific border and then atlantic border,
    // and then do a set intersection type to get common cells
    // pacific ocean border cells
    // [0,0 to N-1] and [0->M-1, 0]
    // atlantic ocean border cells
    // [M,0 to N-1] and [N-1, 0->N-1]
    // traversal
    // - keep iterating while height of neighbours is higher

    // pacificAtlantic
    // for every pacific ocean border cell
    // - start dfs
    // - boolean matrix will track 
    // - which island cells are visited


    // for every atlantic ocean border cell
    // - start dfs
    // - boolean matrix will track
    // - which island cells are visited


    // dfs(int cr, int cc, int[][] heights, boolean[][] visited)
    // - mark  boolean matrix at cr, cc as true
    // - get neighbours
    // - - check neighbours valid 
    // - - check neighbours not visited
    // - - check neighbours of greater height than cr, cc at heights
    // - - dfs(..) with each valid neighbour

    private int[][] directions = {{1,0},{-1,0},
                                  {0,1},{0,-1}};
    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        for (int[] d : directions) {
            int nr = r+d[0], nc = c + d[1];
            if (nr >= 0 && nr < heights.length &&
                nc >= 0 && nc < heights[0].length &&
                !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    dfs(nr, nc, ocean, heights);
                }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights);
            dfs(ROWS-1, c, atl, heights);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, COLS-1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }
}
