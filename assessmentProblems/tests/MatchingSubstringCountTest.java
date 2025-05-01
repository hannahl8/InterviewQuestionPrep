package assessmentProblems.tests;

import assessmentProblems.code.MatchingSubstringCount;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchingSubstringCountTest {

    @Test
    public void testCountMatchingSubstrings() {
        String str = "amazing";
        String subStr = "010";
        int expectedCount = 2;
        int actualCount = MatchingSubstringCount.solution(subStr, str);
        assertEquals(expectedCount, actualCount);

        str = "codesignal";
        subStr = "100";
        expectedCount = 0;
        actualCount = MatchingSubstringCount.solution(subStr, str);
        assertEquals(expectedCount, actualCount);
    }


    @Test
    public void testMySolution() {
        String str = "amazing";
        String subStr = "010";
        int expectedCount = 2;
        int actualCount = MatchingSubstringCount.mySolution(subStr, str);
        assertEquals(expectedCount, actualCount);

        str = "codesignal";
        subStr = "100";
        expectedCount = 0;
        actualCount = MatchingSubstringCount.mySolution(subStr, str);
        assertEquals(expectedCount, actualCount);
    }



}