package ca.csf.stack;

public class LinkedListStack implements Stack {
	private int size;
	private LinkedListStackNode lastStackNode;
	
	public LinkedListStack(){
		size = 0;
		lastStackNode = null;
	}
	
	public Object pop(){
		if(!isEmpty()){
			LinkedListStackNode nodeToRemove = lastStackNode;
			
			size--;
			
			if(size > 0){
				lastStackNode = nodeToRemove.getPreviousListStackNode();
			} else {
				lastStackNode = null;
			}	
			
			return nodeToRemove.getObject();
		} else {
			return null;
		}
		
	}
	
	public void push(Object object){;
		lastStackNode = new LinkedListStackNode(object, lastStackNode);
		size++;
	}
	
	public Object peek(){
		if(!isEmpty()){
		return lastStackNode.getObject();
		} else {
			return null;
		}
	}
	
	public Object getAt(int position){
		LinkedListStackNode node = lastStackNode;
		for(int i = 0; i < position; ++i){
			node = node.getPreviousListStackNode();
		}
		
		return node.getObject();
	}
	
	public void clear(){
		int listStackSize = size;
		for(int i = 0; i < listStackSize; ++i){
			pop();
		}
	}
	
	public boolean isEmpty(){
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getSize(){
		return size;
	}
	
	public String toString(){
		return "";
	}
}
