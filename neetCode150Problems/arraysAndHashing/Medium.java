package neetCode150Problems.arraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * <h1>Medium NeetCode questions for Arrays and Hashing</h1>
 */
public class Medium {

    /**
     * Groups anagrams from a list of strings.
     * <p>
     * Given an array of strings {@code strs}, this method groups all anagrams together
     * into sublists. An anagram is a word formed by rearranging the letters of another,
     * using all original letters exactly once.
     * The output can be returned in any order.
     * </p>
     *
     * <p><b>Example 1:</b></p>
     * <pre>
     * Input: strs = ["act", "pots", "tops", "cat", "stop", "hat"]
     * Output: [["hat"], ["act", "cat"], ["stop", "pots", "tops"]]
     * </pre>
     *
     * <p><b>Example 2:</b></p>
     * <pre>
     * Input: strs = ["x"]
     * Output: [["x"]]
     * </pre>
     *
     * <p><b>Example 3:</b></p>
     * <pre>
     * Input: strs = [""]
     * Output: [[""]]
     * </pre>
     *
     * <p><b>Constraints:</b></p>
     * <ul>
     *   <li>1 <= {@code strs.length} <= 1000</li>
     *   <li>0 <= {@code strs[i].length} <= 100</li>
     *   <li>{@code strs[i]} consists of lowercase English letters</li>
     * </ul>
     *
     * <p><b>Time and Space Complexity:</b><br>
     * Recommended solution should have O(m * n) time and O(m) space complexity,
     * where {@code m} is the number of strings and {@code n} is the length of the longest string.
     * </p>
     *
     * @param strs the array of input strings
     * @return a list of lists of strings, where each sublist contains grouped anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // my solution is not as space and time efficient :(
//        Map<Map<Character, Integer>, List<String>> stringMap = new HashMap<>();
//        for (String str : strs) {
//            Map<Character, Integer> charMap = new HashMap<>();
//            for (int i = 0; i < str.length(); i++) {
//                charMap.put(str.charAt(i), charMap.getOrDefault(str.charAt(i), 0) + 1);
//            }
//            stringMap.computeIfAbsent(charMap, k -> new ArrayList<>());
//            stringMap.get(charMap).add(str);
//        }
//        return new ArrayList<>(stringMap.values());

        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }

    /**
     * Finds the k most frequent elements in an integer array.
     * <p>
     * Given an array of integers {@code nums} and an integer {@code k}, this method returns
     * a list of the {@code k} elements that appear most frequently in {@code nums}.
     * The answer is guaranteed to be unique, and the order of the returned list does not matter.
     * </p>
     *
     * <p><b>Example 1:</b></p>
     * <pre>
     * Input: nums = [1, 2, 2, 3, 3, 3], k = 2
     * Output: [2, 3]
     * </pre>
     *
     * <p><b>Example 2:</b></p>
     * <pre>
     * Input: nums = [7, 7], k = 1
     * Output: [7]
     * </pre>
     *
     * <p><b>Constraints:</b></p>
     * <ul>
     *   <li>1 <= {@code nums.length} <= 10⁴</li>
     *   <li>-1000 <= {@code nums[i]} <= 1000</li>
     *   <li>1 <= {@code k} <= number of distinct elements in {@code nums}</li>
     * </ul>
     *
     * <p><b>Time and Space Complexity:</b><br>
     * Recommended solution should have O(n) time and O(n) space complexity,
     * where {@code n} is the size of the input array.
     * </p>
     *
     * @param nums the input array of integers
     * @param k    the number of top frequent elements to return
     * @return a list of {@code k} integers that are the most frequent in {@code nums}
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index] = n;
                index++;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * Encodes a list of strings to a single string and decodes it back to the original list of strings.
     * <p>
     * The {@code encode} method takes a list of strings and returns a single string that represents
     * the encoded list. The {@code decode} method takes this encoded string and decodes it back to
     * the original list of strings.
     * </p>
     *
     * <p><b>Example 1:</b></p>
     * <pre>
     * Input: ["neet", "code", "love", "you"]
     * Output: ["neet", "code", "love", "you"]
     * </pre>
     *
     * <p><b>Example 2:</b></p>
     * <pre>
     * Input: ["we", "say", ":", "yes"]
     * Output: ["we", "say", ":", "yes"]
     * </pre>
     *
     * <p><b>Constraints:</b></p>
     * <ul>
     *   <li>0 <= {@code strs.length} < 100</li>
     *   <li>0 <= {@code strs[i].length} < 200</li>
     *   <li>{@code strs[i]} contains only UTF-8 characters</li>
     * </ul>
     *
     * <p><b>Time and Space Complexity:</b><br>
     * The time complexity for each {@code encode()} and {@code decode()} call is O(m),
     * where {@code m} is the sum of the lengths of all strings. The space complexity is O(m + n),
     * where {@code m} is the sum of the lengths of all strings and {@code n} is the number of strings.
     * </p>
     *
     * @param strs the list of strings to encode or decode
     * @return the encoded string in {@code encode()} or the decoded list of strings in {@code decode()}
     */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

    /**
     * Decodes a single encoded string to a list of strings.
     *
     * @param s the encoded string
     * @return the decoded list of strings
     */
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        return res;
    }

    /**
     * Computes the product of all elements in the array except the element at each index.
     * <p>
     * Given an array of integers {@code nums}, this method returns an output array such that
     * {@code output[i]} is equal to the product of all the elements in {@code nums} except {@code nums[i]}.
     * Each product is guaranteed to fit in a 32-bit integer.
     * <p>
     * <b>Note:</b> The solution should not use the division operation and should run in O(n) time.
     * </p>
     *
     * <p><b>Example 1:</b></p>
     * <pre>
     * Input: nums = [1, 2, 4, 6]
     * Output: [48, 24, 12, 8]
     * </pre>
     *
     * <p><b>Example 2:</b></p>
     * <pre>
     * Input: nums = [-1, 0, 1, 2, 3]
     * Output: [0, -6, 0, 0, 0]
     * </pre>
     *
     * <p><b>Constraints:</b></p>
     * <ul>
     *   <li>2 <= {@code nums.length} <= 1000</li>
     *   <li>-20 <= {@code nums[i]} <= 20</li>
     *   <li>The product of any subset of the array will fit in a 32-bit integer</li>
     * </ul>
     *
     * <p><b>Time and Space Complexity:</b><br>
     * Recommended solution should run in O(n) time and O(n) space,
     * where {@code n} is the size of the input array.
     * </p>
     *
     * @param nums the input array of integers
     * @return an array where each element is the product of all elements in {@code nums} except for the one at the same index
     */
    public int[] productExceptSelf(int[] nums) {
        return new int[]{};
    }

    /**
     * Validates a partially filled 9x9 Sudoku board.
     * <p>
     * A Sudoku board is valid if the following conditions are met:
     * <ul>
     *   <li>Each row contains the digits 1-9 without duplicates</li>
     *   <li>Each column contains the digits 1-9 without duplicates</li>
     *   <li>Each of the nine 3x3 sub-boxes contains the digits 1-9 without duplicates</li>
     * </ul>
     * The board may be partially filled, and it does not need to be solvable.
     * Empty cells are represented by the character {@code '.'}.
     * </p>
     *
     * <p><b>Example 1:</b></p>
     * <pre>
     * Input:
     * board = [
     *   ["1","2",".",".","3",".",".",".","."],
     *   ["4",".",".","5",".",".",".",".","."],
     *   [".","9","8",".",".",".",".",".","3"],
     *   ["5",".",".",".","6",".",".",".","4"],
     *   [".",".",".","8",".","3",".",".","5"],
     *   ["7",".",".",".","2",".",".",".","6"],
     *   [".",".",".",".",".",".","2",".","."],
     *   [".",".",".","4","1","9",".",".","8"],
     *   [".",".",".",".","8",".",".","7","9"]
     * ]
     * Output: true
     * </pre>
     *
     * <p><b>Example 2:</b></p>
     * <pre>
     * Input:
     * board = [
     *   ["1","2",".",".","3",".",".",".","."],
     *   ["4",".",".","5",".",".",".",".","."],
     *   [".","9","1",".",".",".",".",".","3"],
     *   ["5",".",".",".","6",".",".",".","4"],
     *   [".",".",".","8",".","3",".",".","5"],
     *   ["7",".",".",".","2",".",".",".","6"],
     *   [".",".",".",".",".",".","2",".","."],
     *   [".",".",".","4","1","9",".",".","8"],
     *   [".",".",".",".","8",".",".","7","9"]
     * ]
     * Output: false
     * Explanation: The top-left 3x3 sub-box contains two '1's, which is invalid.
     * </pre>
     *
     * <p><b>Constraints:</b></p>
     * <ul>
     *   <li>{@code board.length == 9}</li>
     *   <li>{@code board[i].length == 9}</li>
     *   <li>{@code board[i][j]} is a digit '1'-'9' or '.'</li>
     * </ul>
     *
     * <p><b>Time and Space Complexity:</b><br>
     * Recommended solution should have O(n²) time and O(n²) space complexity,
     * where {@code n} is the number of rows/columns (in this case, {@code n = 9}).
     * </p>
     *
     * @param board the 9x9 character grid representing the Sudoku board
     * @return {@code true} if the board is valid according to Sudoku rules, otherwise {@code false}
     */
    public boolean isValidSudoku(char[][] board) {
        return false;
    }

    /**
     * Finds the length of the longest consecutive sequence in an unsorted array of integers.
     * <p>
     * A consecutive sequence is defined as a sequence of integers where each element is exactly
     * 1 greater than the previous one. The elements in the sequence do not need to be adjacent
     * or in order within the original array.
     * </p>
     *
     * <p><b>Example 1:</b></p>
     * <pre>
     * Input: nums = [2, 20, 4, 10, 3, 4, 5]
     * Output: 4
     * Explanation: The longest consecutive sequence is [2, 3, 4, 5].
     * </pre>
     *
     * <p><b>Example 2:</b></p>
     * <pre>
     * Input: nums = [0, 3, 2, 5, 4, 6, 1, 1]
     * Output: 7
     * Explanation: The longest consecutive sequence is [0, 1, 2, 3, 4, 5, 6].
     * </pre>
     *
     * <p><b>Constraints:</b></p>
     * <ul>
     *   <li>0 <= {@code nums.length} <= 1000</li>
     *   <li>-10⁹ <= {@code nums[i]} <= 10⁹</li>
     * </ul>
     *
     * <p><b>Time and Space Complexity:</b><br>
     * The recommended solution should run in O(n) time and use O(n) space,
     * where {@code n} is the size of the input array.
     * </p>
     *
     * @param nums the input array of integers
     * @return the length of the longest consecutive sequence
     */
    public int longestConsecutive(int[] nums) {
        return 0;
    }

}
