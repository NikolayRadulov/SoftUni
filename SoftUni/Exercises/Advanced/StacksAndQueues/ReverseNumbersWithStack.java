package stacksAndQueus;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class ReverseNumbersWithStack {

	public ReverseNumbersWithStack() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		for(int n:nums) {
			stack.push(n);
		}
		
		for (Iterator<Integer> iterator = stack.iterator(); iterator.hasNext();) {
			System.out.print(iterator.next()+" ");	
		}
		sc.close();
	}
}
