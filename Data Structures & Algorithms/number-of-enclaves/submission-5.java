class Solution {

    // 1st Step: Define the problem 
    // understand the input / output
    // understand the constraints

    // 2 matrix of integers
    // 0 is water
    // 1 is land

    // we can walk in four cardinal directions
    // and only on land

    // we want to find land that is surrounded by water 
    // on all sides i.e an island

    // number of land cells in total across all such enclaves

    // constraints
    // M and N from 1 to 500
    // grid values are either 0 / 1

    // 2nd Step: Approach to solving the problem & walkthrough a couple of examples & edge cases

    // 1 on the boundary cannot be part of an enclave
    // Start with row index 1 to M-1 and from column index 1 to N-1
    // End with row index M - 1 and column index N - 1
    // E.g. M = 3, N = 3

    // Iterate through
    // - encounter a 1
    //   - DFS traversal in the four cardinal directions 
    //   - if all four directions return that they could not lead to off the boundary then this is 
    //   - an enclave.
    // - keep track of visited cells

    // - encounter a 0 or visited
    //  - skip

    // 3rd Step: Pseudo Code & walkthrough a couple of examples & 1-2 edge cases
    // initialize rowIndex and columIndex 
    // initialize sizeOfEnclave
    // outerloop that iterates I through rowIndex from 1 to M-1
    // innerloop that iterates J through colIndex from 1 to N-1
    // check the cell at I,J
    //  if cell value is 1
    //      sizeOfEnclave += dfs(I, J, grid)
    //  else
    //      do nothing
    
    // return sizeOfEnclave

    // dfs(rowIndex, colIndex, grid)
    //  initialize temp size of enclave as 1
    //  initialize stack<Pair> with rowIndex / colIndex
    //  
    //  Loop through a direction array
    //      pop from stack
    //      mark rowIndex / colIndex as visited
    //      compute nextRowIndex 
    //      compute nextColIndex
    //      check bounds i.e. nextRowIndex < 0 or > M or nextColIndex < 0 or > N then 
    //          return not an enclave return 0
    //      check if nextRowIndex / nextColIndex is visited
    //          return part of another enclave return 0
    //      if nextRowIndex / nextColIndex is water
    //          continue
    //      else 
    //          add nextRowIndex / nextColIndex to Stack
    //          temp size of enclave ++

    // return tempsize of enclave


    // 4th Step: Code & test with couple of examples

    private static final int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    private static final int VISITED = -1;
    private static final int DO_NOT_VISIT_AGAIN = -2;
    private static final int DEBUG = 0;

    // dfs(rowIndex, colIndex, grid)

    //
    // grid=[[0,0,0,0],
    //       [0,1,1,0],
    //       [0,1,1,0],
    //       [0,0,0,0]]

    // [[0,0,1,0],
    //  [0,1,1,0],
    //  [0,1,0,0],
    //  [0,0,0,0]]


    private int dfs(int rowIndex, int colIndex, int[][] grid) {
        if (DEBUG == 1)
            System.out.println("START EXPLORING " + rowIndex + "," + colIndex);
        int M = grid.length;
        int N = grid[0].length;
        int tempSizeOfEnclave = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{rowIndex, colIndex});
        ArrayList<int[]> currentPath = new ArrayList<>();

        while (stack.size() != 0) {
            // should be land
            int[] current = stack.pop();
            currentPath.add(current);
            if (DEBUG == 1)
                System.out.println("current land coordinates " + current[0] + "," + current[1]);
            if (grid[current[0]][current[1]] != VISITED)
                tempSizeOfEnclave += 1;
            grid[current[0]][current[1]] = VISITED;
            if (DEBUG == 1)
                System.out.println("marked as visited "+ current[0] + "," + current[1]);
            if (DEBUG == 1)
                System.out.println("size of enclave " + tempSizeOfEnclave);

            for (int[] dir : directions) {
                if (DEBUG == 1) {
                    System.out.println("Exploring direction " + dir[0] + "," + dir[1]);
                }

                int nextRowIndex = current[0] + dir[0];
                int nextColIndex = current[1] + dir[1];

                if (DEBUG == 1)
                    System.out.println("next " + nextRowIndex + "," + nextColIndex);

                if (nextRowIndex < 0 || nextRowIndex >= M ||
                    nextColIndex < 0 || nextColIndex >= N ||
                    grid[nextRowIndex][nextColIndex] == DO_NOT_VISIT_AGAIN) {
                        if (DEBUG == 1)
                            System.out.println("nextRow / nextCol out of bounds or DO NOT VISIT");
                        for (int[] cp : currentPath) {
                            grid[cp[0]][cp[1]] = DO_NOT_VISIT_AGAIN;
                        }
                        return 0;
                    }
                if (grid[nextRowIndex][nextColIndex] == VISITED) {
                    if (DEBUG == 1)
                        System.out.println("nextRow / nextCol visited already - continuing to explore");
                    continue;
                }
                if (grid[nextRowIndex][nextColIndex] == 0) {
                    if (DEBUG == 1)
                        System.out.println("nextRow / nextCol is water - continuing to explore other directions");
                    continue;
                } else {
                    stack.add(new int[]{nextRowIndex, nextColIndex});
                }
            }
        }
        if (DEBUG == 1) {
            System.out.println("End exploring " + rowIndex + "," + colIndex);
            System.out.println("Returning size of enclave " + tempSizeOfEnclave);
        }

        return tempSizeOfEnclave;
    }
    //  initialize temp size of enclave as 1
    //  initialize stack<Pair> with rowIndex / colIndex
    //  
    //  Loop through a direction array
    //      pop from stack
    //      compute nextRowIndex 
    //      compute nextColIndex
    //      check bounds i.e. nextRowIndex < 0 or >= M or nextColIndex < 0 or >= N then 
    //          return not an enclave return 0
    //      check if nextRowIndex / nextColIndex is visited
    //          return part of another enclave return 0
    //      if nextRowIndex / nextColIndex is water
    //          continue
    //      else 
    //          add nextRowIndex / nextColIndex to Stack
    //          temp size of enclave ++

    // return tempsize of enclave

    public int numEnclaves(int[][] grid) {
        // 3rd Step: Pseudo Code & walkthrough a couple of examples & 1-2 edge cases
        // initialize rowIndex and columIndex 
        int rowIndex = 1, colIndex = 1;
        int totalSizeOfEnclave = 0;
        int M = grid.length;
        int N = grid[0].length;
        // initialize sizeOfEnclave
        // outerloop that iterates I through rowIndex from 1 to M-1
        for (int i = rowIndex; i < M-1; i++) {
            for (int j = colIndex; j < N-1; j++) {
                if (grid[i][j] == 1) {
                    totalSizeOfEnclave += dfs(i, j, grid);
                }
            }
        }

        return totalSizeOfEnclave;
    }
}