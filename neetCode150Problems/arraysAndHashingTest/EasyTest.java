package neetCode150Problems.arraysAndHashingTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import neetCode150Problems.arraysAndHashing.Easy;

public class EasyTest {

    @Test
    public void testContainsDuplicate_True() {
        int[] nums = {1, 2, 3, 3};
        assertTrue(Easy.containsDuplicate(nums));
    }

    @Test
    public void testContainsDuplicate_False() {
        int[] nums = {1, 2, 3, 4};
        assertFalse(Easy.containsDuplicate(nums));
    }

    @Test
    public void testIsAnagram_True() {
        String s = "racecar";
        String t = "carrace";
        assertTrue(Easy.isAnagram(s, t));
    }

    @Test
    public void testIsAnagram_False() {
        String s = "jar";
        String t = "jam";
        assertFalse(Easy.isAnagram(s, t));
    }

    @Test
    public void testTwoSum_Example1() {
        int[] nums = {3, 4, 5, 6};
        int target = 7;
        int[] expected = {0, 1};
        assertArrayEquals(expected, Easy.twoSum(nums, target));
    }

    @Test
    public void testTwoSum_Example2() {
        int[] nums = {4, 5, 6};
        int target = 10;
        int[] expected = {0, 2};
        assertArrayEquals(expected, Easy.twoSum(nums, target));
    }

    @Test
    public void testTwoSum_Example3() {
        int[] nums = {5, 5};
        int target = 10;
        int[] expected = {0, 1};
        assertArrayEquals(expected, Easy.twoSum(nums, target));
    }
}
