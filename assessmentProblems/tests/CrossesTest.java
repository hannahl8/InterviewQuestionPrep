package assessmentProblems.tests;

import assessmentProblems.code.Crosses;
import org.junit.jupiter.api.Assertions;

/**
 * Test class for the crosses class
 */
class CrossesTest {

    private final int[][] oneCross = {
            {1, 1, 1, 2},
            {1, 1, 1, 2},
            {1, 1, 1, 2},
            {2, 2, 2, 2}
    };

    private final int[][] twoCrosses = {
            {2, 2, 2, 2},
            {1, 1, 1, 2},
            {1, 1, 1, 2},
            {2, 2, 2, 2}
    };

    private final int[][] fourCrosses = {
            {1, 2},
            {2, 1}
    };

    private final int[][] noCrosses = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };
    private final int[][] empty = {};
    private final int[][] oneElement = {
            {1}
    };
    private final int[][] oneRow = {
            {1, 2, 3, 4}
    };
    private final int[][] oneColumn = {
            {1},
            {2},
            {3},
            {4}
    };

    /**
     * Test the numberOfCrosses method
     */
    @org.junit.jupiter.api.Test
    void numberOfCrosses() {
        printMatrix(oneCross);
        Assertions.assertEquals(1, Crosses.numberOfCrosses(oneCross));
        System.out.println();
        printMatrixOnlyCrosses(oneCross);

        System.out.println("---------------------");
        printMatrix(twoCrosses);
        Assertions.assertEquals(2, Crosses.numberOfCrosses(twoCrosses));
        System.out.println();
        printMatrixOnlyCrosses(twoCrosses);

        System.out.println("---------------------");
        printMatrix(fourCrosses);
        Assertions.assertEquals(4, Crosses.numberOfCrosses(fourCrosses));
        System.out.println();
        printMatrixOnlyCrosses(fourCrosses);

        System.out.println("---------------------");
        printMatrix(noCrosses);
        Assertions.assertEquals(0, Crosses.numberOfCrosses(noCrosses));
        System.out.println();
        printMatrixOnlyCrosses(noCrosses);

        System.out.println("---------------------");
        printMatrix(empty);
        Assertions.assertEquals(0, Crosses.numberOfCrosses(empty));
        System.out.println();
        printMatrixOnlyCrosses(empty);

        System.out.println("---------------------");
        printMatrix(oneElement);
        Assertions.assertEquals(1, Crosses.numberOfCrosses(oneElement));
        System.out.println();
        printMatrixOnlyCrosses(oneElement);

        System.out.println("---------------------");
        printMatrix(oneRow);
        Assertions.assertEquals(0, Crosses.numberOfCrosses(oneRow));
        System.out.println();
        printMatrixOnlyCrosses(oneRow);

        System.out.println("---------------------");
        printMatrix(oneColumn);
        Assertions.assertEquals(0, Crosses.numberOfCrosses(oneColumn));
        System.out.println();
        printMatrixOnlyCrosses(oneColumn);
    }

    /**
     * Prints the matrix only at the intersection of crosses
     *
     * @param arr the matrix to print
     */
    private void printMatrixOnlyCrosses(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (Crosses.isCross(arr, i, j)) {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints the matrix
     *
     * @param arr the matrix to print
     */
    private void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}