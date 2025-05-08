package neetCode150Problems.twoPointers;

public class Easy {

    /**
     * Determines whether the given string is a valid palindrome.
     * <p>
     * A palindrome is a string that reads the same forward and backward.
     * This method ignores case and non-alphanumeric characters.
     * </p>
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>Input: "Was it a car or a cat I saw?" → Output: true</li>
     *   <li>Input: "tab a cat" → Output: false</li>
     * </ul>
     *
     * <p>Constraints:</p>
     * <ul>
     *   <li>1 <= s.length <= 1000</li>
     *   <li>The string consists of printable ASCII characters</li>
     * </ul>
     *
     * <p>Recommended Time and Space Complexity:</p>
     * <ul>
     *   <li>Time: O(n)</li>
     *   <li>Space: O(1)</li>
     * </ul>
     *
     * @param s The input string to check.
     * @return true if the input string is a palindrome (ignoring case and non-alphanumeric characters), false otherwise.
     */
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !isAlphaNum(s.charAt(l))) {
                l++;
            }
            while (l < r && !isAlphaNum(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isAlphaNum(char c) {
        return (c >= 'a' && c <= 'z' ||
                c >= 'A' && c <= 'Z' ||
                c >= '0' && c <= '9');
    }


}
