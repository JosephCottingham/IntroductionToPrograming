// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: Stack & Queue
// Author: Joseph H Cottingham | 1216723703
// Description: Implementaion of IQueue

package StackQueue;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class MyQueue implements IQueue {
	// add any necessary variables here
	private Object[] collection = new Object[0];
	private int size = 0;

	@Override
	public void add(Object item) {
		size++;
		Object[] tempCollection = new Object[size];
		for(int x = 0; x < size-1; x++) tempCollection[x] = collection[x];
		tempCollection[size-1] = item;
		collection = tempCollection;
	}

	@Override
	public Object remove() {
		if(isEmpty()) throw new NoSuchElementException();
		size--;
		Object[] tempcollection = new Object[size];
		for(int x = size; x > 0; x--) tempcollection[x-1] = collection[x];
		Object o = collection[0];
		collection = tempcollection;
		return o;
	}

	@Override
	public Object peek() {
		if (isEmpty()) throw new NoSuchElementException();
		return collection[0];
	}

	@Override
	public int find(Object item) {
		for(int x = 0; x < size; x++) if (collection[x].toString().equals(item.toString())) return x;
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// add any necessary methods or classes below

}
