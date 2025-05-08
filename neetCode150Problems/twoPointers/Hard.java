package neetCode150Problems.twoPointers;

public class Hard {
    /**
     * How much water can be trapped after raining between the bars of an elevation map?
     * <p>
     * Given an array of non-negative integers where each element represents the height of a vertical bar (width = 1),
     * this method calculates the total amount of water that can be trapped between the bars after rainfall.
     * </p>
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>Input: height = [0, 2, 0, 3, 1, 0, 1, 3, 2, 1]</li>
     *   <li>Output: 9</li>
     * </ul>
     *
     * <p>Constraints:</p>
     * <ul>
     *   <li>1 <= height.length <= 1000</li>
     *   <li>0 <= height[i] <= 1000</li>
     * </ul>
     *
     * <p>Recommended Time and Space Complexity:</p>
     * <ul>
     *   <li>Time: O(n)</li>
     *   <li>Space: O(n) or better</li>
     * </ul>
     *
     * @param height An array representing the elevation map, where each element is the height of a bar.
     * @return The total volume of water that can be trapped after raining.
     */
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];
        int total = 0;
        while (l < r) {
            if (maxL <= maxR) {
                l++;
                maxL = Math.max(maxL, height[l]);
                total += maxL - height[l];
            } else {
                r--;
                maxR = Math.max(maxR, height[r]);
                total += maxR - height[r];
            }
        }
        return total;
    }
}
