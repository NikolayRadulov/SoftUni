package arrays;

import java.util.Scanner;

public class ZigZagArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		for(int i = 0; i < n; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			if(i%2 == 0) {
				arr1[i] = num1;
				arr2[i] = num2;
			}
			else {
				arr2[i] = num1;
				arr1[i] = num2;
			}
		}
		for(int num: arr1) {
			System.out.print(num + " ");
		}
		System.out.println();
		for (int num: arr2) {
			System.out.print(num + " ");
		}
		
		
		sc.close();
	}

}
