package basicSyntaxConditionalStatementsLoops;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
		String correctPassword = "";
		for(int i = username.length()-1; i >= 0; i--) {
			correctPassword += username.charAt(i);
		}
		String password = sc.nextLine();
		for(int i = 0; i < 4; i++) {	
			System.out.println("Incorrect password. Try again.");	
			if(password.equals(correctPassword)) {
				System.out.printf("User %s logged in.", username);
				sc.close();
				return;
			}
			password = sc.nextLine();
		}
		System.out.printf("User %s blocked!", username);
		sc.close();
	}
}
