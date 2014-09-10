package ca.csf.stack;

public class ArrayStack implements Stack {
	private int size;
	private Object[] objects;

	public ArrayStack() {
		this.size = 0;
	}

	public ArrayStack(Stack stack) {

	}

	public Object pop() {
		if (this.size > 0) {
			Object object = objects[size];
			this.size -= 1;

			return object;
		} else {
			return null;
		}
	}

	public void push(Object object) {
		this.size += 1;
		this.objects[this.size] = object;
	}

	public Object peek() {
		return new Object();
	}

	public Object getAt(int position) {
		return new Object();
	}

	public void clear() {

	}

	public boolean isEmpty() {
		boolean isEmpty = false;

		if (this.size == 0) {
			isEmpty = true;
		}

		return isEmpty;
	}

	public int getSize() {
		return 0;
	}

	public String toString() {
		return "";
	}

}
