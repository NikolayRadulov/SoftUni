package module3;

import java.util.ArrayDeque;

public class StackAndQueue {

	public StackAndQueue() {
		stackTest();
	}
	
	private void stackTest() {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		while(!stack.isEmpty()) System.out.println(stack.pop()); 
		
	}

	public static void main(String[] args) {
		new StackAndQueue();

	}

}
