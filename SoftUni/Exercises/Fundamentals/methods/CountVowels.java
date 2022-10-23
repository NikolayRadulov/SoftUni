package methods;

import java.util.Scanner;

public class CountVowels {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		System.out.println(countVowels(sc.nextLine()));
		sc.close();
	}
	
	private static int countVowels(String text) {
		int counter = 0;
		for(char ch:text.toCharArray()) {
			char a = Character.toLowerCase(ch);
			if(a == 'a' || a == 'o' || a == 'e' || a == 'i' || a == 'u') counter++;
		}
		return counter;
	} 

}
