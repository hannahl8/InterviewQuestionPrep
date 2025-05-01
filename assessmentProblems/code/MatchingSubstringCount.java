package assessmentProblems.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two strings, {@code pattern} and {@code source}, can you count how many substrings of {@code source}
 * match the format described by {@code pattern}?
 * <p>
 * The {@code pattern} string consists only of characters '0' and '1', where:
 * <ul>
 *   <li>'0' represents a vowel</li>
 *   <li>'1' represents a consonant</li>
 * </ul>
 * The {@code source} string contains only lowercase English letters.
 * <p>
 * A substring {@code source[l..r]} is considered a match if:
 * <ul>
 *   <li>It has the same length as {@code pattern}</li>
 *   <li>Every '0' in {@code pattern} corresponds to a vowel in {@code source[l..r]}</li>
 *   <li>Every '1' in {@code pattern} corresponds to a consonant in {@code source[l..r]}</li>
 * </ul>
 * Vowels are considered to be: {@code ['a', 'e', 'i', 'o', 'u', 'y']}. All other lowercase letters are consonants.
 *
 * <p>Examples:</p>
 * <pre>
 * pattern = "010"
 * source  = "amazing"
 * Output  = 2
 * Explanation:
 * "010" matches "ama" and "azi"
 *
 * pattern = "100"
 * source  = "codesignal"
 * Output  = 0
 * Explanation:
 * No substrings match the required pattern of consonant-vowel-vowel
 * </pre>
 */
public class MatchingSubstringCount {

    /**
     * A set of characters that are considered vowels.
     */
    private static final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));

    /**
     * This method checks if the substring of {@code source} starting at {@code startIndex} matches the {@code pattern}.
     *
     * @param pattern    the pattern to match
     * @param source     the source string
     * @param startIndex the starting index in the source string
     * @return 1 if the substring matches the pattern, 0 otherwise
     */
    public static int checkForPattern(String pattern, String source, int startIndex) {
        for (int offset = 0; offset < pattern.length(); offset++) {
            char patternChar = pattern.charAt(offset);
            char sourceChar = source.charAt(startIndex + offset);
            if (patternChar == '0') {
                if (!vowels.contains(sourceChar)) {
                    return 0;
                }
            } else {
                if (vowels.contains(sourceChar)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    /**
     * This method counts the number of substrings in {@code source} that match the {@code pattern}.
     *
     * @param pattern the pattern to match
     * @param source  the source string
     * @return the number of matches
     */
    public static int solution(String pattern, String source) {
        int answer = 0;
        for (int startIndex = 0; startIndex <= source.length() - pattern.length(); startIndex++) {
            answer += checkForPattern(pattern, source, startIndex);
        }
        return answer;
    }

    /**
     * This was the method I used to solve the problem.
     *
     * @param pattern the pattern to match
     * @param source  the source string
     * @return the number of matches
     */
    public static int mySolution(String pattern, String source) {
        int l = 0;
        int r = pattern.length();
        int total = 0;
        while (r < source.length()) {
            String sub = source.substring(l, r);
            StringBuilder subPattern = new StringBuilder();
            for (int i = 0; i < sub.length(); i++) {
                if (isVowel(sub.charAt(i))) {
                    subPattern.append('0');
                } else {
                    subPattern.append('1');
                }
            }
            if (subPattern.toString().contains(pattern)) {
                total++;
            }
            l++;
            r++;
        }
        return total;
    }

    /**
     * Check if a character is a vowel.
     * @param c the character to check
     * @return true if the character is a vowel, false otherwise
     */
    public static boolean isVowel(char c) {
        return (c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u' ||
                c == 'y');
    }


}
