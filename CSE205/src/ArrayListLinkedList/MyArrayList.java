// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: Two Array List & Linked List
// Author: Joseph H Cottingham | 1216723703
// Description: Implementaion of MyList to create a duplication for the java util ArrayList class

package ArrayListLinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList implements MyList {
	private int capacity = 16;
	private Object[] array = new Object[capacity];
	private int size = 0;

	@Override
	public void add(Object o) {
		size++;
		if (size == capacity) ensureCapacity(size * 2);
		array = Arrays.copyOf(array, capacity);
		array[size - 1] = o;
	}

	@Override
	public void insert(int index, Object o) {
		if (index < 0 || index > size) throw new NoSuchElementException();
		else {
			ensureCapacity(index);
			Object[] tempArray = new Object[capacity];
			for (int x = 0; x < index; x++) {
				tempArray[x] = array[x];
			}
			tempArray[index] = o;
			for (int x = size; x > index; x--) {
				tempArray[x] = array[x - 1];
			}
			size++;
			array = tempArray;
		}
	}

	@Override
	public void remove(int index) {
		if (index < 0 || index >= size) throw new NoSuchElementException();
		else {
			size--;
			Object[] tempArray = new Object[capacity];
			for (int x = 0; x < index; x++) tempArray[x] = array[x];
			for (int x = index; x < size; x++) tempArray[x] = array[x + 1];
			array = tempArray;
		}
	}

	@Override
	public Object get(int index) {
		if (index < 0 || index >= size) throw new NoSuchElementException();
		else return array[index];
	}

	@Override
	public int size() {
		return size;
	}

	public void ensureCapacity(int minCapacity) {
		if (minCapacity < 16) {
			array = Arrays.copyOf(array, 16);
			capacity = 16;
		} else {
			array = Arrays.copyOf(array, minCapacity);
			capacity = minCapacity;
		}
	}

	public void trimToSize() {
		ensureCapacity(size);
	}

	// Do not alter the code below 
	@Override
	public MyListIterator getIterator() {
		return new MyArrayListIterator();
	}

	private class MyArrayListIterator implements MyListIterator {
		int currentIndex = -1;

		@Override
		public Object next() {
			currentIndex++;
			return array[currentIndex];
		}

		@Override
		public boolean hasNext() {
			return currentIndex + 1 < size;
		}
	}
}
