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
		if (!this.isEmpty()) {
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
		if (!this.isEmpty()){
			return this.objects[this.size];
		} else {
			return null;
		}
	}

	public Object getAt(int position) {
		if(!this.isEmpty() && position <= this.size){
			return this.objects[position];
		} else {
			return null;
		}
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
