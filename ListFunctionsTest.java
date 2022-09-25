package p1;

public class ListFunctionsTest {
	
	public static void main (String [] args) {
		
		ListNode <Integer> even = ListFunctionsTestUtils.makeList(new int [] {0, 1, 2, 3, 4, 5});
		ListNode <Integer> odd = ListFunctionsTestUtils.makeList(new int [] {0, 1, 2, 3, 4});
		ListNode <Integer> one = ListFunctionsTestUtils.makeList(new int [] {0});
		ListNode <Integer> empty = ListFunctionsTestUtils.makeList(new int [] {});
		
		ListFunctionsTestUtils.assertEquals(ListFunctions.isEmpty(even), false);
		ListFunctionsTestUtils.assertEquals(ListFunctions.isEmpty(empty), true);
		System.out.println("pass isEmpty()");
		
		ListFunctionsTestUtils.assertEquals(ListFunctions.size(odd), 5);
		ListFunctionsTestUtils.assertEquals(ListFunctions.size(one), 1);
		ListFunctionsTestUtils.assertEquals(ListFunctions.size(empty), 0);
		System.out.println("pass size()");
		
		for (int i = 0; i < ListFunctions.size(odd); i++) {
			ListFunctionsTestUtils.assertEquals(ListFunctions.get(odd, i), i);
		}
		System.out.println("pass get()");
		
		for (int i = 0; i < ListFunctions.size(odd); i++) {
			ListFunctionsTestUtils.assertEquals(ListFunctions.indexOf(odd, i), i);
			ListFunctionsTestUtils.assertEquals(ListFunctions.lastIndexOf(odd, i), i);
		}
		ListFunctionsTestUtils.assertEquals(ListFunctions.indexOf(ListFunctionsTestUtils.makeList(0, 3, 3, 4), 3), 1);
		ListFunctionsTestUtils.assertEquals(ListFunctions.lastIndexOf(ListFunctionsTestUtils.makeList(0, 3, 3, 4), 3), 2);
		System.out.println("pass indexOf() and lastIndexOf()");
		
		ListFunctionsTestUtils.assertEquals(ListFunctions.equals(even, even), true);
		ListFunctionsTestUtils.assertEquals(ListFunctions.equals(empty, empty), true);
		ListFunctionsTestUtils.assertEquals(ListFunctions.equals(one, one), true);
		ListFunctionsTestUtils.assertEquals(ListFunctions.equals(even, odd), false);
		ListFunctionsTestUtils.assertEquals(ListFunctions.equals(one, empty), false);
		ListFunctionsTestUtils.assertEquals(ListFunctions.equals(odd, ListFunctionsTestUtils.makeList(new int [] {6, 4, 3, 7, 3})), false);
		System.out.println("pass equals()");
		
		ListFunctionsTestUtils.assertEquals(ListFunctions.reverse(odd), ListFunctionsTestUtils.makeList(new int [] {4, 3, 2, 1, 0}));
		ListFunctionsTestUtils.assertEquals(ListFunctions.reverse(even), ListFunctionsTestUtils.makeList(new int [] {5, 4, 3, 2, 1, 0}));
		ListFunctionsTestUtils.assertEquals(ListFunctions.reverse(ListFunctionsTestUtils.makeList(new int [] {0, 1})), ListFunctionsTestUtils.makeList(new int [] {1, 0}));
		ListFunctionsTestUtils.assertEquals(ListFunctions.reverse(empty), empty);
		ListFunctionsTestUtils.assertEquals(ListFunctions.reverse(one), one);
		System.out.println("pass reverse()");
		
		ListFunctionsTestUtils.assertEquals(ListFunctions.headList(even, 6), even);
		ListFunctionsTestUtils.assertEquals(ListFunctions.headList(even, 0), empty);
		ListFunctionsTestUtils.assertEquals(ListFunctions.headList(even, 3), ListFunctionsTestUtils.makeList(new int [] {0, 1, 2}));
		System.out.println("pass headList()");
		
		ListFunctionsTestUtils.assertEquals(ListFunctions.tailList(even, 6), even);
		ListFunctionsTestUtils.assertEquals(ListFunctions.tailList(even, 0), empty);
		ListFunctionsTestUtils.assertEquals(ListFunctions.tailList(even, 3), ListFunctionsTestUtils.makeList(new int [] {3, 4, 5}));
		System.out.println("pass tailList()");
		
		ListFunctionsTestUtils.assertEquals(ListFunctions.subList(even, 0, 5), even);
		ListFunctionsTestUtils.assertEquals(ListFunctions.subList(even, 0, 2), ListFunctions.headList(even, 3));
		ListFunctionsTestUtils.assertEquals(ListFunctions.subList(even, 3, 5), ListFunctions.tailList(even, 3));
		ListFunctionsTestUtils.assertEquals(ListFunctions.subList(even, 1, 3), ListFunctionsTestUtils.makeList(new int [] {1, 2, 3}));
		ListFunctionsTestUtils.assertEquals(ListFunctions.subList(even, 0, 0), one);
		System.out.println("pass subList()");
		
		ListFunctionsTestUtils.assertEquals(ListFunctions.add(empty, 0), one);
		ListFunctionsTestUtils.assertEquals(ListFunctions.add(odd, 5), even);
		ListFunctionsTestUtils.assertEquals(ListFunctions.add(ListFunctionsTestUtils.makeList(new int [] {1, 2}), 3), ListFunctionsTestUtils.makeList(new int [] {1, 2, 3}));
		System.out.println("pass add()");
		
		ListFunctionsTestUtils.assertEquals(ListFunctions.addAll(odd, ListFunctionsTestUtils.makeList(new int [] {5})), even);
		ListFunctionsTestUtils.assertEquals(ListFunctions.addAll(ListFunctionsTestUtils.makeList(new int [] {5}), odd), ListFunctionsTestUtils.makeList(new int [] {5, 0, 1, 2, 3, 4}));
		ListFunctionsTestUtils.assertEquals(ListFunctions.addAll(empty, odd), odd);
		ListFunctionsTestUtils.assertEquals(ListFunctions.addAll(odd, empty), odd);
		ListFunctionsTestUtils.assertEquals(ListFunctions.addAll(even, odd), ListFunctionsTestUtils.makeList(new int [] {0, 1, 2, 3, 4, 5, 0, 1, 2, 3, 4}));
		System.out.println("pass addAll()");
		
		System.out.println("pass all :)");
	}
}
