package listClasses;

import java.util.*;

import listClasses.BasicLinkedList.Node;


/**
 * Implements a generic sorted list using a provided Comparator. It extends
 * BasicLinkedList class.
 * 
 *  @author Dept of Computer Science, UMCP
 *  
 */

public class SortedLinkedList<T> extends BasicLinkedList<T> {
	private Comparator<T> comparator;


	/**
	 * 
	 * Creates an empty list that is associated with the specified comparator.
	 * 
	 * @param comparator
	 */
	public SortedLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;

	}


	/**
	 * takes in param element and adds to a sorted linked listed based on the 
	 * comparator brought in
	 * 
	 * @param element
	 * 
	 * @return returns a sorted Linked list 
	 */
	public SortedLinkedList<T> add(T element){
		Node curr = head;
		Node prev = head;
		Node newNode = new Node(element);

		
		//sets first node if the list is empty
		if(head == null) {
			newNode.next = null;
			head = newNode;
			tail = newNode;
			listSize++;
			return this;
		}else {
			//loops through the rest of the list 
			while(!(curr == null)) {
				
				//compares the element being added and the item that curr node 
				//is pointing at
				if(comparator.compare(element, curr.data) < 0)  {
					if(curr == head) {
						//if the current node is head and the element goes before
						newNode.next = head;
						head = newNode;
						tail = newNode;
					}else {
						//if the current node is not head and the element goes
						//before
						newNode.next = curr;
						prev.next = newNode;
					}
					listSize++;
					return this;
				}
				//iterates through list
				prev = curr;
				curr = curr.next;
			}
			
			//sets the new node to the end if it is not found
			newNode.next = curr;
			prev.next = newNode;
			tail = newNode;

		}
		listSize++;
		return this;
	}
	
	/**
	 * calls BasicLinkedList super remove
	 * @param targetData
	 * 
	 * @return Sortedlinked List with all instances of targetData Removed
	 */
	public SortedLinkedList<T> remove(T targetData){

		return (SortedLinkedList<T>) super.remove(targetData, comparator);

	}

	
	/*
	 * Overrides BasicLinkedList addToEnd method as this is a sorted linked list 
	 */
	@Override
	public BasicLinkedList<T> addToEnd(T data){ 
		throw new UnsupportedOperationException();
	}

	
	/*
	 * Overrides BasicLinkedList addToFront method as this is a sorted linked list 
	 */
	@Override
	public BasicLinkedList<T> addToFront(T data){
		throw new UnsupportedOperationException();
	}



}