package p1;

import java.lang.AssertionError;

public class ListFunctionsTestUtils {

    /**
     * Create a ListNode list.
     *
     * @param array Any number of integers that should be in the list.
     */
    public static ListNode <Integer> makeList(int ... array) {
        ListNode <Integer> result = null;
        for (int i = array.length - 1; i >= 0; i--) {
            result = new ListNode <Integer> (array[i], result);
        }
        return result;
    }

    /**
     * Check if two booleans are the same.
     *
     * @param actual The boolean to check.
     * @param expected The expected (correct) boolean.
     */
    public static void assertEquals(boolean actual, boolean expected) {
        if (actual != expected) {
            throw new AssertionError("Expected " + expected + " but got " + actual);
        }
    }

    /**
     * Check if two ints are equal.
     *
     * @param actual The computed integer to check.
     * @param expected The expected (correct) integer.
     */
    public static void assertEquals(Object actual, Object expected) {
        if (!actual.equals(expected)) {
            throw new AssertionError("Expected " + expected + " but got " + actual);
        }
    }

    /**
     * Check if two lists contain the same elements.
     *
     * @param actual The list to check.
     * @param expected The expected (correct) list to check against.
     */
    public static void assertEquals(ListNode <?> actual, ListNode <?> expected) {
        int i = 0;
        while (actual != null && expected != null) {
            if (actual.getFirst() != expected.getFirst()) {
                throw new AssertionError("Expected " + expected.getFirst() + " at index " + i + " but got " + actual.getFirst() + ".");
            }
            actual = actual.getRest();
            expected = expected.getRest();
            i++;
        }
        if (actual == null && expected != null) {
            throw new AssertionError("Expected " + expected.getFirst() + " at index " + i + " but the list ended prematurely.");
        } else if (actual != null && expected == null) {
            throw new AssertionError("Expected the list to have size " + i + " but got more elements.");
        }
    }
    
    /**
     * Convert a list to String form.
     *
     * @param list The list.
     * @return The String.
     */
    public static String toString(ListNode <?> list) {
    	String result = "";
    	for (int i = 0; i < ListFunctions.size(list) - 1; i++) {
    		result += ListFunctions.get(list, i);
    	}
    	return result;
    }
}
