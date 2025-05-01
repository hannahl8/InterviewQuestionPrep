package neetCode150Problems.arraysAndHashing;

import java.util.*;

/**
 * <h1>Easy NeetCode questions for Arrays and Hashing</h1>
 */
public class Easy {

    /**
     * Determines if an integer array contains any duplicates.
     * <p>
     * Given an integer array {@code nums}, this method returns {@code true} if any value
     * appears more than once in the array, and {@code false} if every element is distinct.
     * </p>
     *
     * <p><b>Example 1:</b></p>
     * <pre>
     * Input: nums = [1, 2, 3, 3]
     * Output: true
     * </pre>
     *
     * <p><b>Example 2:</b></p>
     * <pre>
     * Input: nums = [1, 2, 3, 4]
     * Output: false
     * </pre>
     *
     * <p><b>Time and Space Complexity:</b><br>
     * Recommended solution should have O(n) time and O(n) space complexity, where n is the length of the input array.
     * </p>
     *
     * @param nums the input array of integers
     * @return {@code true} if any value appears more than once, {@code false} otherwise
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }


    /**
     * Determines if two strings are anagrams of each other.
     * <p>
     * Given two strings {@code s} and {@code t}, this method returns {@code true} if {@code t}
     * is an anagram of {@code s}, meaning it contains the exact same characters with the same
     * frequency, regardless of order. Returns {@code false} otherwise.
     * </p>
     *
     * <p><b>Example 1:</b></p>
     * <pre>
     * Input: s = "racecar", t = "carrace"
     * Output: true
     * </pre>
     *
     * <p><b>Example 2:</b></p>
     * <pre>
     * Input: s = "jar", t = "jam"
     * Output: false
     * </pre>
     *
     * <p><b>Constraints:</b></p>
     * <ul>
     *   <li>{@code s} and {@code t} consist of lowercase English letters only.</li>
     * </ul>
     *
     * <p><b>Time and Space Complexity:</b><br>
     * Recommended solution should have O(n + m) time and O(1) space complexity,
     * where {@code n} is the length of {@code s} and {@code m} is the length of {@code t}.
     * </p>
     *
     * @param s the first input string
     * @param t the second input string
     * @return {@code true} if {@code t} is an anagram of {@code s}, {@code false} otherwise
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sMap.equals(tMap);
    }

    /**
     * Finds the indices of two numbers in the array that add up to a specific target.
     * <p>
     * Given an array of integers {@code nums} and an integer {@code target}, this method
     * returns an array containing two indices {@code i} and {@code j} such that
     * {@code nums[i] + nums[j] == target} and {@code i != j}.
     * The result will always contain the smaller index first.
     * </p>
     *
     * <p><b>Example 1:</b></p>
     * <pre>
     * Input: nums = [3, 4, 5, 6], target = 7
     * Output: [0, 1]
     * Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
     * </pre>
     *
     * <p><b>Example 2:</b></p>
     * <pre>
     * Input: nums = [4, 5, 6], target = 10
     * Output: [0, 2]
     * </pre>
     *
     * <p><b>Example 3:</b></p>
     * <pre>
     * Input: nums = [5, 5], target = 10
     * Output: [0, 1]
     * </pre>
     *
     * <p><b>Constraints:</b></p>
     * <ul>
     *   <li>2 <= {@code nums.length} <= 1000</li>
     *   <li>-10,000,000 <= {@code nums[i]} <= 10,000,000</li>
     *   <li>-10,000,000 <= {@code target} <= 10,000,000</li>
     *   <li>Exactly one valid answer exists for each input</li>
     * </ul>
     *
     * <p><b>Time and Space Complexity:</b><br>
     * Recommended solution should have O(n) time and O(n) space complexity,
     * where {@code n} is the size of the input array.
     * </p>
     *
     * @param nums   the input array of integers
     * @param target the target sum
     * @return an array of two integers representing the indices of the numbers that sum up to {@code target},
     * with the smaller index first
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
