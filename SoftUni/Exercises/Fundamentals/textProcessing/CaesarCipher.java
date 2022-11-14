package textProcessing;

import java.util.Scanner;

public class CaesarCipher {

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		String encrypted = "";
		
		for (char sh : text.toCharArray()) {
			encrypted += (char)(sh+3);
		}
		
		System.out.println(encrypted);
		sc.close();
	}

}
