package codeSignalLearning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Welcome to this introductory lesson focused on List Operations without the use of built-in functions.
 * While Java provides powerful methods within its Collections framework to simplify list operations, understanding the
 * concepts behind these key functions significantly improves your ability to solve complex problems and prepares you
 * for scenarios where built-in methods may not exist, or if they do, may not offer the optimal solution.
 */
public class ListOperations {
    /**
     * Can you write a Java function that returns the zero-based index of the first occurrence of a given value
     * {@code val} in a list of {@code n} integers?
     * <p>
     * If the value is not found in the list, the function should return {@code -1}.
     * </p>
     *
     * <p>
     * You must implement this function without using any built-in search methods.
     * Specifically, the use of {@code List.indexOf()} or similar utility methods is not allowed.
     * A manual linear search should be implemented using a loop.
     * </p>
     *
     * <p>Examples:</p>
     * <pre>
     * {@code
     * solution(Arrays.asList(1, 3, 5, 7), 5); // returns 2
     * solution(Arrays.asList(2, 4, 6), 3);     // returns -1
     * }
     * </pre>
     *
     * @param list the list of integers to search through
     * @param val  the value to find
     * @return the index of the first occurrence of {@code val}, or {@code -1} if not found
     */
    public int solution(List<Integer> list, int val) {
        for (int num = 0; num < list.size(); num++) {
            if (list.get(num) == val) {
                return num;
            }
        }
        return -1;
    }


    /**
     * Can you write a Java function that returns the number of unique elements in a list of integers?
     * <p>
     * An element is considered unique if it appears exactly once in the list. This function should count
     * how many such unique elements exist.
     * </p>
     *
     * <p>Example:</p>
     * <pre>
     * {@code
     * countUniqueElements(Arrays.asList(1, 2, 3, 2, 4)); // returns 3
     * // Explanation: The unique elements are 1, 3, and 4.
     * }
     * </pre>
     *
     * @param nums the list of integers to examine
     * @return the number of elements that appear exactly once in the list
     */
    public int countUniqueElements(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * Can you write a Java function that returns the reversed version of a list of integers?
     * <p>
     * The function should return a new list where the elements are in reverse order compared to the input list.
     * You must implement this manually without using any built-in Java functions or methods related to reversing a list,
     * such as {@code Collections.reverse()} or streams.
     * </p>
     *
     * <p>Example:</p>
     * <pre>
     * {@code
     * reverseList(Arrays.asList(1, 2, 3, 4)); // returns [4, 3, 2, 1]
     * }
     * </pre>
     *
     * @param numbers the original list of integers to reverse
     * @return a new list containing the elements of {@code numbers} in reverse order
     */
    public List<Integer> reverseList(List<Integer> numbers) {
        List<Integer> rev = new ArrayList<>();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            rev.add(numbers.get(i));
        }
        return rev;
    }
}
