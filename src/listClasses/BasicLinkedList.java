package listClasses;

import java.util.*;




public class BasicLinkedList<T> implements Iterable<T> {

	/* Node definition */
	 class Node {
		protected T data;
		protected Node next;

		protected Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/* We have both head and tail */
	protected Node head, tail;

	/* size */
	protected int listSize;


	/**
	 * standard constructor, sets head and tail nodes to nulll and sets listsize to 
	 * 0
	 */
	public BasicLinkedList() {
		head = null;
		tail = null;
		listSize = 0;
	}

	/**
	 * gets the list size
	 * @return listSize
	 */
	public int getSize() {
		return listSize;
	}



	/**
	 * add a node with T data to th end of a linkedList 
	 * @param data
	 * @return current object with added node
	 */
	public BasicLinkedList<T> addToEnd(T data){
		listSize++;

		Node newNode = new Node(data);
		Node curr = head;


		//if the list is empty 
		if(head == null) {
			newNode.next = head;
			head = newNode;
			tail = newNode;
			return this;
		}

		//iterates through the list 
		while(!(curr.next == null)) {
			curr = curr.next;
		}

		//last element setting proper pointers
		newNode.next = curr.next;
		curr.next = newNode;
		tail = newNode;

		return this;
	}

	/**
	 * add a node with T data to the front of a linkedList 
	 * @param data
	 * @return current object with added node
	 */
	public BasicLinkedList<T> addToFront(T data){
		listSize++;

		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;

		//if size is one sets sets the tail to the only node in the list 
		if(listSize == 1) {
			tail = newNode;
		}

		return this;
	}


	/**
	 * returns the data in the first node of a list
	 * @return
	 */
	public T getFirst() {
		if(head == null) {
			return null;
		}else {
			return head.data;
		}
	}

	/**
	 * returns the data in the last node of a list
	 * @return
	 */
	public T getLast() {
		if(tail == null) {
			return null;
		}else {
			return tail.data;
		}
	}


	/**
	 * returns the first data in a list and removes the node from the lsit 
	 * @return
	 */
	public T retrieveFirstElement() {
		if(head == null) {
			return null;
		}else {

			Node curr = head.next;
			Node prev = head;

			head = curr;
			listSize--;
			return prev.data;
		}
	}

	/**
	 * returns the last data in a list and removes the node from the lsit 
	 * @return
	 */
	public T retrieveLastElement() {

		//if there is no nodes
		if(tail == null) {
			return null;
		}else {
			//setting reference nodes
			Node curr = head;
			Node prev = curr;

			//checking if there is only one item in the list 
			if(curr.next == null) {
				head = null;
				tail = null;
				return curr.data;
			}
			//iterates through the list 
			while(!(curr.next == null)) {
				prev = curr;
				curr = curr.next;
			}

			//sets proper pointers and returns the data
			tail = prev;
			prev.next = null;
			listSize--;
			return curr.data;
		}
	}


	/**
	 * removes all instances the data using target data and the comarator sent in 
	 * 
	 * @param targetData
	 * @param comparator
	 * @return the current object 
	 */
	public BasicLinkedList<T> remove(T targetData, java.util.Comparator<T> comparator){
		Node curr = head;
		Node prev = null;




		while((curr != null)) {

			//checking if the data match
			if(comparator.compare(curr.data, targetData) == 0) {
				//checks if it is first node
				if(curr == head) {
					head = head.next;
					curr = head;
					//checks if last node
				}else if(curr == tail){
					curr = null;
					tail = prev;
					prev.next = null;
				}else {
					prev.next = curr.next;
					curr = curr.next;
				}
				listSize--;

			}else {
				prev = curr;
				curr = curr.next;
			}


		}


		return this;
	}

	/**
	 * iterator for the linked list uses anon class
	 */
	public Iterator<T> iterator(){
		Iterator<T> itr = new Iterator<T>() {
			Node curr = head;

			@Override
			public boolean hasNext() {
				return curr != null;
			}

			@Override
			public T next() {
				if(hasNext()) {
					T data = curr.data;
					curr = curr.next;
					return data;
				}
				return null;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

		};

		return itr;
	}





	/**
	 * linked list to string for testing purposes 
	 */
	public String toString() {
		String result = "\" ";
		Node curr = head;

		while (curr != null) {
			result += curr.data + " ";

			curr = curr.next;
		}

		return result + "\"";
	}

	/**
	 * returns the data of the tail
	 * @return
	 */
	public T getTail() {
		return tail.data;
	}
	/**
	 * returns the data of the head
	 * @return
	 */
	public T getHead() {
		return head.data;
	}

	/**
	 * takes the current object and puts it reverse into an array list 
	 * uses a helper method getReverseArrayListHelper
	 * 
	 * @return array list 
	 */
	public ArrayList<T> getReverseArrayList(){
		ArrayList<T> returnList = new ArrayList<T>();
		BasicLinkedList<T> copyList = new BasicLinkedList<T>();
		//coping list
		for(T list: this) {
			copyList.addToEnd(list);
		}
		returnList.add(copyList.getReverseArrayListHelper(copyList, returnList));




		return returnList;

	}

	/**
	 * helper method for the reverseArrayList method
	 * takes the copied list and the array to put items in and puts the data in reverse 
	 * 
	 * @param copyList
	 * @param returnArray
	 * @return T data
	 */
	public T getReverseArrayListHelper(BasicLinkedList<T> copyList, ArrayList<T> returnArray) {
		T data = copyList.retrieveLastElement();
		//base case check
		if(head == null) {
			return data;
		}else {

			returnArray.add(data);
			return copyList.getReverseArrayListHelper(copyList, returnArray);
		}



	}

	/**
	 * reverses the current object into a new linked list 
	 * uses a helper method getReverseBasicListHelper
	 * 
	 * @return BasicLinkedList
	 */
	public BasicLinkedList<T> getReverseList(){
		BasicLinkedList<T> copyList = new BasicLinkedList<T>();
		BasicLinkedList<T> returnList = new BasicLinkedList<T>();
		//copies the linked list 
		for(T list: this) {
			copyList.addToEnd(list);

		}


		//calling helper
		returnList.addToFront(copyList.getReverseBasicListHelper(copyList, 
				returnList));
		returnList.listSize = this.listSize;





		return returnList;
	}

	
	/**
	 * helper method for reverseList 
	 * takes in the copied list and te return list and reverses the copylist into
	 * the returnList
	 * @param copyList
	 * @param returnList
	 * @return T data
	 */
	public T getReverseBasicListHelper(BasicLinkedList<T> copyList, BasicLinkedList<T> returnList) {
		//getting last element 
		
		T data = copyList.retrieveFirstElement();
		
		//base case check
		if(head == null) {
			return data;
		}else {
			//adding data 
			returnList.addToFront(data);

			return copyList.getReverseBasicListHelper(copyList, returnList);
		}



	}

}