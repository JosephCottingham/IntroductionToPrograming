package StackQueue;

import java.io.PrintStream;

public class Main {
	static int pass = 0;
	static int fail = 0;

	public static void main(String[] args) throws Exception {
		System.out.println("========== MyQueue Class Logic ==========");
		System.out.println(" Note: For these Queue Logic Tests visualizations");
		System.out.println("       the contents of a queue will grow to the right,");
		System.out.println("       with the front of the queue being on the left,");
		System.out.println("       and the back of the queue being on the right.");
		System.out.println("       Index values will also be counted from the left (front).");
		System.out.println();
		testMyQueueLogic();
		System.out.println("========== MyStack Class Logic ==========");
		System.out.println(" Note: For these Stack Logic Tests visualizations");
		System.out.println("       the contents of a stack will grow to the right,");
		System.out.println("       with the bottom of the stack being on the left,");
		System.out.println("       and the top of the stack being on the right.");
		System.out.println("       Index values will also be counted from the right (top).");
		System.out.println();
		testMyStackLogic();
		System.out.println("-------------------------------------------------");
		System.out.println("Passed: " + pass);
		System.out.println("Failed: " + fail);
		System.out.println("        --------");
		System.out.printf ("        %.2f %% correct\n", (float)pass / (fail + pass) * 100);
		System.out.println("-------------------------------------------------");
	}

	private static void testMyQueueLogic() throws Exception {
		// After default constructor, size() returns 0
		IQueue queue = new MyQueue();
		int expectedSize = 0;
		int actualSize = queue.size();
		count(assertEqual(System.out, expectedSize, actualSize,
				"After default constructor, size() returns 0"));

		// After default constructor, isEmpty() returns true
		boolean expectedBool = true;
		boolean actualBool = queue.isEmpty();
		count(assertEqual(System.out, expectedBool, actualBool,
				"After default constructor, isEmpty() returns true"));

		// After default constructor, and add(100), size() returns 1
		queue.add(100);
		expectedSize = 1;
		actualSize = queue.size();
		count(assertEqual(System.out, expectedSize, actualSize,
				"After default constructor, and add(100), size() returns 1"));


		// After default constructor, and add(100), isEmpty() returns false
		expectedBool = false;
		actualBool = queue.isEmpty();
		count(assertEqual(System.out, expectedBool, actualBool,
				"After default constructor, and add(100), isEmpty() returns false"));

		// After default constructor, and add(100), peek() returns 100
		int expectedValue = 100;
		int actualValue = (int) queue.peek();
		count(assertEqual(System.out, expectedValue, actualValue,
				"After default constructor, and add(100), peek() returns 100"));

		// With a current queue of {100}, and add(200), size() returns 2
		queue.add(200);
		expectedSize = 2;
		actualSize = queue.size();
		count(assertEqual(System.out, expectedSize, actualSize,
				"With a current queue of {100}, and add(200), size() returns 2"));


		// With a current queue of {100,200}, peek() returns 100
		expectedValue = 100;
		actualValue = (int) queue.peek();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {100,200}, peek() returns 100"));

		// With a current queue of {100,200}, and add(300), size() returns 3
		queue.add(300);
		expectedSize = 3;
		actualSize = queue.size();
		count(assertEqual(System.out, expectedSize, actualSize,
				"With a current queue of {100,200}, and add(300), size() returns 3"));

		// With a current queue of {100,200,300}, peek() returns 100
		expectedValue = 100;
		actualValue = (int) queue.peek();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {100,200,300}, peek() returns 100"));

		// With a current queue of {100,200,300}, find(100) returns 0
		expectedValue = 0;
		actualValue = queue.find(100);
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {100,200,300}, find(100) returns 0"));

		// With a current queue of {100,200,300}, find(200) returns 1
		expectedValue = 1;
		actualValue = queue.find(200);
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {100,200,300}, find(200) returns 1"));

		// With a current queue of {100,200,300}, find(300) returns 2
		expectedValue = 2;
		actualValue = queue.find(300);
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {100,200,300}, find(300) returns 2"));

		// With a current queue of {100,200,300}, find(999) returns -1
		expectedValue = -1;
		actualValue = queue.find(999);
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {100,200,300}, find(999) returns -1"));

		// With a current queue of {100,200,300}, remove() returns 100
		expectedValue = 100;
		actualValue = (int) queue.remove();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {100,200,300}, remove() returns 100"));

		// With a current queue of {100,200,300}, after remove(), size() returns 2
		expectedValue = 2;
		actualValue = queue.size();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {100,200,300}, after remove(), size() returns 2"));

		// With a current queue of {200,300}, after remove(), peek() returns 200
		expectedValue = 200;
		actualValue = (int) queue.peek();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {200,300}, after remove(), peek() returns 200"));

		// With a current queue of {200,300}, remove() returns 200
		expectedValue = 200;
		actualValue = (int) queue.remove();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {200,300}, remove() returns 200"));

		// With a current queue of {200,300}, after remove(), size() 1
		expectedValue = 1;
		actualValue = queue.size();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {200,300}, after remove(), size() 1"));

		// With a current queue of {300}, after remove(), peek() returns 300
		expectedValue = 300;
		actualValue = (int) queue.peek();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {300}, after remove(), peek() returns 300"));

		// With a current queue of {300}, remove() returns 300
		expectedValue = 300;
		actualValue = (int) queue.remove();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {300}, remove() returns 300"));

		// With a current queue of {300}, after remove(), size() returns 0
		expectedValue = 0;
		actualValue = queue.size();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current queue of {300}, after remove(), size() returns 0"));

		// With a current queue of {300}, after remove(), isEmpty() returns true
		expectedBool = true;
		actualBool = queue.isEmpty();
		count(assertEqual(System.out, expectedBool, actualBool,
				"With a current queue of {300}, after remove(), isEmpty() returns true"));

		// Given an empty queue, after adding 100 items (numbers 1-100), size() returns 100
		queue = new MyQueue();
		for (int i = 1; i <= 100; i++) queue.add(i);
		expectedValue = 100;
		actualValue = queue.size();
		count(assertEqual(System.out, expectedValue, actualValue,
				"Given an empty queue, after adding 100 items (numbers 1-100), size() returns 100"));

		// Given an empty queue, after adding 100 items (numbers 1-100), isEmpty() returns false
		expectedBool = false;
		actualBool = queue.isEmpty();
		count(assertEqual(System.out, expectedBool, actualBool,
				"Given an empty queue, after adding 100 items (numbers 1-100), isEmpty() returns false"));

		// Given an empty queue, after adding 100 items (numbers 1-100), find(100) returns 99
		expectedValue = 99;
		actualValue = queue.find(100);
		count(assertEqual(System.out, expectedValue, actualValue,
				"Given an empty queue, after adding 100 items (numbers 1-100), find(100) returns 99"));

		// Given an empty queue, after adding 100 items (numbers 1-100), find(1) returns 0
		expectedValue = 0;
		actualValue = queue.find(1);
		count(assertEqual(System.out, expectedValue, actualValue,
				"Given an empty queue, after adding 100 items (numbers 1-100), find(1) returns 0"));

		// Given an empty queue, after adding 100 items (numbers 1-100), then removing 50 items, size() returns 50
		for (int i = 1; i <= 50; i++) queue.remove();
		expectedValue = 50;
		actualValue = queue.size();
		count(assertEqual(System.out, expectedValue, actualValue,
				"Given an empty queue, after adding 100 items (numbers 1-100), then removing 50 items, size() returns 50"));

		// Given an empty queue, after adding 100 items (numbers 1-100), then removing 50 items, peek() returns 51
		expectedValue = 51;
		actualValue = (int) queue.peek();
		count(assertEqual(System.out, expectedValue, actualValue,
				"Given an empty queue, after adding 100 items (numbers 1-100), then removing 50 items, peek() returns 51"));
	}


	private static void testMyStackLogic() throws Exception {
		// After default constructor, size() returns 0
		IStack stack = new MyStack();
		int expectedSize = 0;
		int actualSize = stack.size();
		count(assertEqual(System.out, expectedSize, actualSize,
				"After default constructor, size() returns 0"));

		// After default constructor, isEmpty() returns true
		boolean expectedBool = true;
		boolean actualBool = stack.isEmpty();
		count(assertEqual(System.out, expectedBool, actualBool,
				"After default constructor, isEmpty() returns true"));

		// After default constructor, and push(100), size() returns 1
		stack.push(100);
		expectedSize = 1;
		actualSize = stack.size();
		count(assertEqual(System.out, expectedSize, actualSize,
				"After default constructor, and push(100), size() returns 1"));


		// After default constructor, and push(100), isEmpty() returns false
		expectedBool = false;
		actualBool = stack.isEmpty();
		count(assertEqual(System.out, expectedBool, actualBool,
				"After default constructor, and push(100), isEmpty() returns false"));

		// After default constructor, and push(100), peek() returns 100
		int expectedValue = 100;
		int actualValue = (int) stack.peek();
		count(assertEqual(System.out, expectedValue, actualValue,
				"After default constructor, and push(100), peek() returns 100"));

		// With a current stack of {100}, and push(200), size() returns 2
		stack.push(200);
		expectedSize = 2;
		actualSize = stack.size();
		count(assertEqual(System.out, expectedSize, actualSize,
				"With a current stack of {100}, and push(200), size() returns 2"));


		// With a current stack of {100,200}, peek() returns 200
		expectedValue = 200;
		actualValue = (int) stack.peek();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100,200}, peek() returns 200"));

		// With a current stack of {100,200}, and push(300), size() returns 3
		stack.push(300);
		expectedSize = 3;
		actualSize = stack.size();
		count(assertEqual(System.out, expectedSize, actualSize,
				"With a current stack of {100,200}, and push(300), size() returns 3"));

		// With a current stack of {100,200,300}, peek() returns 300
		expectedValue = 300;
		actualValue = (int) stack.peek();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100,200,300}, peek() returns 300"));

		// With a current stack of {100,200,300}, find(100) returns 2
		expectedValue = 2;
		actualValue = stack.find(100);
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100,200,300}, find(100) returns 2"));

		// With a current stack of {100,200,300}, find(200) returns 1
		expectedValue = 1;
		actualValue = stack.find(200);
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100,200,300}, find(200) returns 1"));

		// With a current stack of {100,200,300}, find(300) returns 0
		expectedValue = 0;
		actualValue = stack.find(300);
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100,200,300}, find(300) returns 0"));

		// With a current stack of {100,200,300}, find(999) returns -1
		expectedValue = -1;
		actualValue = stack.find(999);
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100,200,300}, find(999) returns -1"));

		// With a current stack of {100,200,300}, pop() returns 300
		expectedValue = 300;
		actualValue = (int) stack.pop();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100,200,300}, pop() returns 300"));

		// With a current stack of {100,200,300}, after pop(), size() returns 2
		expectedValue = 2;
		actualValue = stack.size();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100,200,300}, after pop(), size() returns 2"));

		// With a current stack of {100,200,300}, after pop(), peek() returns 200
		expectedValue = 200;
		actualValue = (int) stack.peek();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100,200,300}, after pop(), peek() returns 200"));

		// With a current stack of {100,200}, pop() returns 200
		expectedValue = 200;
		actualValue = (int) stack.pop();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100,200}, pop() returns 200"));

		// With a current stack of {100,200}, after pop(), size() 1
		expectedValue = 1;
		actualValue = stack.size();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100,200}, after pop(), size() 1"));

		// With a current stack of {100,200}, after pop(), peek() returns 100
		expectedValue = 100;
		actualValue = (int) stack.peek();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100,200}, after pop(), peek() returns 100"));

		// With a current stack of {100}, pop() returns 100
		expectedValue = 100;
		actualValue = (int) stack.pop();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100}, pop() returns 100"));

		// With a current stack of {100}, after pop(), size() returns 0
		expectedValue = 0;
		actualValue = stack.size();
		count(assertEqual(System.out, expectedValue, actualValue,
				"With a current stack of {100}, after pop(), size() returns 0"));

		// With a current stack of {100}, after pop(), isEmpty() returns true
		expectedBool = true;
		actualBool = stack.isEmpty();
		count(assertEqual(System.out, expectedBool, actualBool,
				"With a current stack of {100}, after pop(), isEmpty() returns true"));

		// Given an empty stack, after pushing 100 items (numbers 1-100), size() returns 100
		stack = new MyStack();
		for (int i = 1; i <= 100; i++) stack.push(i);
		expectedValue = 100;
		actualValue = stack.size();
		count(assertEqual(System.out, expectedValue, actualValue,
				"Given an empty stack, after adding 100 items (numbers 1-100), size() returns 100"));

		// Given an empty stack, after pushing 100 items (numbers 1-100), isEmpty() returns false
		expectedBool = false;
		actualBool = stack.isEmpty();
		count(assertEqual(System.out, expectedBool, actualBool,
				"Given an empty stack, after adding 100 items (numbers 1-100), isEmpty() returns false"));

		// Given an empty stack, after pushing 100 items (numbers 1-100), find(100) returns 0
		expectedValue = 0;
		actualValue = stack.find(100);
		count(assertEqual(System.out, expectedValue, actualValue,
				"Given an empty stack, after adding 100 items (numbers 1-100), find(100) returns 0"));

		// Given an empty stack, after pushing 100 items (numbers 1-100), find(1) returns 99
		expectedValue = 99;
		actualValue = stack.find(1);
		count(assertEqual(System.out, expectedValue, actualValue,
				"Given an empty stack, after adding 100 items (numbers 1-100), find(1) returns 99"));

		// Given an empty stack, after pushing 100 items (numbers 1-100), then popping 50 items, size() returns 50
		for (int i = 1; i <= 50; i++) stack.pop();
		expectedValue = 50;
		actualValue = stack.size();
		count(assertEqual(System.out, expectedValue, actualValue,
				"Given an empty stack, after adding 100 items (numbers 1-100), then popping 50 items, size() returns 50"));

		// Given an empty stack, after pushing 100 items (numbers 1-100), then popping 50 items, peek() returns 50
		expectedValue = 50;
		actualValue = (int) stack.peek();
		count(assertEqual(System.out, expectedValue, actualValue,
				"Given an empty stack, after adding 100 items (numbers 1-100), then popping 50 items, peek() returns 50"));
	}

	private static void count(boolean testResult) {
		if (testResult)
			pass++;
		else
			fail++;
	}

	private static boolean assertEqual(PrintStream out, int expected, int actual, String message) {
		if (expected == actual) {
			out.println("PASS - " + message);
			out.println();
			return true;
		} else {
			out.println("FAIL - " + message);
			out.printf ("!!!!   expected[%d] but got [%d]\n\n", expected, actual);
			return false;
		}
	}

	private static boolean assertEqual(PrintStream out, double expected, double actual, String message) {
		if (expected == actual) {
			out.println("PASS - " + message);
			out.println();
			return true;
		} else {
			out.println("FAIL - " + message);
			out.printf ("!!!!   expected[%f] but got [%f]\n\n", expected, actual);
			return false;
		}
	}

	private static boolean assertEqual(PrintStream out, boolean expected, boolean actual, String message) {
		if (expected == actual) {
			out.println("PASS - " + message);
			out.println();
			return true;
		} else {
			out.println("FAIL - " + message);
			out.printf ("!!!!   expected[%b] but got [%b]\n\n", expected, actual);
			return false;
		}
	}
}
