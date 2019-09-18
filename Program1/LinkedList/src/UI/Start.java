package UI;
import PD.*;

public class Start {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList list=new DoublyLinkedList<String>();
		DoublyLinkedList list_copy=new DoublyLinkedList<String>();
		
		list.addFirst("USA");
		list.addLast("Germany");
		list.addFirst("France");
		list.addLast("England");
		list.addFirst("Belgium");
		
		Object[] array;
		array=list.toArrayFromFirst();
		//Displays the list form first element
		System.out.println("List (From first):");
		for(int i=0; i<array.length;i++) {
			System.out.println(array[i]);
		}
		System.out.println("************************************************************************");
		array=list.toArrayFromLast();
		//Displays the list form last element
		System.out.println("List (From last):");
		for(int i=0; i<array.length;i++) {
			System.out.println(array[i]);
		}
		
		list_copy=list.deepClone();//list_copy is a deep copy of the list 
		
		array=list_copy.toArrayFromFirst();
		list.removeFirst();// In order to check if list_copy is a deep copy: we change list.
		
		System.out.println("*************************************************************************");
        //Displays list_copy from first element:Unchanged
		System.out.println("List_copy (From first-changed):");
		for(int i=0; i<array.length;i++) {
			System.out.println(array[i]);
		}
		
		System.out.println("*************************************************************************");
		array=list.toArrayFromFirst();
		//Displays list from first element:changed
		System.out.println("List (From first-changed):");
		for(int i=0; i<array.length;i++) {
			System.out.println(array[i]);
		}
	}

}
