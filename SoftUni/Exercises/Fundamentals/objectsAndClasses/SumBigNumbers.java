package objectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger num1 = new BigInteger(sc.nextLine());
		BigInteger num2 = new BigInteger(sc.nextLine());
		System.out.println(num1.add(num2));
		sc.close();
	}

}
