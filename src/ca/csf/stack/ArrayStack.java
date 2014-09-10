package ca.csf.stack;

public class ArrayStack implements Stack {
	private int size;
	private Object[] objects;

	public ArrayStack(int initialSize) {
		size = 0;
		objects = new Object[initialSize];
	}

	public Object pop() {
		if (!isEmpty()) {
			size--;
			Object object = objects[size];

			return object;
		} else {
			return null;
		}
	}

	public void push(Object object) {
		if(size < objects.length){
			objects[size] = object;
			size++;
		} else {
			Object[] tmpObjects = objects.clone();
			objects = new Object[objects.length * 2];
			for(int i = 0; i < tmpObjects.length; ++i){
				objects[i] = tmpObjects[i];
			}
			objects[size++] = object;
		}
	}

	public Object peek() {
		if (!isEmpty()){
			return objects[size-1];
		} else {
			return null;
		}
	}

	public Object getAt(int position) {
		if(!isEmpty() && position <= size){
			return objects[position];
		} else {
			return null;
		}
	}

	public void clear() {
		size = 0;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getSize() {
		return size;
	}

	public String toString() {
		return "";
	}

}
