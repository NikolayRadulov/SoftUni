package methods;

import java.util.Scanner;

public class SmallestOfThreeNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(minNumber(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		sc.close();
	}
	
	public static int minNumber(int... numbers) {
		int min = numbers[0];
		for(int i = 0; i < numbers.length; i++) if(numbers[i] < min) min = numbers[i];
		
		return min;
		
	}

}
