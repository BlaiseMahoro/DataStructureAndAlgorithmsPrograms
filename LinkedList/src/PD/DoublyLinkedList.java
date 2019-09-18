package PD;
/**
 * 
 * @author Blaise Mahoro
 *
 */
public class DoublyLinkedList<E> implements Cloneable {
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
	public E[] toArrayFromFirst() {
		E [] array;
		array=(E[])new Object[size];
		Node<E> nodePtr=header.getNext();
		for(int i=0; i<size; i++) {
			array[i]=nodePtr.getElement();
			nodePtr=nodePtr.getNext();
		}
		return array;
	}
	/**
	 * @return an array of elements starting from the last
	 */
	public E[] toArrayFromLast() {
		E [] array;
		array=(E[])new Object[size];
		Node<E> nodePtr=trailer.getPrev();
		for(int i=0; i<size; i++) {
			array[i]=nodePtr.getElement();
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
