package methods;

import java.util.Scanner;

public class MiddleCharacter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		findMiddleCharacters(sc.nextLine());
		sc.close();

	}

	private static void findMiddleCharacters(String word) {
		if(word.length() %2 == 0) {
			System.out.println(word.charAt(word.length()/2-1) + "" + word.charAt(word.length()/2));
		}
		else System.out.println(word.charAt(word.length()/2));
	}
}
