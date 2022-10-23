package methods;

import java.util.Scanner;

public class CharactersInRange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		printChars(sc.nextLine().charAt(0), sc.nextLine().charAt(0));
		sc.close();

	}
	
	private static void printChars(char first, char last) {
		for(char ch = (char)(Math.min(first, last)+1); ch < Math.max(first, last); ch++) {
			System.out.print(ch+" ");
		}
	}

}
