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
			Object object = objects[0];
			
			for(int i = 0; i < size; ++i){
				objects[i] = objects[i+1];
			}
			size--;
			return object;
		} else {
			return null;
		}
	}

	public void push(Object object) {
		if(size >= objects.length){
			Object[] tmpObjects = objects.clone();
			objects = new Object[objects.length * 2];
			for(int i = 0; i < tmpObjects.length; ++i){
				objects[i] = tmpObjects[i];
			}
			objects[size++] = object;
		}
		
		for(int i = size; i > 0; --i){
			objects[i] = objects[i-1];
		}
		objects[0] = object;
		size++;
	}

	public Object peek() {
		if (!isEmpty()){
			return objects[0];
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
		for(int i = size; i > 0; --i){
			pop();
		}
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
