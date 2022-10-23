package methods;

import java.util.Scanner;

public class PasswordValidator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(validate(sc.nextLine())) System.out.println("Password is valid");
		sc.close();
	}
	
	private static boolean validate(String password) {
		boolean length = checkLength(password.length());
	    boolean text = checkText(password);
	    boolean digits = checkDigits(password);
	    return length & text & digits;
	}
	
	private static boolean checkLength(int length) {
		if(length < 6 || length > 10) {
			System.out.println("Password must be between 6 and 10 characters");
			return false;
		}
		return true;
	}
	private static boolean checkText(String password) {
		for(char ch:password.toCharArray()) {
			if(!Character.isLetter(ch) && !Character.isDigit(ch)) {
				System.out.println("Password must consist only of letters and digits");
				return false;
			}
		}
		return true;
	}
	private static boolean checkDigits(String password) {
		int digits = 0;
		for(char ch:password.toCharArray()) if(Character.isDigit(ch)) digits++;
		if(digits < 2) {
			System.out.println("Password must have at least 2 digits");
			return false;
		}	
		return true;	
	}

}
