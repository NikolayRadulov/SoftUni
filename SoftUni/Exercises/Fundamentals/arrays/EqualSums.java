package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		for(int i = 0; i < arr.length; i++) {
			int sumLeft = 0;
			int sumRight = 0;
			for(int j = 0; j < i; j++) sumLeft += arr[j];
			for(int j = i+1; j < arr.length; j++) sumRight += arr[j];
			if(sumLeft == sumRight) {
				System.out.print(i);
				sc.close();
				return;
			}
		}
		System.out.println("no");
		sc.close();

	}

}
