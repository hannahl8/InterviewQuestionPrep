package assessmentProblems.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of unique integers {@code numbers}, determine how many pairs of indices {@code (i, j)} exist
 * such that {@code i ≤ j} and the sum {@code numbers[i] + numbers[j]} is equal to a power of 2.
 * <p>
 * Powers of 2 are defined as: {@code 2^0 = 1, 2^1 = 2, 2^2 = 4, 2^3 = 8, ...}
 * </p>
 *
 * <p>Examples:</p>
 * <pre>
 * Example 1:
 * numbers = [1, -1, 2, 3]
 * Output = 5
 * Explanation:
 *   - (1, 2): -1 + 2 = 1 (2^0)
 *   - (0, 0): 1 + 1 = 2 (2^1)
 *   - (1, 3): -1 + 3 = 2 (2^1)
 *   - (0, 3): 1 + 3 = 4 (2^2)
 *   - (2, 2): 2 + 2 = 4 (2^2)
 *
 * Example 2:
 * numbers = [2]
 * Output = 1
 * Explanation:
 *   - (0, 0): 2 + 2 = 4 (2^2)
 *
 * Example 3:
 * numbers = [-2, -1, 0, 1, 2]
 * Output = 5
 * Explanation:
 *   - (2, 3): 0 + 1 = 1 (2^0)
 *   - (1, 4): -1 + 2 = 1 (2^0)
 *   - (2, 4): 0 + 2 = 2 (2^1)
 *   - (3, 3): 1 + 1 = 2 (2^1)
 *   - (4, 4): 2 + 2 = 4 (2^2)
 * </pre>
 *
 * @implNote The input constraints guarantee:
 * <ul>
 *   <li>{@code 1 ≤ numbers.length ≤ 10^5}</li>
 *   <li>{@code -10^6 ≤ numbers[i] ≤ 10^6}</li>
 * </ul>
 */

public class TwoPower {

    /**
     * This method counts the number of pairs of indices (i, j) such that the sum of numbers[i] and numbers[j]
     * is a power of 2.
     *
     * @param numbers the array of unique integers
     * @return the count of pairs (i, j) such that numbers[i] + numbers[j] is a power of 2
     */
    public static int solution(int[] numbers) {
        Map<Integer, Integer> counts = new HashMap<>();
        int answer = 0;

        for (int element : numbers) {
            counts.put(element, counts.getOrDefault(element, 0) + 1);
            for (int two_power = 0; two_power <= 20; two_power++) {
                int second_element = (1 << two_power) - element;
                answer += counts.getOrDefault(second_element, 0);
            }
        }
        return answer;
    }

    /**
     * This method counts the number of pairs of indices (i, j) such that the sum of numbers[i] and numbers[j]
     * is a power of 2.
     *
     * @param numbers the array of unique integers
     * @return the count of pairs (i, j) such that numbers[i] + numbers[j] is a power of 2
     */
    public static int mySolution(int[] numbers) {
        int count = 0;
        int j = 0;
        while (j < numbers.length) {
            int i = 0;
            while (i <= j) {
                int sum = numbers[i] + numbers[j];
                double v = Math.log(sum) / Math.log(2);
                if (sum != 0 && Math.ceil(v) == Math.floor(v)) {
                    count++;
                }
                i++;
            }
            j++;
        }
        return count;
    }
}
