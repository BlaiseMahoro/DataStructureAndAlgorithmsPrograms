package UI;

import PD.Sorting;
import PD.Sorting.DoublyLinkedList;
import PD.StringComparator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoublyLinkedList<String> list= new DoublyLinkedList<String>();
		list.addFirst("USA");
		list.addLast("Germany");
		list.addFirst("Finland");
		list.addLast("England");
		list.addFirst("Belgium");
		list.addFirst("Brazil");
		list.addFirst("UK");
		
        String[] arrList;
        arrList=list.toArrayFromFirst();
		Sorting.quickSortInPlace(arrList, 0, arrList.length-1);
		//Sorting.mergeSort(arrList);
		for(int i=0; i<arrList.length;i++) {
			System.out.println(arrList[i]);
		}
	    //System.out.println(arrList);
	}

}
