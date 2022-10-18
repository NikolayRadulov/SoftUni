package dataTypesAndVariables;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		int sum = 0;
		while(num > 0) {
			sum += num%10;
			num/=10;
		}
		System.out.println(sum);
		sc.close();
	}

}
