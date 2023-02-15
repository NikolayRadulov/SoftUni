package stacksAndQueus;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicQueueOperations {

	public BasicQueueOperations() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		@SuppressWarnings("unused")
		int n = Integer.parseInt(sc.next());
		int s = Integer.parseInt(sc.next());
		int x = Integer.parseInt(sc.next());
		sc.nextLine();
		
		Arrays.stream(sc.nextLine().split("\\s+"))
		.map(Integer::parseInt)
		.collect(Collectors.toList())
		.forEach(queue::offer);
		
		for (int i = 0; i < s; i++) {
			queue.poll();
		}
		if (queue.isEmpty()) {
			System.out.println(0);
			sc.close();
			return;
		}
		
		if(queue.contains(x)) {
			System.out.println("true");
			sc.close();
			return;
		}
		else System.out.println(getMin(queue));
		
		sc.close();

	}
	
	private static int getMin(ArrayDeque<Integer> stack) {
		int min = Integer.MAX_VALUE;
		
		for (Integer integer : stack) {
			if (integer < min) min = integer;
		}
		
		return min;
	}

}
