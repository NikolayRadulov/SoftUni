package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

		for(int i = 0; i < arr.length; i++) {
			boolean isTop = true;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] <= arr[j]) isTop = false;
			}
			if(isTop) System.out.print(arr[i] + " ");
		}
		sc.close();
	}

}
