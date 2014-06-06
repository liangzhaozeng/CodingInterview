package interview.questions;

import java.util.Iterator;

public class ListIterator<Type> implements Iterable<Type> {

	 private Type[] arrayList;
	    private int currentSize;

	    public ListIterator(Type[] newArray) {
	        this.arrayList = newArray;
	        this.currentSize = arrayList.length;
	    }

	    @Override
	    public Iterator<Type> iterator() {
	        Iterator<Type> it = new Iterator<Type>() {


			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < currentSize && arrayList[currentIndex] != null;
			}

			@Override
			public Type next() {
				return arrayList[currentIndex++];
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
			}
		

		};
		return it;
	}

	public static void main(String[] args) {
		// create an array of type Integer
		Integer[] numbers = new Integer[] { 1, 2, 3, 4, 5 };

		// create your list and hold the values.
		ListIterator<Integer> stackOverflowList = new ListIterator<Integer>(numbers);

		// navigating the iterator
		Iterator<Integer> i = stackOverflowList.iterator();
		while (i.hasNext()) {
			Integer value =  i.next();
			if (i.hasNext()) {
				System.out.print(value + ", " );
			} else {
				System.out.print(value);
			}
		}

		// Since our class SOList is an instance of Iterable, then we can use it
		// on a foreach loop
		for (Integer num : stackOverflowList) {
			System.out.print(num);
		}

		// creating an array of Strings
		String[] languages = new String[] { "C", "C++", "Java", "Python", "Scala" };

		// create your list and hold the values using the same list
		// implementation.
		ListIterator<String> languagesList = new ListIterator<String>(languages);

		System.out.println("");
		// Since our class SOList is an instance of Iterable, then we can use it
		// on a foreach loop
		for (String lang : languagesList) {
			System.out.println(lang);
		}
	}

	
}
