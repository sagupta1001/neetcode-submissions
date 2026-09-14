class Solution {
    // problem
    // return numbers in a matrix in spiral order
    
    // solution
    // left to right and then down
    // right to left and then up

    // approach
    // iterate in a smart fashion
    // initialize i = 0, j = N-1
    // ith row completely
    // jth column completely

    // maintain four boundaries 
    // top, bottom, left, right
    // top = 0, bottom=M-1, left=0, right=N-1
    // first traverse top row (left to right)
    // increment top
    // then traverse right column (top to bottom)
    // decrement right
    // then traverse bottom row (right to left)
    // decrement bottom
    // then traverse left column (bottom to top)

    // repeat above until top == bottom and left == right

    // 1   2  3    4
    // 5   6  7    8
    // 9  10  11   12

    public List<Integer> spiralOrder(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        int top=0, bottom=M-1, left=0, right=N-1;
        List<Integer> output = new ArrayList<>();

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                output.add(matrix[top][i]);
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                output.add(matrix[j][right]);
            }
            right--;
            if (!(right >= left && bottom >= top)) {
                break;
            }
            for (int k = right; k >= left; k--) {
                output.add(matrix[bottom][k]);
            }
            bottom--;
            if (bottom < 0) break;
            for (int l = bottom; l >= top; l--) {
                output.add(matrix[l][left]);
            }
            left++;
        }

        return output;
    }
}
