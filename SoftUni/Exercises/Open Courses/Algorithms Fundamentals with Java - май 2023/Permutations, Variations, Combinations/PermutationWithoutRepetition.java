package fundamentals.combinations;

import java.util.Scanner;

public class PermutationWithoutRepetition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] arr = sc.nextLine().split("\\s+");
		
		permute(arr, 0);
		
		sc.close();
	}
	
	
	private static void permute(String[] arr, int index) {
		
		if(index == arr.length) {
			System.out.println(String.join(" ", arr));
			return;
		}
		
		permute(arr, index+1);
		
		for(int i = index + 1; i < arr.length; i++) {
			swap(arr, i, index);
			permute(arr, index+1);
			swap(arr, i, index);
		}
		
	}
	
	private static void swap(String[] arr, int index1, int index2) {
		String holder = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = holder;
	}

}
