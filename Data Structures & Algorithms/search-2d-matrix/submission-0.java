class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Find row
        int sR = 0;
        int eR = m - 1;
        int row = -1;
        while (sR <= eR) {
            int mid = (sR + eR) / 2;
            if (matrix[mid][0] <= target && matrix[mid][n-1] >= target){
                row = mid;
                break;
            } else if( matrix[mid][0] > target) {
                eR = mid - 1;
            } else if (matrix[mid][n-1] < target) {
                sR = mid + 1;
            }
        }

        if (row == -1) {
            return false;
        }

        int sC = 0;
        int eC = n - 1;

        while (sC <= eC) {
            int mid = (sC + eC) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                sC = mid + 1;
            } else {
                eC = mid - 1;
            }
        }

        return false;
    }
}
