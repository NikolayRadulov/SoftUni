package module3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StackExersise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i = 0; i < n; i++) {
			String command = sc.nextLine();
			if(command.length() > 1) {
				String[] tokens = command.split(" ");
				stack.push(Integer.parseInt(tokens[1]));
			}
			else if(command.equals("2")) {
				stack.pop();
			}
			else {
				System.out.println(findMax(stack));
			}
		}
		sc.close();
		
	}
	public static int findMax(ArrayDeque<Integer> stack) {
		if(stack.size() == 0) return 0;
		int max = Integer.MIN_VALUE;
		ArrayDeque<Integer> stackCopy = stack.clone();
		while(!stackCopy.isEmpty()) {
			int currentNum = stackCopy.pop();
			if(currentNum > max) max = currentNum;
		}
		return max;
	}

}
