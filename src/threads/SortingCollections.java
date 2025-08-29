package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

import has_a_relationship.new1;

public class SortingCollections {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(100);
		arrayList.add(50);
		arrayList.add(150);
		arrayList.add(25);
		arrayList.add(175);
		arrayList.add(125);
		arrayList.add(75);
		System.out.println(arrayList);
		Collections.sort(arrayList);
		System.out.println(arrayList);
		System.out.println("=================");
		//Iterators are the cursor that point to the objects
		Iterator<Integer> iterator = arrayList.iterator();
		while(iterator.hasNext()==true) {
			System.out.println(iterator.next());
		}
		System.out.println("=================");
		ListIterator<Integer> litr = arrayList.listIterator();
		while(litr.hasNext()==true) {
			System.out.println(litr.next());
		}
		System.out.println("=================");
		ListIterator<Integer> litr1 = arrayList.listIterator(arrayList.size());
		while(litr1.hasPrevious()==true) {
			System.out.println(litr1.previous());
		}
	}
}










