package arrays;

import java.util.Scanner;

public class CommonElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr1 = sc.nextLine().split(" ");
		String[] arr2 = sc.nextLine().split(" ");
		
		for(int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if(arr1[i].equals(arr2[j])) System.out.print(arr1[i] + " ");
			}
		}
		sc.close();
	}

}
