package textProcessing;

import java.util.Scanner;

public class CharacterMultiplier {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(multiply(sc.next(), sc.next()));
		sc.close();
	}

	private static int multiply(String word1, String word2) {
		int sum = 0;
		for (int i = 0; i < Math.max(word1.length(), word2.length()); i++) {
			if(i >= word1.length()) sum += word2.charAt(i);
			else if(i >= word2.length()) sum += word1.charAt(i);
			else sum += word1.charAt(i)*word2.charAt(i);
		}
		return sum;
	}
}
