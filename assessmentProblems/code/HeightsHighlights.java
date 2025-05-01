package assessmentProblems.code;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Heights Highlights</h1>
 * <p>You have been given an array of integers, int[] heights.
 * A highlight is a number that is greater than the number to its left and the number to its right.
 * So a number is a highlight if the following conditions are met:</p>
 * <pre><code>
 *  height [i] > height[i - 1] or if height[i - 1] does not exist.
 *  height [i] > height[i + 1] or if height[i + 1] does not exist.
 * </code></pre>
 * <p>You need to add the smallest highlight in the list to a new list {@code int[] highlights}
 * and remove it from the heights list and continue the process.</p>
 * Example:</li>
 * <pre><code>
 * heights = [2, 7, 8, 5 ,1, 6, 3, 9, 4]
 * highlights = [6, 8, 7, 5, 2, 9, 4, 3, 1]
 * </code></pre>
 * <p>Write a function that returns the new array {@code highlights}:</p>
 * <pre><code>
 *     public int[] heightsHighlights(int[] heights) {
 *         int[] highlights = new int[heights.length];
 *         // TODO: implement the function
 *         return highlights;
 *     }
 * </code></pre>
 */
public class HeightsHighlights {

    /**
     * Function to find the highlights in the heights list
     *
     * @param heights the list of heights
     * @return the array of highlights
     */
    public static int[] heightsHighlights(int[] heights) {
        List<Integer> highlights = new ArrayList<>();
        while (heights.length > 0) {
            int minHighlight = Integer.MAX_VALUE;
            for (int i = 0; i < heights.length; i++) {
                if ((i == 0 || heights[i] > heights[i - 1]) && (i == heights.length - 1 || heights[i] > heights[i + 1])) {
                    minHighlight = Math.min(minHighlight, heights[i]);
                }
            }
            highlights.add(minHighlight);
            int[] newHeights = new int[heights.length - 1];
            int index = 0;
            for (int height : heights) {
                if (height != minHighlight) {
                    newHeights[index++] = height;
                }
            }
            heights = newHeights;
        }
        // Convert the list of highlights to an array
        int[] highlightsArray = new int[highlights.size()];
        for (int i = 0; i < highlights.size(); i++) {
            highlightsArray[i] = highlights.get(i);
        }
        return highlightsArray;
    }
}
