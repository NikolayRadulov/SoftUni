package dataTypesAndVariables;

import java.util.Scanner;

public class IntegerOperations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = Integer.parseInt(sc.nextLine());
		int num2 = Integer.parseInt(sc.nextLine());
		int num3 = Integer.parseInt(sc.nextLine());
		int num4 = Integer.parseInt(sc.nextLine());
		System.out.printf("%.0f", (double)((num1+num2)/num3)*(double)num4);
		sc.close();
	}

}
