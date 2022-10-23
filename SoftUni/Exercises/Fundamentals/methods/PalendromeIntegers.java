package methods;

import java.util.Scanner;

public class PalendromeIntegers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		while(!command.equals("END")) {
			int num = Integer.parseInt(command);
			if(isPalendrome(num)) System.out.println(true);
			else System.out.println(false);
			
			command = sc.nextLine();
		}
		sc.close();
	}

	private static boolean isPalendrome(int num) {
		String str = String.valueOf(num);
		for(int i = 0, j = str.length()-1; i < j; i++, j--) {
			if(str.charAt(i) != str.charAt(j)) return false;
		}
		
		return true;
	}
}
