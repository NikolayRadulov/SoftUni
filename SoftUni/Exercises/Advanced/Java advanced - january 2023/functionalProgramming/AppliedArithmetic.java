package functionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class AppliedArithmetic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

		Consumer<int[]> add = new Consumer<int[]>() {
			@Override
			public void accept(int[] t) {
				for (int i = 0; i < arr.length; i++) {
					t[i]++;
				}
			}
		};
		Consumer<int[]> substract = new Consumer<int[]>() {
			@Override
			public void accept(int[] t) {
				for (int i = 0; i < arr.length; i++) {
					t[i]--;
				}
			}
		};
		Consumer<int[]> multiply = new Consumer<int[]>() {
			@Override
			public void accept(int[] t) {
				for (int i = 0; i < arr.length; i++) {
					t[i]*=2;
				}
			}
		};
		Consumer<int[]> print = new Consumer<int[]>() {
			@Override
			public void accept(int[] t) {
				for (int i = 0; i < arr.length; i++) {
					System.out.print(t[i]+" ");
				}
				System.out.println();
			}
		};

		String command = sc.nextLine();
		
		while (!command.equals("end")) {		
			switch (command) {
				case "add": add.accept(arr);
				break;
				case "subtract": substract.accept(arr);
				break;
				case "multiply": multiply.accept(arr);
				break;
				case "print": print.accept(arr);
				break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + command);
			}
			command = sc.nextLine();
		}
		sc.close();
	}

}
