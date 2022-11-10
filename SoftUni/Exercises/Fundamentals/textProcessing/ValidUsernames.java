package textProcessing;

import java.util.Scanner;

public class ValidUsernames {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] usernames = sc.nextLine().split(", ");
		
		i:for (String string : usernames) {
			if(string.length() < 3 || string.length() > 16) continue;
			for (char ch:string.toCharArray()) {
				if(!Character.isLetterOrDigit(ch) && ch != '-' && ch != '_') continue i;
			}
			System.out.println(string);
		}
		sc.close();
	}

}
