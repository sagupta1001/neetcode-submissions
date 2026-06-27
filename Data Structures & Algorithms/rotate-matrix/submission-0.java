class Solution {
    // Problem: rotate the matrix (square matrix)
    // in place
    // Examples
    // Input: matrix = [
    // [1,2],
    // [3,4]
    // ]
    // Output: [
    // [3,1],
    // [4,2]
    // ]

    // row 1 -> col 2
    // 0,0 -> 0,1
    
    // 0,0 -> 0,2
    // i,j -> 

    // 0,1 -> 1,2
    
    // outer layer
    //   

    public void rotate(int[][] matrix) {
        reverse(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverse(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }
    }
}
