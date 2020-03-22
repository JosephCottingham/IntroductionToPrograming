// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: Stack & Queue
// Author: Joseph H Cottingham | 1216723703
// Description: Implementaion of IStack

package StackQueue;

import java.util.NoSuchElementException;

public class MyStack implements IStack {
	// add any necessary variables here
	private Object[] collection = new Object[0];
	private int size = 0;
	@Override
	public void push(Object item) {
		size++;
		Object[] tempCollection = new Object[size];
		for(int x = 1; x < size; x++){
			tempCollection[x] = collection[x-1];
		}
		tempCollection[0] = item;
		collection = tempCollection;
	}

	@Override
	public Object pop() {
		if(isEmpty()) throw new NoSuchElementException();
		size--;
		Object[] tempcollection = new Object[size];
		for(int x = 0; x < size; x++) tempcollection[x] = collection[x+1];
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
