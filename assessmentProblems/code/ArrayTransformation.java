package assessmentProblems.code;

/**
 * Given an integer array {@code a}, can you construct a new array {@code b} of the same length,
 * where each element {@code b[i]} is defined as the sum of {@code a[i - 1]}, {@code a[i]}, and {@code a[i + 1]}?
 * <p>
 * If an index goes out of bounds (i.e., {@code i - 1 < 0} or {@code i + 1 >= a.length}),
 * use {@code 0} in place of the missing value.
 * </p>
 *
 * <p>For example:</p>
 * <pre>
 * Input:  a = [4, 0, 1, -2, 3]
 * Output: b = [4, 5, -1, 2, 1]
 *
 * Explanation:
 * b[0] = 0 + a[0] + a[1]     = 0 + 4 + 0   = 4
 * b[1] = a[0] + a[1] + a[2]  = 4 + 0 + 1   = 5
 * b[2] = a[1] + a[2] + a[3]  = 0 + 1 + -2  = -1
 * b[3] = a[2] + a[3] + a[4]  = 1 + -2 + 3  = 2
 * b[4] = a[3] + a[4] + 0     = -2 + 3 + 0  = 1
 * </pre>
 */
public class ArrayTransformation {

    /**
     * This method takes an integer array {@code a} and constructs a new array {@code b}
     * where each element {@code b[i]} is the sum of {@code a[i - 1]}, {@code a[i]}, and {@code a[i + 1]}.
     *
     * @param a the input array of integers
     * @return the transformed array {@code b} as described above
     */
    public static int[] transformArray(int[] a) {
        int n = a.length;
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            b[i] = a[i];
            if (i > 0) {
                b[i] += a[i - 1];
            }
            if (i < n - 1) {
                b[i] += a[i + 1];
            }
        }

        return b;
    }

    /**
     * This method is my solution to the same problem.
     * It constructs a new array {@code b} where each element {@code b[i]} is the sum of {@code a[i - 1]}, {@code a[i]}, and {@code a[i + 1]}.
     *
     * @param a the input array of integers
     * @return the transformed array {@code b} as described above
     */
    public static int[] mySolution(int[] a) {
        int[] b = new int[a.length];
        if (a.length == 1) {
            return a;
        }
        for (int i = 0; i <= a.length - 1; i++) {
            if (i == 0) {
                b[i] = a[i] + a[i + 1];
            } else if (i == a.length - 1) {
                b[i] = a[i - 1] + a[i];
            } else {
                b[i] = a[i - 1] + a[i] + a[i + 1];
            }
        }
        return b;
    }
}
