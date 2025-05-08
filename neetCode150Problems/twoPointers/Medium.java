package neetCode150Problems.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium {

    /**
     * Can you find two distinct indices in a sorted array such that the numbers at those indices add up to the given target?
     * <p>
     * Given a sorted array of integers in non-decreasing order, this method returns the 1-indexed positions of two numbers
     * that sum to the specified target. It is guaranteed that exactly one valid solution exists, and the same element cannot
     * be used twice.
     * </p>
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>Input: numbers = [1, 2, 3, 4], target = 3 → Output: [1, 2]</li>
     *   <li>Explanation: 1 + 2 = 3, and since the array is 1-indexed, we return [1, 2]</li>
     * </ul>
     *
     * <p>Constraints:</p>
     * <ul>
     *   <li>2 <= numbers.length <= 1000</li>
     *   <li>-1000 <= numbers[i] <= 1000</li>
     *   <li>-1000 <= target <= 1000</li>
     *   <li>Exactly one solution will exist</li>
     * </ul>
     *
     * <p>Recommended Time and Space Complexity:</p>
     * <ul>
     *   <li>Time: O(n)</li>
     *   <li>Space: O(1) additional space</li>
     * </ul>
     *
     * @param numbers A sorted array of integers in non-decreasing order.
     * @param target  The target sum to find.
     * @return An array containing the 1-indexed positions [index1, index2] such that numbers[index1 - 1] + numbers[index2 - 1] == target.
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[]{};
    }


    /**
     * Can you find all unique triplets in the array that sum to zero?
     * <p>
     * Given an integer array, this method returns all unique triplets [nums[i], nums[j], nums[k]]
     * such that i, j, and k are distinct indices and nums[i] + nums[j] + nums[k] == 0.
     * Duplicate triplets must not be included in the result.
     * The output list and the order of triplets can be returned in any order.
     * </p>
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>Input: nums = [-1, 0, 1, 2, -1, -4]</li>
     *   <li>Output: [[-1, -1, 2], [-1, 0, 1]]</li>
     *   <li>Explanation: These are the only unique triplets that sum to 0.</li>
     *
     *   <li>Input: nums = [0, 1, 1]</li>
     *   <li>Output: []</li>
     *
     *   <li>Input: nums = [0, 0, 0]</li>
     *   <li>Output: [[0, 0, 0]]</li>
     * </ul>
     *
     * <p>Constraints:</p>
     * <ul>
     *   <li>3 <= nums.length <= 1000</li>
     *   <li>-10⁵ <= nums[i] <= 10⁵</li>
     * </ul>
     *
     * <p>Recommended Time and Space Complexity:</p>
     * <ul>
     *   <li>Time: O(n²)</li>
     *   <li>Space: O(1) additional space (not counting output list)</li>
     * </ul>
     *
     * @param nums The input array of integers.
     * @return A list of all unique triplets [nums[i], nums[j], nums[k]] such that their sum is zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                }
            }
        }
        return res;
    }

    /**
     * Can you find the two lines that, together with the x-axis, form a container that holds the most water?
     * <p>
     * Given an array of integers where each element represents the height of a vertical line on the x-axis,
     * this method computes the maximum area of water that can be contained between any two lines.
     * The container's area is determined by the shorter of the two lines multiplied by the distance between them.
     * </p>
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>Input: height = [1, 7, 2, 5, 4, 7, 3, 6] → Output: 36</li>
     *   <li>Input: height = [2, 2, 2] → Output: 4</li>
     * </ul>
     *
     * <p>Constraints:</p>
     * <ul>
     *   <li>2 <= height.length <= 1000</li>
     *   <li>0 <= height[i] <= 1000</li>
     * </ul>
     *
     * <p>Recommended Time and Space Complexity:</p>
     * <ul>
     *   <li>Time: O(n)</li>
     *   <li>Space: O(1)</li>
     * </ul>
     *
     * @param heights An array of non-negative integers representing vertical lines on the x-axis.
     * @return The maximum area of water that can be contained between any two lines.
     */
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (l < r) {
            int currArea = (r - l) * Math.min(heights[l], heights[r]);
            maxArea = Math.max(currArea, maxArea);
            if (heights[l] < heights[r]) {
                l++;
            } else if (heights[l] > heights[r]) {
                r--;
            } else {
                if (heights[l + 1] > heights[r - 1]) {
                    l++;
                } else if (heights[l + 1] < heights[r - 1]) {
                    r--;
                } else {
                    l++; // if they're still equal just shift one already lol
                }
            }
        }
        return maxArea;
    }
}
