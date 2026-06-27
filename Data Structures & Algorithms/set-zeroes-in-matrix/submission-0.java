class Solution {
    // Problem: 
    // If an element is 0, set its entire row and column to 0
    // E.g. 1
    // Input: matrix = [
    // [0,1],
    // [1,0]
    // ] 
    // Output: [
    // [0,0],
    // [0,0]
    // ]

    // Approach:
    // Brute force
    // iterate through the matrix
    // if a 0 is encountered, then zero out the entire row
    // after zeroing out the row, move to next row
    // keep track of the column index for later
    // after iterating the matrix, revisit the 
    // tracked columns and zero out entire column
    // i checked that this approach is working for the examples in the problem
    // but it does not work if there are multiple zeros in the same row, so this won't work
    // well it tells me that we cannot zero out the entire row either
    // perhaps we store the row, col index of the zeros in the first pass
    // set<integer> for all the rows with zero
    // set<integer> for all the cols with zero
    // iterate through the two sets and zero out

    public void setZeroes(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int c = 0; c < numCols; c++) {
            if (matrix[0][c] == 0) {
                firstRowZero = true;
            }
        }

        for (int r = 0; r < numRows; r++) {
            if (matrix[r][0] == 0) {
                firstColZero = true;
            }
        }

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for (int r = 1; r < numRows; r++) {
            for (int c = 1; c < numCols; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int c = 0; c < numCols; c++) {
                matrix[0][c] = 0;
            }
        }

        if (firstColZero) {
            for (int r = 0; r < numRows; r++) {
                matrix[r][0] = 0;
            }
        }

    }
}
