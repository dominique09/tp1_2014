package ca.csf.stack;

public interface Stack {
	public Object pop();
	public void push(Object object);
	public Object peek();
	public Object getAt(int position);
	public void clear();
	public boolean isEmpty();
	public int getSize();
	public String toString();
}
