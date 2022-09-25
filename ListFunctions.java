package p1;

public class ListFunctions {
    /**
     * Return true if the list is empty. COMPLEXITY O(1).
     *
     * Examples:
     *
     * * isEmpty(makeList()) should return true
     * * isEmpty(makeList(0)) should return false
     *
     * @param list The list.
     * @return True if the list is empty; false otherwise.
     */
    public static boolean isEmpty(ListNode <?> list) {
        if (list == null) {
        	return true;
        }
    	return false;
    }

    /**
     * Get the number of elements in the list. COMPLEXITY O(N).
     *
     * Examples:
     *
     * * size(makeList()) should return 0
     * * size(makeList(0, 1)) should return 2
     *
     * @param list The list.
     * @return The size of the list.
     */
    public static int size(ListNode <?> list) {
    	return size(list, 0);
    }

    /**
     * NEW METHOD Recursive helper method for size().
     *
     * @param list The list.
     * @param count The number of nodes counted so far.
     * @return The size of the list.
     */
    public static int size(ListNode <?> list, int count) {
    	if (list == null) {
    		return count;
    	}
    	return size(list.getRest(), count + 1);
    }
    
    /**
     * Get the element at the index. COMPLEXITY O(N).
     *
     * The index is assumed to be in range.
     *
     * Examples:
     *
     * * get(makeList(0, 1, 4, 9), 2) should return 4
     *
     * @param list The list.
     * @param index The index of the desired element.
     * @return The element at the index.
     * 
     * NOTE: because return type is an int, only works for ListNodes with int data
     */
    public static <T> int get(ListNode <?> list, int index) {
        return (Integer) get(list, index, 0).getFirst();
    }
    
    /**
     * Get the Node at the index. COMPLEXITY O(N).
     *
     * The index is assumed to be in range.
     *
     * @param list The list.
     * @param index The index of the desired element.
     * @return The node at the index.
     */
    public static ListNode <?> getNode(ListNode <?> list, int index) {
        return get(list, index, 0);
    }


    /**
     * NEW METHOD Recursive helper method for get().
     *
     * @param list The list.
     * @param index The index of the desired element.
     * @param cur The index of the current element.
     * @return The element at the index.
     */
    public static ListNode <?> get(ListNode <?> list, int index, int cur) {
    	if (cur == index) {
    		return list;
    	}
    	return get(list.getRest(), index, cur + 1);
    }
    
    /**
     * Get the index of the first occurrence of the element. COMPLEXITY O(N).
     *
     * Examples:
     *
     * * indexOf(makeList(0, 3, 3, 4), 3) should return 1
     *
     * @param list The list
     * @param element The element.
     * @return The index of the first occurrence element, or -1 if it is not in
     *   the list.
     *   
     * NOTE: because element param is an int, only works for ListNodes with int data
     */
    public static <T> int indexOf(ListNode <?> list, int element) {
        return indexOf(list, element, 0);
    }

    /**
     * NEW METHOD Recursive helper method for indexOf().
     *
     * @param list The list.
     * @param element The element.
     * @param index The index of the current element.
     * @return The index of the first occurrence element, or -1 if it is not in
     *   the list.
     */
    public static <T> int indexOf(ListNode <?> list, int element, int index) {
    	if (list == null) {
    		return -1; //returns -1 if element is not found
    	}
    	if (list.getFirst().equals(element)) {
    		return index;
    	}
    	return indexOf(list.getRest(), element, index + 1);
    }
    
    /**
     * Get the index of the last occurrence of the element. COMPLEXITY O(N).
     *
     * Examples:
     *
     * * lastIndexOf(makeList(0, 3, 3, 4), 3) should return 2
     *
     * @param list The list
     * @param element The element.
     * @return The index of the last occurrence element, or -1 if it is not in
     *   the list.
     */
    public static <T> int lastIndexOf(ListNode <?> list, int element) {
    	 return lastIndexOf(list, element, 0, -1);
    }

    /**
     * NEW METHOD Recursive helper method for LastIndexOf().
     *
     * @param list The list.
     * @param element The element.
     * @param index The index of the current element.
     * @param location The latest index where the element has been found.
     * @return The index of the last occurrence element, or -1 if it is not in
     *   the list.
     */
    public static <T> int lastIndexOf(ListNode <?> list, int element, int index, int index2) {
    	if (list == null) {
    		return index2; //returns -1 if element is not found
    	}
    	if (list.getFirst().equals(element)) {
    		return lastIndexOf(list.getRest(), element, index + 1, index);
    	}
    	return lastIndexOf(list.getRest(), element, index + 1, index2);
    }

    /**
     * Return true if the two lists are the same. COMPLEXITY O(N).
     *
     * Examples:
     *
     * * equals(makeList(1, 2), makeList(1, 2)) should return true
     * * equals(makeList(1, 2), makeList(1, 1)) should return false
     *
     * @param list1 The first list.
     * @param list2 The second list.
     * @return True if the lists are equal; false otherwise.
     */
    public static boolean equals(ListNode <?> list1, ListNode<?> list2) {
    	if (list1 == null && list2 == null) {
    		return true; //returns true if no differences found by list end
    	}
    	if (list1 == null || list2 == null) {
    		return false; //returns false if lists are different sizes
    	}
    	if (!list1.getFirst().equals(list2.getFirst())) {
    		return false;
    	}
    	return equals(list1.getRest(), list2.getRest());
    }
    
    /**
     * Create a new, reversed list. COMPLEXITY O(N).
     *
     * Examples:
     *
     * * reverse(makeList(1, 2, 3)) should be equivalent to makeList(3, 2, 1)
     *
     * @param list The list to reverse.
     * @return A new list that is reversed of the argument.
     */
    public static ListNode <?> reverse(ListNode <?> list) {
    	ListNode <?> reverse = null;
        return reverse(list, reverse);
    }

    /**
     * NEW METHOD Recursive helper method for reverse().
     *
     * @param list The original list.
     * @param reverse The reversed list.
     * @return list containing all elements of list but in reversed order
     */
    public static ListNode <?> reverse(ListNode <?> list, ListNode <?> reverse) {
    	if (list == null) {
    		return reverse;
    	}
    	reverse = new ListNode <> (list.getFirst(), reverse);
    	return reverse(list.getRest(), reverse);
    }
    
    /**
     * Get the first n elements of a list. COMPLEXITY O(N).
     *
     * n is assumed to between 0 and the size of the list, inclusive.
     *
     * Examples:
     *
     * * headList(makeList(1, 2, 3, 4), 2) should be equivalent to
     *   makeList(1, 2)
     *
     * @param list The list.
     * @param n The number of elements to get.
     * @return The head list of the specified size.
     */
    public static ListNode <?> headList(ListNode <?> list, int n) {
    	ListNode <?> head = null;
    	return reverse(headList(list, head, 0, n));
    }

    /**
     * NEW METHOD Recursive helper method for headList().
     *
     * @param list The original list.
     * @param head The first n elements of a list.
     * @param index The index of the current element.
     * @param n The number of elements to get.
     * @return list containing the first n elements of the original.
     */
    public static ListNode <?> headList(ListNode <?> list, ListNode <?> head, int index, int n) {
    	if (index == n) {
    		return head;
    	}
    	head = new ListNode <> (list.getFirst(), head);
    	return headList(list.getRest(), head, index + 1, n);
    }

    /**
     * Get the last n elements of a list. COMPLEXITY O(N).
     *
     * n is assumed to between 0 and the size of the list, inclusive.
     *
     * Examples:
     *
     * * tailList(makeList(1, 2, 3, 4), 2) should be equivalent to
     *   makeList(3, 4)
     *
     * @param list The list.
     * @param n The number of elements to get.
     * @return The tail list of the specified size.
     */
    public static ListNode<?> tailList(ListNode<?> list, int n) {
        return reverse(headList(reverse(list), n));
    }

    /**
     * Get the slice of the list between the start and end indices. COMPLEXITY O(N).
     *
     * start and end are assumed to be between 0 and the size of
     * the list, inclusive, and that start <= end.
     *
     * Examples:
     *
     * * subList(makeList(1, 2, 3, 4), 1, 3) should be equivalent to
     *   makeList(2, 3)
     *
     * @param list The list.
     * @param start The first index to include in the slice.
     * @param end The first index to exclude from the slice.
     * @return The slice of the list between the start and end indices.
     */
    public static ListNode<?> subList(ListNode<?> list, int start, int end) {
    	ListNode <?> sub = null;
        return reverse(subList(get(list, start, 0), sub, start, end));
    }

    /**
     * NEW METHOD Recursive helper method for subList().
     *
     * @param list The original list.
     * @param sub The sublist.
     * @param index The index of the current element.
     * @param end The index to end at.
     * @return list containing the elements cur - end of the original.
     */
    public static ListNode <?> subList(ListNode <?> list, ListNode <?> sub, int index, int end) {
    	if (index > end) {
    		return sub;
    	}
    	sub = new ListNode <> (list.getFirst(), sub);
    	return subList(list.getRest(), sub, index + 1, end);
    }
    
    /**
     * Add an element at the end of the list. COMPLEXITY O(N).
     *
     * * add(makeList(1, 2), 3) should be equivalent to makeList(1, 2, 3)
     *
     * @param list The list.
     * @param element The element to add.
     * @return The list with the new element added.
     */
    public static ListNode <?> add(ListNode<?> list, int element) {
    	return reverse(new ListNode <> (element, reverse(list)));
    }
    
    /**
     * Add all of the second list to the end of the first list. COMPLEXITY O(N).
     *
     * * addAll(makeList(1, 2), makeList(3, 4)) should be equivalent to
     *   makeList(1, 2, 3, 4)
     *
     * @param list1 The first list.
     * @param list2 The second list.
     * @return A new list that combines the two lists.
     */
    public static ListNode <?> addAll(ListNode<?> list1, ListNode<?> list2) {
    	return reverse(addAllR(reverse(list1), list2));
    }
    
    /**
     * NEW METHOD recursive helper for addAll().
     *
     * @param list1 The initial list.
     * @param list2 The list to add.
     * @return A new list that combines the two lists.
     */
    public static ListNode <?> addAllR(ListNode <?> list1, ListNode <?> list2){
    	if (list2 == null) {
    		return list1;
    	}
    	return addAllR(new ListNode <> (list2.getFirst(), list1), list2.getRest());
    }
}