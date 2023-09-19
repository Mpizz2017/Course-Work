package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;


/**
 * 
 * You need student tests if you are looking for help during office hours about
 * bugs in your code.
 * 
 * @author UMCP CS Department
 *
 */
public class StudentTests {

	@Test
	public void AddToEndtestGetSize() {
		BasicLinkedList<String> testList = new BasicLinkedList<String>();
		testList.addToEnd("hi");
		assertTrue(testList.getSize() == 1);

		assertTrue(testList.toString().equals("\" hi \""));


		testList.addToEnd("end");

		assertTrue(testList.getSize() == 2);
		assertTrue(testList.toString().equals("\" hi end \""));

		testList.addToEnd("end");
		testList.addToEnd("end");

		assertTrue(testList.toString().equals("\" hi end end end \""));
		assertTrue(testList.getSize() == 4);


	}

	@Test
	public void testAddToFront() {
		BasicLinkedList<String> testList = new BasicLinkedList<String>();
		testList.addToEnd("hi");
		testList.addToFront("front");
		assertTrue(testList.getSize() == 2);
		assertTrue(testList.toString().equals("\" front hi \""));

		BasicLinkedList<String> testList2 = new BasicLinkedList<String>();

		testList2.addToFront("front");
		assertTrue(testList2.getSize() == 1);
		assertTrue(testList2.toString().equals("\" front \""));

		testList2.addToFront("front");
		testList2.addToFront("front");

		assertTrue(testList2.getSize() == 3);
		assertTrue(testList2.toString().equals("\" front front front \""));
	}

	@Test
	public void getFirstAndLast() {
		String test;
		BasicLinkedList<String> testList = new BasicLinkedList<String>();
		testList.addToEnd("hi");
		assertEquals(testList.getFirst(), "hi");
		testList.addToEnd("end");
		assertEquals(testList.getLast(), "end");

		test = testList.getTail();
		assertEquals(test, "end");
		test = testList.getHead();
		assertEquals(test, "hi");


		testList.addToFront("Front");
		assertTrue(testList.getSize() == 3);


		test = testList.retrieveFirstElement();
		assertTrue(testList.getSize() == 2);


		assertEquals(test, "Front");

		assertTrue(testList.toString().equals("\" hi end \""));

		test = testList.retrieveLastElement();
		assertTrue(testList.getSize() == 1);


		assertEquals(test, "end");

		assertTrue(testList.toString().equals("\" hi \""));

		test = testList.retrieveFirstElement();
		test = testList.retrieveFirstElement();

		assertTrue(test == null);


		BasicLinkedList<String> testList2 = new BasicLinkedList<String>();


		testList2.addToFront("hi");
		test = testList2.getLast();

		assertEquals(test, "hi");

		BasicLinkedList<String> testList3 = new BasicLinkedList<String>();
		testList3.addToEnd("Red").addToFront("Yellow").addToFront("Blue");

		test = testList3.getLast();
		assertEquals(test, "Red");



	}

	@Test
	public void testRemove() {
		BasicLinkedList<String> testList = new BasicLinkedList<String>();

		testList.addToEnd("end");
		testList.addToFront("middle");
		testList.addToFront("front");


		assertEquals(testList.toString(), "\" front middle end \"");

		testList.remove("middle", String.CASE_INSENSITIVE_ORDER);
		assertEquals(testList.toString(), "\" front end \"");

		BasicLinkedList<String> testList2 = new BasicLinkedList<String>();

		testList2.addToEnd("end");
		testList2.addToFront("middle");
		testList2.addToFront("front");

		testList2.remove("front", String.CASE_INSENSITIVE_ORDER);
		assertEquals(testList2.toString(), "\" middle end \"");



		BasicLinkedList<String> testList3 = new BasicLinkedList<String>();

		testList3.addToEnd("end");
		testList3.addToFront("middle");
		testList3.addToFront("front");


		assertEquals(testList3.toString(), "\" front middle end \"");

		testList3.remove("end", String.CASE_INSENSITIVE_ORDER);
		assertEquals(testList3.toString(), "\" front middle \"");

		BasicLinkedList<String> testList4 = new BasicLinkedList<String>();

		testList4.remove("end", String.CASE_INSENSITIVE_ORDER);

		assertEquals(testList4.toString(), "\" \"");


		BasicLinkedList<String> testList5 = new BasicLinkedList<String>();

		testList5.addToFront("front");
		testList5.addToFront("front");
		testList5.addToFront("front");
		testList5.addToFront("front");

		testList5.remove("front", String.CASE_INSENSITIVE_ORDER);
		assertEquals(testList5.toString(), "\" \"");

	}

	@Test
	public void testItr() {

		BasicLinkedList<String> testList = new BasicLinkedList<String>();
		String test1 = "front", test2= "middle", test3 = "end";
		int counter =1;
		testList.addToEnd("end");
		testList.addToFront("middle");
		testList.addToFront("front");

		for(String list: testList) {

			if(counter ==1) {
				assertEquals(list, test1);
			}else if(counter ==2) {
				assertEquals(list, test2);

			}else {
				assertEquals(list, test3);
			}
			counter++;

		}



	}

	@Test
	public void testRevereseArray() {
		BasicLinkedList<String> testList = new BasicLinkedList<String>();
		ArrayList<String> returned = new ArrayList<String>();

		testList.addToFront("end");
		testList.addToFront("middle");
		testList.addToFront("front");

		returned = testList.getReverseArrayList();
		assertEquals(returned.get(0), "end");
		assertEquals(returned.get(1), "middle");
		assertEquals(returned.get(2), "front");

		BasicLinkedList<String> testList2 = new BasicLinkedList<String>();

		returned = testList2.getReverseArrayList();
		assertEquals(returned.get(0), null);

		BasicLinkedList<String> testList3 = new BasicLinkedList<String>();

		testList3.addToEnd("a");
		testList3.addToEnd("b");
		testList3.addToEnd("c");
		testList3.addToEnd("d");
		testList3.addToEnd("e");
		
		returned = testList3.getReverseArrayList();
		assertEquals(returned.get(0), "e");
		assertEquals(returned.get(1), "d");
		assertEquals(returned.get(2), "c");
		assertEquals(returned.get(3), "b");
		assertEquals(returned.get(4), "a");
		
		
		
		
	}

	@Test
	public void testRevereseList() {
		BasicLinkedList<String> testList = new BasicLinkedList<String>();
		BasicLinkedList<String> returned = new BasicLinkedList<String>();
		int counter =1;
		testList.addToFront("end");
		testList.addToFront("middle");
		testList.addToFront("front");

		returned = testList.getReverseList();



		for(String list: returned) {

			if(counter ==1) {
				assertEquals(list, "end");
			}else if(counter ==2) {
				assertEquals(list, "middle");

			}else {
				assertEquals(list, "front");
			}
			counter++;
		}
		
		assertTrue(returned.getSize() == 3);
		
		
		BasicLinkedList<String> testList2 = new BasicLinkedList<String>();
		
		testList2.addToEnd("a");
		testList2.addToEnd("b");
		testList2.addToEnd("c");
		testList2.addToEnd("d");
		testList2.addToEnd("e");
		
		returned = testList2.getReverseList();
		assertTrue(returned.getSize() == 5);
		
		
		counter = 1;
		
		for(String list: returned) {

			if(counter ==1) {
				assertEquals(list, "e");
			}else if(counter ==2) {
				assertEquals(list, "d");

			}else if(counter ==3){
				assertEquals(list, "c");
			}else if(counter ==4){
				assertEquals(list, "b");
			}else if(counter ==5){
				assertEquals(list, "a");
			}
			counter++;
		}
		
		
		
		
		
	}
	
	@Test
	public void testSortedLinkedList() {
		SortedLinkedList<String> testList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		
		testList.add("a");
		testList.add("c");
		assertEquals(testList.toString(), "\" a c \"");
		assertEquals(testList.getTail(), "c");
		
		testList.add("b");
		
		assertEquals(testList.toString(), "\" a b c \"");
		testList.add("z");
		
		assertEquals(testList.toString(), "\" a b c z \"");
		testList.add("x");
		assertEquals(testList.getTail(), "z");
		assertEquals(testList.toString(), "\" a b c x z \"");
		
		assertEquals(testList.getHead(), "a");
		
		
		SortedLinkedList<String> testList2 = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		testList2.add("a");
		testList2.add("a");
		testList2.add("a");
		testList2.add("c");
		testList2.add("c");
		assertEquals(testList2.toString(), "\" a a a c c \"");
		assertEquals(testList2.getSize(), 5);
		testList2.remove("c");
		assertEquals(testList2.toString(), "\" a a a \"");
		assertEquals(testList2.getSize(), 3);
		
		
		
		SortedLinkedList<String> testList3 = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		testList3.add("a");
		testList3.add("a");
		testList3.add("a");
		testList3.add("b");
		testList3.add("c");
		testList3.add("c");
		assertEquals(testList3.toString(), "\" a a a b c c \"");
		System.out.print(testList3.getSize());
		assertEquals(testList3.getSize(), 6);
		testList3.remove("a");
		
		assertEquals(testList3.toString(), "\" b c c \"");
		assertEquals(testList3.getSize(), 3);
		
		
		SortedLinkedList<String> testList4 = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		testList4.add("z");
		testList4.add("b");
		assertEquals(testList4.toString(), "\" b z \"");
		assertEquals(testList4.getSize(), 2);
		
		
		testList4.remove("b");
		assertEquals(testList4.toString(), "\" z \"");
		assertEquals(testList4.getSize(), 1);
		testList4.remove("z");
		assertEquals(testList4.toString(), "\" \"");
		assertEquals(testList4.getSize(), 0);
		
		
	}
	
	

}
