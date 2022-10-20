package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int k = Integer.parseInt(sc.nextLine());
		
		k = k%arr.length;
		for (int i = 0, j = k-1; i < j; i++, j--) {
			int buff = arr[i];
			arr[i] = arr[j];
			arr[j] = buff;
		}
		for (int i = k, j = arr.length-1; i < j; i++, j--) {
			int buff = arr[i];
			arr[i] = arr[j];
			arr[j] = buff;
		}
		for (int i = 0, j = arr.length-1; i < j; i++, j--) {
			int buff = arr[i];
			arr[i] = arr[j];
			arr[j] = buff;
		}
		
		for(int num : arr) System.out.print(num + " "); 
		sc.close();
	}

}
