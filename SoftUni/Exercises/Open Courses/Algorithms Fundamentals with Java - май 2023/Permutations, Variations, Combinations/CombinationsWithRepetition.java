package fundamentals.combinations;

import java.util.Scanner;

public class CombinationsWithRepetition {

	private static int[] combinations;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		int k = Integer.parseInt(sc.nextLine());
		
		combinations = new int[k];
		int[] arr = new int[n];
		for(int i = 1; i <= n; i++) {
			arr[i-1] = i;
		}
		
		combine(arr, 0, 0);
		
		sc.close();
	}
	
	private static void combine(int[] arr, int index, int start) {
		
		if(index == combinations.length) {
			String comb = new String();
			for(int num : combinations) {
				comb += num + " ";
			}
			System.out.println(comb.trim());
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			combinations[index] = arr[i];
			combine(arr, index+1, i + 1);
		}
		
	}

}
