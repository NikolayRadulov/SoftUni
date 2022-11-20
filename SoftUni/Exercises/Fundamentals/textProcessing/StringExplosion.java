package textProcessing;

import java.util.Scanner;

public class StringExplosion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder text = new StringBuilder(sc.nextLine());
		int index = 0;
		while(index < text.length()) {
			if(text.charAt(index) == '>') {
				int strength = Character.getNumericValue(text.charAt(index+1));
				index++;
				while(strength > 0 && index < text.length()) {
					if(text.charAt(index) == '>') {
						strength += Character.getNumericValue(text.charAt(index+1));
						index++;
					}
					text.deleteCharAt(index);
					strength--;
				}
			}
			else index++;
		}
		System.out.println(text.toString());
		sc.close();
	}

}
