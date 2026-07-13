class Solution {
    // Problem
    // 2-D matrix grid representing 
    // fruit states
    // Find the minimum number of minutes for all
    // fruits to be rotten

    // Approach:
    // Breadth first search from all of the 
    // rotten fruits and keep track of the 
    // number of minutes to get all fruits
    // rotten. Return the total minutes taken to
    // spread completely 

    // Pseudo code:
    // Set Total Number of Fresh fruits
    // Set array of rotten fruit cells 
    // Iterate through each cell in the rth row
    // - Iterate through each cell in the cth col
    //   - Check if cell is rotten
    //.    - if cell is rotten then add to an 
    //     - array of rotten fruit cells 
    // BFS using initial rotten fruit cells
    // Return overall min value


    int[][] directions = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int orangesRotting(int[][] grid) {
        // Pseudo code:
        // Set Total Number of Fresh fruits
        int totalFresh = 0;
        // Set array of rotten fruit cells 
        List<int[]> rottenCells = new ArrayList<>();
        // Iterate through each cell in the rth row
        for (int r = 0; r < grid.length; r++) {
            // - Iterate through each cell in the cth col
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    rottenCells.add(new int[]{r,c});
                }
                if (grid[r][c] == 1) {
                    totalFresh++;
                }
            }
        }
        // if no rotten and no fresh
        if (rottenCells.size() == 0 && totalFresh == 0) {
            return 0;
        }
        // if no rotten
        if (rottenCells.size() == 0) {
            return -1;
        }
        return bfs(grid, rottenCells, totalFresh);
        //   - Check if cell is rotten
        //.    - if cell is rotten then add to an 
        //     - array of rotten fruit cells 
        // BFS using initial rotten fruit cells
        // Return overall min value
    }

    private int[] getNeighbour(int[] cell, int[] dir) {
        return new int[]{cell[0] + dir[0], cell[1] + dir[1]};
    }

    private boolean ifIsValid(int[] neighbour, int[][] grid) {
        if (neighbour[0] < 0 || neighbour[0] >= grid.length
            || neighbour[1] < 0 || neighbour[1] >= grid[0].length
            || grid[neighbour[0]][neighbour[1]] == 0 || 
            grid[neighbour[0]][neighbour[1]] == 2 ) {
                return false;
            }
        return true;
    }

    // BFS
    private int bfs(int[][] grid, List<int[]> rottenCells, int totalFresh) {
        // grid matrix, r, c, arrRotten

        // add all initial r,c from arrRotten to queue
        Queue<int[]> queue = new LinkedList<>();
        for (int[] cell : rottenCells) {
            queue.add(cell);
        }
        // minutes to zero
        int minutes = 0;

        // while queue not empty
        while (queue.size() != 0) {
            // pop from queue until queue empty
            List<int[]> currentLevel = new ArrayList<>();
            while (queue.size() != 0) {
                currentLevel.add(queue.poll());
            }

            for (int[] cell : currentLevel) {
                // for each popped cell
                // check for valid neighbours
                for (int[] dir : directions) {
                    int[] neighbour = getNeighbour(cell, dir);
     
                    if (ifIsValid(neighbour, grid)){
                        // set valid neighbours to be rotten
                        grid[neighbour[0]][neighbour[1]] = 2;
                        queue.add(neighbour);
                        totalFresh--;
                    }
                }
            }
            // - bound checks
            // - not empty
            // - only fresh fruits are valid

            // queue up valid neighbours from all popped cells

            // if no valid neighbours
            if (queue.size() == 0) {
                //  - if total number of fresh fruits left is zero
                //      - return numIters
                //  - else return -1
                if (totalFresh == 0) {
                    return minutes;
                } else {
                    return -1;
                }
            }

            minutes++;
            // if there are valid neighbours
                // increment minutes by one

            // total number of fresh fruits deduct valid neigbour count
        }
        // return minutes
        return minutes;
    }
    

}
