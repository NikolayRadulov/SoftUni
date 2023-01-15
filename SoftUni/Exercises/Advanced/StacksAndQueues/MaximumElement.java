package stacksAndQueus;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {

	public MaximumElement() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String...strings) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			String[] tokens = sc.nextLine().split("\\s+");
			
			switch (tokens[0]) {
				case "1": {
					stack.push(Integer.parseInt(tokens[1]));
				}
				break;
				case "2": {
					if(!stack.isEmpty())stack.pop();
				}
				break;
				case "3": {
					if(!stack.isEmpty())System.out.println(getMax(stack));
				}
			}
	  }
		sc.close();
	}
		private static int getMax(ArrayDeque<Integer> stack) {
			int max = Integer.MIN_VALUE;
			
			for (Integer integer : stack) {
				if (integer > max) max = integer;
			}
			
			return max;
		}
}
