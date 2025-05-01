package assessmentProblems.code;

/**
 * You have been given a 2D array of integers, int[][] arr. The array is a matrix of size n x m. Your need to return the
 * number of crosses in the matrix. A cross is defined as lines crossing horizontally and vertically with
 * the same number in all the cells, except the center cell, sometimes.
 */
public class Crosses {
    /**
     * Count the number of crosses in a 2D array
     *
     * @param arr the 2D array
     * @return the number of crosses
     */
    public static int numberOfCrosses(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (isCross(arr, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Check if the element at (i, j) is a cross
     *
     * @param arr the array
     * @param i   the row index
     * @param j   the column index
     * @return true if the element at (i, j) is a cross, false otherwise
     */
    public static boolean isCross(int[][] arr, int i, int j) {
        int rowVal = -1;
        int colVal = -1;

        // Check horizontal line (row)
        for (int k = 0; k < arr[i].length; k++) {
            if (k == j) continue; // skip center
            if (rowVal == -1) {
                rowVal = arr[i][k];
            } else if (arr[i][k] != rowVal) {
                return false;
            }
        }

        // Check vertical line (column)
        for (int k = 0; k < arr.length; k++) {
            if (k == i) continue; // skip center
            if (colVal == -1) {
                colVal = arr[k][j];
            } else if (arr[k][j] != colVal) {
                return false;
            }
        }

        // Finally, check both row and column values are the same
        return rowVal == colVal;
    }

}
