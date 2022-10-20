package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int maxLength = -1;
		int length = 0;
		int endIndex = 0;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != arr[i-1]) {
				if(length > maxLength) {
					endIndex = i-1;
					maxLength = length;
				} 
				length = 0;
			}
			else length++;
		}
			if(length > maxLength) {
				endIndex = arr.length-1;
				maxLength = length;
			} 
		for(int i = endIndex - maxLength; i <= endIndex; i++) System.out.print(arr[i]+" ");
		sc.close();
	}

}
