import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArraySorterTest {
    /*Add Test Cases Here
        int[] expected = {1,2,5,7,8,10};
     */
    @org.junit.jupiter.api.Test
    void testGeneralUnSorted() {
        int[] inputArray = {10, 8, 7, 1, 5, 2};
        int[] expected = {1, 2, 5, 7, 8, 10};
        ArraySorter.sort(inputArray);
        assertTrue(Arrays.equals(expected, inputArray));
    }

    @org.junit.jupiter.api.Test
    void testAlreadySorted() {
        int[] inputArray = {1, 2, 5, 7, 8, 10};
        int[] expected = {1, 2, 5, 7, 8, 10};
        ArraySorter.sort(inputArray);
        assertTrue(Arrays.equals(expected, inputArray));
    }

    @org.junit.jupiter.api.Test
    void testDescendingOrder() {
        int[] inputArray = {10, 8, 7, 5, 2, 1};
        int[] expected = {1, 2, 5, 7, 8, 10};
        ArraySorter.sort(inputArray);
        assertTrue(Arrays.equals(expected, inputArray));
    }
}