
package fundamentals.combinations;

import java.util.Scanner;


public class VariationsWithRepetition {

	
	private static String[] variations;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] arr = sc.nextLine().split("\\s+");
		int k = Integer.parseInt(sc.nextLine());
		variations = new String[k];
		permute(arr, 0, k);
		
		sc.close();
	}
	
	
	private static void permute(String[] arr, int index, int k) {
		
		if(index == k) {
			System.out.println(String.join(" ", variations));
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			variations[index] = arr[i];
			permute(arr, index+1, k);
		}
		
	}

}
