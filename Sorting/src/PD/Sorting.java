package PD;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;



public class Sorting{
	
	
	//Nested Linkedlist class 
	public static class DoublyLinkedList<E> implements Cloneable {
		//Nested Node class
		private static class Node<E>{
			private E  element;         //reference to the element stored
			private Node<E> prev;       //reference to the previous node
			private Node<E> next;       //reference to the next node
			public Node(E e, Node<E> p, Node<E> n) {
				element=e;
				prev=p;
				next=n;
			}
			public E getElement() {
				return element;		
			}
			public Node<E> getPrev(){
				return prev;
			}
			public Node<E> getNext(){
				return next;
			}
			public void setPrev(Node<E> p) {
				prev=p;
			}
			public void setNext(Node<E> n) {
				next=n;
			}
			
		}
		
		private Node<E> header;           //header sentinel
		private Node<E> trailer;          //trailer sentinel
		private int size=0;              //number of elements
		public DoublyLinkedList() {
			header = new Node<>(null,null,null);
			trailer = new Node<>(null,header,null);
			header.setNext(trailer);
		}
		/**
		 * @return number of Elements
		 */
		public int size() {
			return size;
		}
		
		public boolean isEmpty() {
			return size==0;
		}
		public E first() {
			if(isEmpty())
				return null;
			return header.getNext().getElement();
		}
		public E last() {
			if(isEmpty())
				return null;
			return trailer.getPrev().getElement();
		}
		private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
			Node<E> newest =new Node<>(e,predecessor,successor);
			predecessor.setNext(newest);
			successor.setPrev(newest);
			size++;
		}
		public void addFirst(E e) {
			addBetween(e,header,header.getNext());
		}
		public void addLast(E e) {
			addBetween(e,trailer.getPrev(),trailer);
		}
		private E remove(Node<E> node) {
			Node<E> predecessor=node.getPrev();
			Node<E> successor=node.getNext();
			predecessor.setNext(successor);
			successor.setPrev(predecessor);
			size--;
			return node.getElement();
		}
		public E removeFirst()
		{
			if(isEmpty())
				return null;
			return remove(header.getNext());
		}
		public E removeLast() {
			if(isEmpty())
				return null;
			return remove(trailer.getPrev());
		}
		/**
		 * 
		 * @return an array of elements starting from the first
		 */
		public String[] toArrayFromFirst() {
			String[] array;
			array=new String[size];
			Node<E> nodePtr=header.getNext();
			for(int i=0; i<size; i++) {
				array[i]=(String) nodePtr.getElement();
				nodePtr=nodePtr.getNext();
			}
			return array;
		}
		/**
		 * @return an array of elements starting from the last
		 */
		public String[] toArrayFromLast() {
			String [] array;
			array=new String[size];
			Node<E> nodePtr=trailer.getPrev();
			for(int i=0; i<size; i++) {
				array[i]=(String) nodePtr.getElement();
				nodePtr=nodePtr.getPrev();
			}
			return array;
		}
		/**
		 * 
		 * @return a doublyLinkedList that is a deep copy of the list
		 */
		public DoublyLinkedList<E> deepClone(){
			DoublyLinkedList<E> other;
			other = new DoublyLinkedList<E>();
		    Node<E> walk=header.getNext();
			if(size>0) {
				for(int i=0;i<size;i++) {
					other.addLast(walk.getElement());
					walk=walk.getNext();
				}
			}
			return other;
			
		}

	}

	
	public static void mergeSort(String[] S) {
		int n=S.length;
		if(n<2)return;
		
		int mid= n/2;
		String[] S1= Arrays.copyOfRange(S, 0, mid);
		String[] S2= Arrays.copyOfRange(S, mid, n);
		
		mergeSort(S1);
		mergeSort(S2);
		merge(S1,S2,S);
		
	}
	public static void merge(String[] S1, String[] S2,String[] S) {
		int i=0,j=0;
		while(i+j <S.length) { 
			if(j==S2.length||(i<S1.length&&S1[i].compareTo(S2[j]) <0))
				S[i+j]=S1[i++];
			else 
				S[i+j]=S2[j++];
			
		}
		
	}
	
	public static  void quickSortInPlace(String[ ] S, int a, int b) { 
		if (a >= b) return; // subarray is trivially sorted

			int left = a;
			int right = b-1;
			String pivot = S[b];
			String temp; // temp object used for swapping
		    while (left <= right) {  // scan until reaching value equal or larger than pivot (or right marker)
		    	while (left <= right && S[left].compareTo(pivot) < 0) left++;
		    	// scan until reaching value equal or smaller than pivot (or left marker)
		    	while (left <= right && S[right].compareTo(pivot) > 0) right--;
		    	if (left <= right) { // indices did not strictly cross
		    		// so swap values and shrink range
		    		temp = S[left]; 
		    		S[left] = S[right];
		    		S[right] = temp;
		    		left++; 
		    		right--;
		    	} 
		    } // put pivot into its final place (currently marked by left index)
			temp = S[left]; 
			S[left] = S[b];
			S[b] = temp;
		    // make recursive calls
			quickSortInPlace(S, a, left - 1);
		    quickSortInPlace(S, left + 1, b);
	}			
	

}
